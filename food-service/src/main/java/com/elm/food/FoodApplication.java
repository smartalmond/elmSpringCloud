package com.elm.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.elm.food.mapper")
@SpringBootApplication
public class FoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApplication.class, args);
    }

}
