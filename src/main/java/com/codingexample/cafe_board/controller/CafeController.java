package com.codingexample.cafe_board.controller;

import com.codingexample.cafe_board.dto.drink.DrinkCreateRequest;
import com.codingexample.cafe_board.dto.drink.DrinkResponse;
import com.codingexample.cafe_board.dto.order.OrderRequest;
import com.codingexample.cafe_board.dto.user.UserCreateRequest;
import com.codingexample.cafe_board.dto.user.UserResponse;
import com.codingexample.cafe_board.dto.user.UserUpdateRequest;
import com.codingexample.cafe_board.service.user.DrinkService;
import com.codingexample.cafe_board.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CafeController {
    private final UserService userService;
    private final DrinkService drinkService;
    public CafeController(UserService userService, DrinkService drinkService) {
        this.userService = userService;
        this.drinkService = drinkService;
    }
    // put -> 만약 아이스 아메리카노가 5000원 이라면 우리가 가지고 있는 돈을 이용해서 사보자

    @PostMapping("/cafe/drink")
    public void saveDrink(@RequestBody DrinkCreateRequest request){
        drinkService.saveDrink(request);
    }
    @GetMapping("/cafe/drink")
    public List<DrinkResponse> getDrinks(){
        return drinkService.getDrinks();
    }
    @PostMapping("/cafe")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }
    @GetMapping("/cafe")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }


    @DeleteMapping("/cafe") // 이름만으로 삭제 ? 나쁘지 않네
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
    @PutMapping("/cafe")
    public void updateUser(@RequestBody UserUpdateRequest request){
       userService.updateUser(request);
    }

    @PutMapping("/cafe/order")
    public void payDrink(@RequestBody OrderRequest request){
        userService.payDrink(request);
    }
}
