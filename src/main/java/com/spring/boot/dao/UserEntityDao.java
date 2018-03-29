package com.spring.boot.dao;

import com.spring.boot.core.base.mongo.BaseMongoDaoImpl;
import com.spring.boot.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author zengfy
 */
@Service
public class UserEntityDao extends BaseMongoDaoImpl<UserEntity> {
}
