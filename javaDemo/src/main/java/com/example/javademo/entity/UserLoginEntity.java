package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("userLogin")
public class UserLoginEntity {

    private int userId;
    private String loginName;
    private String loginPassword;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
    private boolean deleteFlag;
}
