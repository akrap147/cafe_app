package com.codingexample.cafe_board.repository;

import com.codingexample.cafe_board.dto.drink.DrinkResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DrinkRepository {
    private final JdbcTemplate jdbcTemplate;

    public DrinkRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveDrink(String name,Integer price){
        String sql = "INSERT INTO drink(name, price) VALUES(?, ?)";
        jdbcTemplate.update(sql, name, price);
    }
    public List<DrinkResponse> getDrinkResponses(){
        String sql = "SELECT * FROM drink";
        return jdbcTemplate.query(sql, new RowMapper<DrinkResponse>() {
            @Override
            public DrinkResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                return new DrinkResponse(id, name, price);
            }
        });
    }
}
