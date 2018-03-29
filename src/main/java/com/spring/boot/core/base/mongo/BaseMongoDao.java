package com.spring.boot.core.base.mongo;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * mongodb基本操作接口
 * @author zengfeiyue
 */
public interface BaseMongoDao<T> {
    /**
     * 插入
     * @param entity
     * @return
     */
    public T save(T entity);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     * @param id
     * @param collectionName
     * @return
     */
    public T findById(String id, String collectionName);

    /**
     * 获得所有该类型记录
     * @return
     */
    public List<T> findAll();

    /**
     * 获得所有该类型记录,并且指定了集合名(表的意思)
     * @param collectionName
     * @return
     */
    public List<T> findAll(String collectionName);

    /**
     * 根据条件查询
     * @param query
     * @return
     */
    public List<T> find(Query query);

    /**
     * 根据条件查询一个
     * @param query
     * @return
     */
    public T findOne(Query query);

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    public Page<T> findPage(Page<T> page, Query query);

    /**
     * 根据条件获得总数
     * @param query
     * @return
     */
    public long count(Query query);

    /**
     * 根据条件更新
     * @param query
     * @param update
     * @return
     */
    public WriteResult update(Query query, Update update);

    /**
     * 更新符合条件并sort之后的第一个文档 并返回更新后的文档
     * @param query
     * @param update
     * @return
     */
    public T updateOne(Query query, Update update);

}
