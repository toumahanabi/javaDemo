package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoEntity {

    private String userId;
    private String userName;
    private String contactInfo;
    private String email;
    private String dept;
    private String userPermission;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
    private boolean deleteFlag;
}
