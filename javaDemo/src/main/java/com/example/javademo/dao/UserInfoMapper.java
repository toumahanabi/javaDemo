package com.example.javademo.dao;

import com.example.javademo.entity.Dept;
import com.example.javademo.entity.InfoEntity;
import com.example.javademo.entity.Team;
import com.example.javademo.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {

//    @Insert("INSERT INTO user_info (userId, userName, contactInfo, email) VALUES (#{userId}, #{userName}, #{contactInfo}, #{email}) ")
//    void insertUserInfo(UserInfoEntity userInfo);

    void insertUserInfo(UserInfoEntity userInfo);

    void updateUser(UserInfoEntity userInfo);

    void updateMap(Map<String, Object> map);

    List<UserInfoEntity> findAllUser();

    UserInfoEntity getUserById(String id);

    List<UserInfoEntity> getUserLike(String userName);

    List<UserInfoEntity> getListByLimit(Map<String, Object> map);

    List<UserInfoEntity> getListByRowBounds();

    List<UserInfoEntity> selectAllUser();

    @Insert("INSERT INTO user_info (userId, userName, contactInfo, email, dept, userPermission, createdDate, modifiedDate) " +
            "VALUES (#{userId}, #{userName}, #{contactInfo}, #{email} , #{dept} , #{userPermission}, #{createdDate}, #{modifiedDate})")
    void addUserInfo(Map<String, Object> userMap);

    @Select("select * from user_info where userId = #{id} and deleteFlag = #{deleteFlag}")
    UserInfoEntity getActiveUserById(@Param("id") String id, @Param("deleteFlag") boolean deleteFlag);

    List<InfoEntity> getInfo1();

    List<InfoEntity> getInfo2();

    List<Team> getUserInfoList1(@Param("deptNo") String deptNo);

    List<Team> getUserInfoList2(@Param("deptNo") String deptNo);
}
