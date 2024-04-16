package com.codingexample.cafe_board.domain.user;

public class Drink {
    private int id;
    private String name;
    private Integer price;

    public Drink(int id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
