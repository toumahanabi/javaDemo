package com.example.javademo.service;

import com.example.javademo.entity.UserInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    int login();

    void signUp(UserInfoEntity userInfo);

    void updateUser(UserInfoEntity userInfo);

    void updateMap(Map<String, Object> map);

    List<UserInfoEntity> findAllUser();

    UserInfoEntity getUserById(String id);

    List<UserInfoEntity> selectAllUser(int startIndex, int pageSize);
}
