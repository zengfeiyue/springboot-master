package com.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.spring.boot.core.base.mongo.Page;
import com.spring.boot.dao.TestMapper;
import com.spring.boot.dao.UserEntityDao;
import com.spring.boot.dao.security.SysUserMapper;
import com.spring.boot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue  zfy on 2017/8/24.
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserEntityDao userEntityDao;

    @RequestMapping("/test")
    public String test1(){
        /*UserEntity userEntity = new UserEntity();
        userEntity.setUserName("zzz");
        userEntity.setPassWord("zzzz");
        userEntityDao.save(userEntity);*/
        /*UserEntity userEntity2 = userEntityDao.findById("5abc5ad7aaa4c7335c10dc98");*/
        /*List<UserEntity> list = userEntityDao.findAll();*/
        /*List<UserEntity> list = userEntityDao.find(query);*/
        /*Query query = new Query(Criteria.where("passWord").is("zzzz").and("userName").is("zzz"));
        Page<UserEntity> page = new Page<UserEntity>();
        page.setPageSize(2);
        page.setCurrentPage(3);
        Page<UserEntity> pages = userEntityDao.findPage(page, query);*/
        Query query = new Query(Criteria.where("_id").is("5abc5ad7aaa4c7335c10dc98"));
        Update update =new Update();
        update.set("passWord", "zfyzz12345567");
        UserEntity userEntity = userEntityDao.updateOne(query, update);

        System.err.println(JSON.toJSONString(userEntity));
       return null;
    }

    @RequestMapping("/test2")
    public String test2(){
        List<Map>  list = testMapper.select2("33");
        for (Map map:list) {
            System.err.println(map.get("value"));
        }
        System.out.println(list.size());
        return null;
    }
    @CacheEvict(value = {"select2"}, allEntries = true)
    @RequestMapping("/test3")
    public String test3(){

        return "1213";
    }
    @CacheEvict(value = {"select"}, allEntries = true)
    @RequestMapping("/test4")
    public String test4(){

        return "1213";
    }
}
