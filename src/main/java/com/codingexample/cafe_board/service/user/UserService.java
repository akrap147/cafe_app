package com.codingexample.cafe_board.service.user;

import com.codingexample.cafe_board.dto.order.OrderRequest;
import com.codingexample.cafe_board.dto.user.UserCreateRequest;
import com.codingexample.cafe_board.dto.user.UserResponse;
import com.codingexample.cafe_board.dto.user.UserUpdateRequest;
import com.codingexample.cafe_board.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge(), request.getMoney());
    }
    public List<UserResponse> getUsers(){
       return userRepository.getUserResponses();
    }
    public void deleteUser(String name){
        userRepository.deleteUser(name);
    }
    public void updateUser(UserUpdateRequest request){
        if (userRepository.isUserNoExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName( request.getName(), request.getId());
    }
    public void payDrink(OrderRequest request){ // 박종원이 아이스 아메리카노를 시켰다.
        if(!userRepository.isUserMoneyPossible(request.getDrink_name(), request.getUser_name())){
            throw new IllegalArgumentException();
        }// 돈이 크다면 뺄 수 있도록 하고, 돈이 없다면 뺄 수 없더록한ㄷ,)
        userRepository.updateUserMoney(request.getDrink_name(), request.getUser_name() );
    }
    //아니 drink_price 가져오기 필요하고, Customer 돈 가져오기 필요하고, 그러면 뭐가 더 필요하지?
}
