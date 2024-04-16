package com.codingexample.cafe_board.dto.user;

public class UserUpdateRequest {
    private long id;
    private String name;
    private int money;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getMoney(){
        return money;
    }

}
