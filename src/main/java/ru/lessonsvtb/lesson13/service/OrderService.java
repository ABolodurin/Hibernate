package ru.lessonsvtb.lesson13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lessonsvtb.lesson13.entities.Cart;
import ru.lessonsvtb.lesson13.entities.Product;

@Component
public class OrderService {
    @Autowired
    public OrderService() {
    }

    public void doOrder(Cart cart) {
        int sum = 0;
        for (Product p : cart.getProductList()) {
            System.out.println(p);
            sum += p.getCost();
        }
        System.out.printf("Total cost: %d\n\n",sum);
    }
}
