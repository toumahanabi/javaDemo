package com.example.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private long id;

    private String loginUser;

    private String name;

    private String password;

}
