package com.example.javademo.service.serviceImpl;

import com.example.javademo.dao.UserInfoMapper;
import com.example.javademo.entity.UserInfoEntity;
import com.example.javademo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int login() {
        return 0;
    }

    @Override
    public void signUp(UserInfoEntity userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public void updateUser(UserInfoEntity userInfo) {
        userInfoMapper.updateUser(userInfo);
    }

    @Override
    public void updateMap(Map<String, Object> map) {

    }

    @Override
    public List<UserInfoEntity> findAllUser() {
        return userInfoMapper.findAllUser();
    }

    @Override
    public UserInfoEntity getUserById(String id) {
        return userInfoMapper.getUserById(id);
    }

    @Override
    public List<UserInfoEntity> selectAllUser(int startIndex, int pageSize) {
        PageHelper.offsetPage(startIndex, pageSize);
        List<UserInfoEntity> userInfoEntityList = userInfoMapper.selectAllUser();
        PageHelper.clearPage();
        return userInfoEntityList;
    }
}
