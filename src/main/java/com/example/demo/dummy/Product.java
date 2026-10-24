package com.example.demo.dummy;


import org.springframework.stereotype.Component;


public record Product(
        Integer productId,
        String productName,
        double price
) {

}

