package com.codingexample.cafe_board.service.user;

import com.codingexample.cafe_board.dto.drink.DrinkCreateRequest;
import com.codingexample.cafe_board.dto.drink.DrinkResponse;
import com.codingexample.cafe_board.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    private final DrinkRepository drinkRepository;
    public void saveDrink(DrinkCreateRequest request){
        drinkRepository.saveDrink(request.getName(), request.getPrice());
    }
    public List<DrinkResponse> getDrinks(){
        return drinkRepository.getDrinkResponses();
    }
}
