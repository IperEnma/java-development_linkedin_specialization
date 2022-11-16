package com.iperenma;
import com.iperenma.atm.ATM;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        Scanner scannerOption = new Scanner(System.in);
        loop: while (true) {
            System.out.println("=========================");
            System.out.println("1) query data");
            System.out.println("2) insert money");
            System.out.println("3) withdraw money");
            System.out.println("4) check last movements");
            System.out.println("5) Register bank account");
            System.out.println("6) exit");
            int option = scannerOption.nextInt();
            System.out.println("=========================");

            switch (option) {
                case 1 -> ATM.queryData();
                case 2 -> ATM.deposit();
                case 3 -> ATM.withdraw();
                case 4 -> ATM.lastMovements();
                case 5 -> ATM.registerBankAccount();
                case 6 -> {
                    break loop;
                }
            }
        }
    }

}
