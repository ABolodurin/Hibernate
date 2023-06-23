# Hibernate
___
**Hibernate** -  A set of tasks for a Hibernate and SQL course.

Minor tasks during the project:
- practical experience working with GIT
  - forks
  - pull requests
  - merge
  - commits
- improving code style

## Description of tasks:


### Lesson9. Custom annotations

- Implement the possibility of marking the class by setting your custom annotations(```@Table(title)```, ```@Column```). 
Write an annotation processor that will allow the marked class to build a table in the database.
- (adv)Write a second annotation processor that saves the object of the marked class in the resulting table.

Hibernate\src\main\java\ru\lessonsvtb\lesson9
___
### Lesson10. SQL

Write SQL scripts according to the specified parameters:
- Create table ```students(id, name, document serial, document number)```
- Create table ```subjects(id, subject name)```
- Create table ```progress(id, student, mark)```
- Mark can be from 2 to 5
- The pair of document serial and number should be unique
- Get a list of students who got a mark above 3 in the selected subject
- In case of deleting the student, his progress has to be deleted too
- Get an average mark in the selected subject
- Get an average mark of the selected student
- Find three subjects that have passed the largest number of students

*Hibernate\Lesson10*
___
### Lesson11. Hibernate and PostgreSQL
- Database should store information about customers(id, name) and products(id, title, price)
- When the customer buys the product, then should be one record in the table(without grouping)
- Write a simple API (```Scanner``` and ```System.out.println```), which allows:
  - ```showProductsByCustomer``` to get products bought by the customer
  - ```findCustomersByProductId``` to get the customers who bought this product
  - ```removeCustomer``` to delete the customer from the database
  - ```buy```(customer, product) to make an order 
  - (adv)Add the order detailing - price should be at the time of the order

Hibernate\src\main\java\ru\lessonsvtb\lesson11

*Hibernate\Lesson11Scripts*
___
### Lesson12. Multithreading, transactions, and locks
- Create table ```items(id, val)``` and add 40 rows with ```val```=0 into it
- Start 8 threads. These threads choose the random row and increment their ```val``` by 1. 
The transaction requires ```Thread.sleep(5)``` in it. Required to do 2000 successful transactions for each thread. 
- Check the sum of ```val```, the correct sum is 16000. 

Hibernate\src\main\java\ru\lessonsvtb\lesson12

*Hibernate\Lesson12Scripts*
```SQL
SELECT SUM(val) FROM ITEMS;
```
___
### Lesson13. Spring core and Service layer
In this task, ````System.out.println``` implementation for all service methods is allowed
- Write a class ```Product(id, title, cost)```
- Write a ```ProductService``` component containing ```List<Product>``` with some products. 
Required methods for this service:
  - ```printAll()``` to get all products
  - ```findByTitle(String title)``` to get one product by its title
- Write a ```Cart``` component which allows to ```add(Product product)``` 
- Write a ```OrderService``` component which can make orders(products + total price)

Hibernate\src\main\java\ru\lessonsvtb\lesson12
___
