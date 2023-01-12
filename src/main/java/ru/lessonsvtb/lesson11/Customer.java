package ru.lessonsvtb.lesson11;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public List<Order> getOrders() {
        return orders;
    }



    @Override
    public String toString() {
        return this.customerName;
    }
}
