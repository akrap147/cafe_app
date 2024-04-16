package com.codingexample.cafe_board.dto.user;

import com.codingexample.cafe_board.domain.user.User;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;
    private Integer money;

    public UserResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
        this.age = user.getMoney();
    }

    public UserResponse(long id, String name, Integer age, Integer money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMoney() {
        return money;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
