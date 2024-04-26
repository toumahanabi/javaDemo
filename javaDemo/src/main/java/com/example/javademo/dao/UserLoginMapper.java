package com.example.javademo.dao;

import com.example.javademo.entity.UserLoginEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {

    void insertUserLogin(UserLoginEntity userLogin);
}
