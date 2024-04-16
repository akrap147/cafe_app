package com.codingexample.cafe_board.dto.drink;

public class DrinkResponse {
    private long id;
    private String name;
    private Integer price;

    public DrinkResponse(long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
