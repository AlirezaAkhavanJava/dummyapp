package com.example.demo.dummy;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductHolder {
    public List<Product> productList = new ArrayList<>(
            List.of(
                    new Product(1, "Xiaomi POCO X5", 2200.0D),
                    new Product(2, "Viv x500", 4620.0D)
            )
    );
}
