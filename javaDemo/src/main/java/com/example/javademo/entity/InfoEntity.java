package com.example.javademo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoEntity {

    private String UserId;
    private String UserName;
    private Dept dept;
}
