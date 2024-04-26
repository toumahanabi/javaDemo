package com.example.javademo.dao;

import com.example.javademo.common.config.MyBatisConfig;
import com.example.javademo.entity.Dept;
import com.example.javademo.entity.InfoEntity;
import com.example.javademo.entity.Team;
import com.example.javademo.entity.UserInfoEntity;
import com.github.javafaker.Faker;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoMapperTest {

    @Test
    public void test(){

        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfoEntity> userInfoEntityList = userInfoMapper.findAllUser();
        for (UserInfoEntity userInfoEntity : userInfoEntityList) {
            System.out.println(userInfoEntity);
        }

        sqlSession.close();
    }

    @Test
    public void test2(){

        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfo = new UserInfoEntity("0004", "David", "1815555", "David@fujitsu.com", "101", "0"
                , LocalDateTime.now(), LocalDateTime.now()
                , null, false);
        userInfoMapper.insertUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfo = userInfoMapper.getUserById("1");
        sqlSession.close();
        System.out.println(userInfo);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfo = new UserInfoEntity("0003", "Liw", null, "Liw@fujitsu.com", "101","1"
                , LocalDateTime.now(), LocalDateTime.now()
                , null, false);
        userInfoMapper.updateUser(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfo = new UserInfoEntity("0003", "Liw", null, "Liw@fujitsu.com", "101","1"
                , LocalDateTime.now(), LocalDateTime.now()
                , null, true);
        userInfoMapper.updateUser(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "0003");
        map.put("userName", "Li");
        userInfoMapper.updateMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfoEntity> userInfo = userInfoMapper.getUserLike("i");
        sqlSession.close();

        for (UserInfoEntity userInfoEntity : userInfo) {
            System.out.println(userInfoEntity);
        }

    }

    @Test
    public void test8(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        HashMap<String, Object> limitMap = new HashMap<>();
        limitMap.put("startIndex", 0);
        limitMap.put("pageSize", 1);
        List<UserInfoEntity> userInfo = userInfoMapper.getListByLimit(limitMap);
        sqlSession.close();

        for (UserInfoEntity userInfoEntity : userInfo) {
            System.out.println(userInfoEntity);
        }

    }

    @Test
    public void test9(){
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<UserInfoEntity> userInfo = sqlSession.selectList("com.example.javademo.dao.UserInfoMapper.getListByRowBounds", null, rowBounds);
        sqlSession.close();

        for (UserInfoEntity userInfoEntity : userInfo) {
            System.out.println(userInfoEntity);
        }

    }

    @Test
    public void test10() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfo = userInfoMapper.getActiveUserById("0001", false);
        sqlSession.close();
        System.out.println(userInfo);
    }

    @Test
    public void test11() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        List<Object> userInfoEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Faker faker = new Faker();
            HashMap<String, Object> userMap = new HashMap<>();
            String chineseName = faker.name().fullName();
            String englishName = faker.name().fullName();
            String phoneNumber = faker.phoneNumber().cellPhone();
            String email = faker.internet().emailAddress();
            userMap.put("userId", "000" + (i + 5) );
            userMap.put("userName", englishName);
            userMap.put("contactInfo", phoneNumber);
            userMap.put("email", email);
            userMap.put("userPermission", "0");
            userMap.put("createdDate", LocalDateTime.now());
            userMap.put("modifiedDate", LocalDateTime.now());
            userInfoMapper.addUserInfo(userMap);
            sqlSession.commit();
            userInfoEntityList.add(userMap);
        }

        sqlSession.close();
        for (Object o : userInfoEntityList) {
            System.out.println(o);
        }
    }

    @Test
    public void test12() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<InfoEntity> info = userInfoMapper.getInfo2();
        sqlSession.close();
        for (InfoEntity infoEntity : info) {
            System.out.println(infoEntity);
        }
    }

    @Test
    public void test13() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<InfoEntity> info = userInfoMapper.getInfo1();
        sqlSession.close();
        for (InfoEntity infoEntity : info) {
            System.out.println(infoEntity);
        }
    }

    @Test
    public void test14() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<Team> info = userInfoMapper.getUserInfoList1("100");
        sqlSession.close();
        for (Team team : info) {
            System.out.println(team);
        }
    }

    @Test
    public void test15() {
        SqlSession sqlSession = MyBatisConfig.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<Team> info = userInfoMapper.getUserInfoList2("100");
        sqlSession.close();
        for (Team team : info) {
            System.out.println(team);
        }
    }
}
