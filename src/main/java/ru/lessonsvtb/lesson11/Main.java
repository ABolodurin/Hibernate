package ru.lessonsvtb.lesson11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static Session session = null;
    static SessionFactory factory = null;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean exit = false;
            while (!exit) {
                System.out.println("what can I do for you?");
                String parameter = null;
                String parameter2 = null;

                String[] command = reader.readLine().split(" ");
                String action = command[0];
                if (command.length > 1) parameter = command[1];
                if (command.length == 3) parameter2 = command[2];

                session = factory.getCurrentSession();
                session.beginTransaction();
                switch (action) {
                    case "showProductsByCustomer":
                        showProductsByCustomer(Integer.parseInt(parameter), session);
                        break;
                    case "findCustomersByProductId":
                        findCustomersByProductId(Integer.parseInt(parameter), session);
                        break;
                    case "removeCustomer":
                        removeCustomer(Integer.parseInt(parameter), session);
                        break;
                    case "removeProduct":
                        removeProduct(Integer.parseInt(parameter), session);
                        break;
                    case "buy":
                        buy(Integer.parseInt(parameter), Integer.parseInt(parameter2), session);
                        break;
                    case "exit":
                        exit = true;
                }
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    public static void showProductsByCustomer(int customerId, Session session) {
        Customer customer = session.get(Customer.class, customerId);
        customer.getOrders().forEach(order -> System.out.println(order.getProduct()));
    }

    public static void findCustomersByProductId(int productId, Session session) {
        Product product = session.get(Product.class, productId);
        product.getOrders().forEach(order -> System.out.println(order.getCustomer()));
    }

    public static void removeCustomer(int customerId, Session session) {
        Customer customer = session.get(Customer.class, customerId);
        session.delete(customer);
    }

    public static void removeProduct(int productId, Session session) {
        Product product = session.get(Product.class, productId);
        session.delete(product);
    }

    public static void buy(int customerId, int productId, Session session) {
        Customer customer = session.get(Customer.class, customerId);
        Product product = session.get(Product.class, productId);
        Order order = new Order(customer, product, product.getProductPrice());
        session.save(order);
    }
}
