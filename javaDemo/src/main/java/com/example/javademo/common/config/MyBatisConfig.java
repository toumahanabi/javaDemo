package com.example.javademo.common.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

//@Configuration
public class MyBatisConfig {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // load MyBatis XML
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            // init SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MyBatis SqlSessionFactory", e);
        }
    }

    //auto commit default false
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
