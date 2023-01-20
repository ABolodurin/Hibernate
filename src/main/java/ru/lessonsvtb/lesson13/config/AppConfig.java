package ru.lessonsvtb.lesson13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.lessonsvtb.lesson13.entities.Cart;
import ru.lessonsvtb.lesson13.service.OrderService;
import ru.lessonsvtb.lesson13.entities.Product;
import ru.lessonsvtb.lesson13.service.ProductService;

@Configuration
@ComponentScan("ru.lessonsvtb.lesson13")
public class AppConfig {
    @Bean
    public OrderService orderService(){
        return new OrderService();
    }

    @Bean
    public ProductService productService(){
        return new ProductService();
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }

    @Bean
    @Scope("prototype")
    public Product product(){
        return new Product();
    }
}
