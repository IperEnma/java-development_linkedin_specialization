package com.iperenma.atm;
import java.util.ArrayList;
import java.util.Scanner;
import com.iperenma.bank.*;

public class ATM {


    static private final Scanner scannerMovements = new Scanner(System.in);
    static private final Scanner scannerName = new Scanner(System.in);
    static private final Scanner scannerMoney = new Scanner(System.in);
    static private final Scanner scannerType = new Scanner(System.in);
    static private final Scanner scannerPassword = new Scanner(System.in);
    static private final ArrayList<BankAccount> listAccount = new ArrayList<>();

    public static void queryData() {

        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (BankAccount bankAccount : listAccount) {
            if (name.equals(bankAccount.getName())) {
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (bankAccount.checkPassword(password)) {
                    System.out.println(bankAccount.printData());
                } else {
                    System.out.println("Password incorrect");
                }
                return;
            }
        }
        System.out.println("No exists account");
    }

    public static void deposit() {
        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (BankAccount bankAccount : listAccount) {
            if (name.equals(bankAccount.getName())) {
                System.out.println("How much do you want to deposit?");
                double money = scannerMoney.nextDouble();
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (bankAccount.checkPassword(password)) {
                    bankAccount.insertMoney(money);
                    System.out.println("new balance: " + bankAccount.getMoney());
                } else {
                    System.out.println("Password incorrect");
                }
                return;
            }
        }
        System.out.println("No exists account");
    }

    public static void withdraw() {
        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (BankAccount bankAccount : listAccount) {
            if (name.equals(bankAccount.getName())) {
                System.out.println("How much do you want to withdraw?");
                double money = scannerMoney.nextDouble();
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (bankAccount.checkPassword(password)) {
                    try {
                        bankAccount.withdrawMoney(money);
                        System.out.println("New balance: " + bankAccount.getMoney());
                        return;
                    } catch (Exception error) {
                        System.out.println("no money sufficient");
                        return;
                    }
                } else {
                    System.out.println("Password incorrect");
                    return;
                }
            }
        }
        System.out.println("No exists account");
    }

    public static void lastMovements() {
        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (BankAccount bankAccount : listAccount) {
            if (name.equals(bankAccount.getName())) {
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (bankAccount.checkPassword(password)) {
                    System.out.println("Enter the number of moves you want to display");
                    int number = scannerMovements.nextInt();
                    ArrayList<String> movements = bankAccount.getMovements(number);
                    for (int j = 0; j < movements.size(); j++) {
                        System.out.println(String.format("%d", j + 1) + ") " + movements.get(j));
                    }
                } else {
                    System.out.println("Password incorrect");
                }
                return;
            }
        }
        System.out.println("No exists account");
    }

    public static void registerBankAccount() {
        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        System.out.println("Enter new password");
        String password = scannerPassword.nextLine();
        System.out.println("initial amount of money");
        double money = scannerMoney.nextDouble();
        System.out.println("Select an account type");
        System.out.println("1) Current account");
        System.out.println("2) Savings account");
        int type = scannerType.nextInt();
        switch (type) {
            case 1 -> {
                BankAccount account = new CurrentAccount(name, password, money);
                listAccount.add(account);
            }
            case 2 -> {
                BankAccount account = new SavingAccount(name, password, money);
                listAccount.add(account);
            }
        }
    }

    public static void showAgree() {
        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (BankAccount bankAccount : listAccount) {
            if (name.equals(bankAccount.getName())) {
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (bankAccount.checkPassword(password)) {
                    bankAccount.showAgree();
                } else {
                    System.out.println("Password incorrect");
                }
                return;
            }
        }
        System.out.println("No exists account");
    }
}
