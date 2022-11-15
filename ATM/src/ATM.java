import java.util.ArrayList;
import java.util.Scanner;

public class ATM {


    Scanner scannerOption = new Scanner(System.in);
    static Scanner scannerName = new Scanner(System.in);
    static Scanner scannerMoney = new Scanner(System.in);
    static Scanner scannerType = new Scanner(System.in);
    static Scanner scannerPassword = new Scanner(System.in);
    static ArrayList<BankAccount> listAccount = new ArrayList<>();

    public static void queryData() {

        System.out.println("Enter the owner's name");
        String name = scannerName.nextLine();
        for (int i = 0; i < listAccount.size(); i++) {
            if (name.equals(listAccount.get(i).getName())) {
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (listAccount.get(i).checkPassword(password)) {
                    System.out.println(listAccount.get(i).printData());
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
        for (int i = 0; i < listAccount.size(); i++) {
            if (name.equals(listAccount.get(i).getName())) {
                System.out.println("How much do you want to deposit?");
                double money = scannerMoney.nextDouble();
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (listAccount.get(i).checkPassword(password)) {
                    listAccount.get(i).insertMoney(money);
                    System.out.println("new balance: " + listAccount.get(i).getMoney());
                }
                else {
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
        for (int i = 0; i < listAccount.size(); i++) {
            if (name.equals(listAccount.get(i).getName())) {
                System.out.println("How much do you want to withdraw?");
                double money = scannerMoney.nextDouble();
                System.out.println("Insert password");
                String password = scannerPassword.nextLine();
                if (listAccount.get(i).checkPassword(password)) {
                    try {
                        listAccount.get(i).withdrawMoney(money);
                        System.out.println("New balance: " + listAccount.get(i).getMoney());
                        return;
                    } catch (Exception error) {
                        System.out.println("no money sufficient");
                        return;
                    }
                }
                else {
                    System.out.println("Password incorrect");
                    return;
                }
            }
        }
        System.out.println("No exists account");
    }
    public static void lastMovements() {
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
            case 1: {
                BankAccount account = new BankAccount(name, password, money, TypeAccount.CURRENT_ACCOUNT);
                listAccount.add(account);
                break;
            }
            case 2: {
                BankAccount account = new BankAccount(name, password, money, TypeAccount.SAVINGS_ACCOUNT);
                listAccount.add(account);
                break;
            }
        }
    }
}
