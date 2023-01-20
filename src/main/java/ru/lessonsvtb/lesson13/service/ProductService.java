package ru.lessonsvtb.lesson13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lessonsvtb.lesson13.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class ProductService {
    @Autowired
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public ProductService() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void printAll() {
        productList.forEach(System.out::println);
    }

    public Product findByTitle(String s) {
        return productList.stream()
                .filter(product -> product.getTitle().equals(s))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    private void create(){
        ArrayList<Product> products = new ArrayList<>(Arrays.asList(
                new Product("mouse", 10),
                new Product("monitor", 75),
                new Product("cpu", 100),
                new Product("ram", 30),
                new Product("keyboard", 15),
                new Product("gpu", 999999),
                new Product("pwrunit", 30),
                new Product("motherboard", 50)));
        this.setProductList(products);
    }

}
