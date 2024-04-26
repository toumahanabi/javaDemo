package com.example.javademo.controller;

import com.example.javademo.common.config.MyBatisConfig;
import com.example.javademo.dao.UserInfoMapper;
import com.example.javademo.entity.UserEntity;
import com.example.javademo.entity.UserInfoEntity;
import com.example.javademo.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/hello")
    public String Hello(){
        return "hello world";
    }

    @RequestMapping("/loginUserInfo")
    public List<UserEntity> getLoginUserList(){
        List<UserEntity> userList = new ArrayList<>();
        UserEntity user1 = new UserEntity(1, "zs", "张三", "123456");
        UserEntity user2 = new UserEntity(2, "ls", "李四", "2333");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    @RequestMapping("/login")
    public void getLogin(){

    }

    @RequestMapping("/signUp")
    public void signUp(){
        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setUserId("0001");
        userInfo.setUserName("John");
        userInfo.setContactInfo("123456789");
        userInfo.setEmail("john@example.com");
        userService.signUp(userInfo);
    }

    @RequestMapping("/sqlSession")
    public void sqlSession(){

        SqlSession sqlSession = MyBatisConfig.getSqlSession();

        try{
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            List<UserInfoEntity> userInfoEntityList = userInfoMapper.findAllUser();
            for (UserInfoEntity userInfoEntity : userInfoEntityList) {
                System.out.println(userInfoEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @RequestMapping("/findAllUser")
    public List<UserInfoEntity> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/selectAllUser")
    public List<UserInfoEntity> selectAllUser(){
        return userService.selectAllUser(1,2);
    }
}
