package com.demo.crud;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.hibernatedemo.config.HibernateUtility;
import com.demo.hibernatedemo.entities.Product;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactoryObject();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Scanner scanner = new Scanner(System.in);
        int productId = 1; // Initialize the product ID to 1 and auto-increment.

        while (true) {
            System.out.println("Select a CRUD operation:");
            System.out.println("1. Create (Insert)");
            System.out.println("2. Read (Retrieve)");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create (Insert) operation
                    System.out.println("Enter product details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product();
                    newProduct.setPrdId(productId);
                    newProduct.setPrdName(name);
                    newProduct.setPrdPrice(price);

                    session.save(newProduct);
                    System.out.println("Product created successfully with ID: " + productId);
                    productId++; // Increment the product ID.
                    break;

                case 2:
                    // Read (Retrieve) operation
                    System.out.println("Enter product ID to retrieve: ");
                    int productIdToRetrieve = scanner.nextInt();
                    Product retrievedProduct = session.get(Product.class, productIdToRetrieve);

                    if (retrievedProduct != null) {
                        System.out.println("Product ID: " + retrievedProduct.getPrdId());
                        System.out.println("Product Name: " + retrievedProduct.getPrdName());
                        System.out.println("Product Price: " + retrievedProduct.getPrdPrice());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    // Update operation
                    System.out.println("Enter product ID to update: ");
                    int productToUpdateId = scanner.nextInt();
                    Product productToUpdate = session.get(Product.class, productToUpdateId);

                    if (productToUpdate != null) {
                        System.out.println("Enter updated product details:");
                        System.out.print("New Name: ");
                        String newName = scanner.next();
                        System.out.print("New Price: ");
                        double newPrice = scanner.nextDouble();

                        productToUpdate.setPrdName(newName);
                        productToUpdate.setPrdPrice(newPrice);
                        session.update(productToUpdate);
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // Delete operation
                    System.out.println("Enter product ID to delete: ");
                    int productToDeleteId = scanner.nextInt();
                    Product productToDelete = session.get(Product.class, productToDeleteId);

                    if (productToDelete != null) {
                        session.delete(productToDelete);
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting");
                    transaction.commit();
                    session.close();
                    sessionFactory.close();
                    System.exit(0); // Terminate the program.
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
