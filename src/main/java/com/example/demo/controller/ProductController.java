package com.example.demo.controller;

import com.example.demo.dummy.Product;
import com.example.demo.dummy.ProductHolder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductHolder products;

    @GetMapping()
    public List<Product> getProductList() {
        return products.productList;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        products.productList.add(product);
        return product;
    }

    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
