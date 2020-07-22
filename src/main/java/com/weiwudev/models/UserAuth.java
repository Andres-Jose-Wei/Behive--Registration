package com.weiwudev.models;

import lombok.Data;

import java.util.List;

@Data
public class UserAuth{

    private String id;

    private String username;

    private String password;

    private List<String> roles;

}
