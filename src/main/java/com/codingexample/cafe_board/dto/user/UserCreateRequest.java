package com.codingexample.cafe_board.dto.user;

public class UserCreateRequest {
    private String name;
    private Integer age;
    private Integer money;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
    public Integer getMoney(){
        return money;
    }
}
