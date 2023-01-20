package ru.lessonsvtb.lesson13.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<Product> productList;

    @Autowired
    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public Cart() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
    }
}
