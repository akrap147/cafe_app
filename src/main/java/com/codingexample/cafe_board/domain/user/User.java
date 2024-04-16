package com.codingexample.cafe_board.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id = null;
   @Column(nullable = false, length = 20, name = "name")
   private String name;
   private Integer age;
   private Integer money;
    public long getId() {
        return id;
    }

    public Integer getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public User(String name, Integer age,Integer money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }
}