package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String deptNo;
    private String deptName;
    private List<UserInfoEntity> userInfoEntityList;
}
