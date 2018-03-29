package com.spring.boot.core.base.mongo;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * mongodb基本操作实现
 * @author zengfeiyue
 */
public class BaseMongoDaoImpl<T> implements BaseMongoDao<T> {
    /**
     * spring mongodb　集成操作类　
     */
    @Resource
    protected MongoTemplate mongoTemplate;

    /**
     * 注入mongodbTemplate
     *
     * @param mongoTemplate
     */
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    @Override
    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    @Override
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(this.getEntityClass());
    }

    @Override
    public List<T> findAll(String collectionName) {
        return mongoTemplate.findAll(this.getEntityClass(), collectionName);
    }

    @Override
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    @Override
    public Page<T> findPage(Page<T> page, Query query) {
        //如果没有条件 则所有全部
        query=query==null?new Query(Criteria.where("_id").exists(true)):query;
        long count = this.count(query);
        // 总数
        page.setTotalCount((int) count);
        int currentPage = page.getCurrentPage();
        int pageSize = page.getPageSize();
        query.skip((currentPage - 1) * pageSize).limit(pageSize);
        List<T> rows = this.find(query);
        page.build(rows);
        return page;
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, this.getEntityClass());
    }

    @Override
    public WriteResult update(Query query, Update update) {
        if (update==null) {
            return null;
        }
        return mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }
    @Override
    public T updateOne(Query query, Update update) {
        if (update==null) {
            return null;
        }
        return mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    public Class<T> getEntityClass() {
        Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return entityClass;
    }
}
