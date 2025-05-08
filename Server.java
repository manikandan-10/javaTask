package com.ebrain.hashmap;

import java.util.*;

public class HashMapCore {

    interface Bank {
        void deposit(double amount);
        void withdraw(double amount);
        void checkBalance();
    }

    class Account implements Bank {
        private String name;
        private String accountNumber;
        private double balance;

        public Account(String name, String accountNumber, double balance) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        }

        public void checkBalance() {
            System.out.println("Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Server.Account> accounts = new HashMap<>();
        Server server = new Server();

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) {
                System.out.println("Thank you for using the bank system!");
                break;
            }

            System.out.print("Enter account number: ");
            String accNum = sc.nextLine();
            Server.Account acc = accounts.get(accNum);

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();
                    accounts.put(accNum, server.new Account(name, accNum, balance));
                    System.out.println("Account created.");
                    break;

                case 2:
                    if (acc != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        sc.nextLine();
                        acc.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    if (acc != null) {
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        sc.nextLine();
                        acc.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    if (acc != null) {
                        acc.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
} 
