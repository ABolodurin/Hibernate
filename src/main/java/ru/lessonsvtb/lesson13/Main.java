package ru.lessonsvtb.lesson13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lessonsvtb.lesson13.config.AppConfig;
import ru.lessonsvtb.lesson13.entities.Cart;
import ru.lessonsvtb.lesson13.service.OrderService;
import ru.lessonsvtb.lesson13.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        ProductService productService = context.getBean("productService", ProductService.class);

        Cart cart1 = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);

        cart1.add(productService.findByTitle("mouse"));
        cart1.add(productService.findByTitle("monitor"));
        cart2.add(productService.findByTitle("cpu"));
        cart2.add(productService.findByTitle("keyboard"));
        cart1.add(productService.findByTitle("ram"));
        cart2.add(productService.findByTitle("gpu"));

        orderService.doOrder(cart1);
        orderService.doOrder(cart2);

    }
}
