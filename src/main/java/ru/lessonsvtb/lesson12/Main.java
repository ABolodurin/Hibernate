package ru.lessonsvtb.lesson12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static SessionFactory factory = null;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            threadList.add(ddosThread());
            threadList.get(i).start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        factory.close();
    }

    public static Thread ddosThread() {
        return new Thread(() -> {
            Session session = null;
            boolean done;
            for (int j = 0; j < 2000; j++) {
                done = false;
                while (!done) {
                    try {
                        System.out.println(Thread.currentThread());
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        Item item = session.get(Item.class, (int) (Math.random() * 40) + 1);
                        item.setValue(item.getValue() + 1);
                        session.save(item);
                        Thread.sleep(5);
                        session.getTransaction().commit();
                        done = true;
                    } catch (OptimisticLockException e) {
                        assert session != null;
                        session.getTransaction().rollback();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            session.close();
        });
    }
}
