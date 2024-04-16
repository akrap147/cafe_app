package com.codingexample.cafe_board.repository.user;

import com.codingexample.cafe_board.dto.user.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void deleteUser(String name){
        String sql = "DELETE FROM Customer WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
    public List<UserResponse> getUserResponses(){
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int money = rs.getInt("money");
                return new UserResponse(id, name, age,money);
            }
        });
    }
    public void saveUser(String name, Integer age, Integer money){
        String sql = "INSERT INTO Customer(name, age, money) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, name, age, money);
    }
    public boolean isUserNoExist( long id) {
        String readSql = "SELECT * FROM Customer WHERE id = ? ";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id ).isEmpty();
    }
    public void updateUserName( String name, long id) {
        String updateSql = "UPDATE Customer SET name = ? WHERE id = ? ";
        jdbcTemplate.update(updateSql, name, id);
    }
    public boolean isUserMoneyPossible(String drink_name, String User_name){
        String readSql1 = "SELECT price FROM drink where name = ? ";
        String readSql2 = "SELECT money FROM Customer where name = ? ";
        int price = jdbcTemplate.queryForObject(readSql1, Integer.class, drink_name );
        int money = jdbcTemplate.queryForObject(readSql2, Integer.class, User_name);
        if (money > price ){
            return true;
        }
        else{
            return false;
        }
    }
    public void updateUserMoney(String drink_name , String User_name ){
        String readSql1 = "SELECT price FROM drink where name = ? ";
        String updateSql = "UPDATE Customer SET money = money - ? WHERE name = ? ";
        int price = jdbcTemplate.queryForObject(readSql1, Integer.class, drink_name );
        jdbcTemplate.update(updateSql, price , User_name );
    }

}
