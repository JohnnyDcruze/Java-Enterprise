package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.BankAccount;
import com.example.demo.repositories.BankAccountRepository;

import java.util.Scanner;
 
@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
        Scanner scanner = new Scanner(System.in);
 
        BankAccountRepository accountRepository = SpringApplication
                .run(BankApplication.class, args)
                .getBean(BankAccountRepository.class);
 
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Balance");
            System.out.println("5. Exit");
 
            int choice = scanner.nextInt();
            scanner.nextLine(); 
 
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    createAccount(accountRepository, accountNumber, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(accountRepository, depositAccountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(accountRepository, withdrawAccountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String checkAccountNumber = scanner.nextLine();
                    displayBalance(accountRepository, checkAccountNumber);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
 
    private static void createAccount(BankAccountRepository accountRepository, String accountNumber, double initialBalance) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(accountNumber);
        account.setBalance(initialBalance);
        accountRepository.save(account);
        System.out.println("Account created successfully.");
    }
 
    private static void deposit(BankAccountRepository accountRepository, String accountNumber, double amount) {
        BankAccount account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            accountRepository.save(account);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Account not found.");
        }
    }
 
    private static void withdraw(BankAccountRepository accountRepository, String accountNumber, double amount) {
        BankAccount account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            double currentBalance = account.getBalance();
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                accountRepository.save(account);
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
 
    private static void displayBalance(BankAccountRepository accountRepository, String accountNumber) {
        BankAccount account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            double balance = account.getBalance();
            System.out.println("Account Balance: " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}