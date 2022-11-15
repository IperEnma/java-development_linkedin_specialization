import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scannerOption = new Scanner(System.in);
        Scanner scannerName = new Scanner(System.in);
        Scanner scannerMoney = new Scanner(System.in);
        Scanner scannerType = new Scanner(System.in);

        ArrayList<BankAccount> listAccount = new ArrayList<>();

        loop: while (true) {
            System.out.println("=========================");
            System.out.println("1) query data");
            System.out.println("2) insert money");
            System.out.println("3) withdraw money");
            System.out.println("4) check last 10 movements (no work)");
            System.out.println("5) Register bank account");
            System.out.println("6) exit");
            int option = scannerOption.nextInt();
            System.out.println("=========================");

            menu: switch (option) {
                case 1: {
                    System.out.println("Enter the owner's name");
                    String name = scannerName.nextLine();
                    for (int i = 0; i < listAccount.size(); i++) {
                        if (name.equals(listAccount.get(i).getName())) {
                            System.out.println(listAccount.get(i).printData());
                            break menu;
                        }
                    }
                    System.out.println("No exists account");
                    break;
                }
                case 2: {
                    System.out.println("Enter the owner's name");
                    String name = scannerName.nextLine();
                    for (int i = 0; i < listAccount.size(); i++) {
                        if (name.equals(listAccount.get(i).getName())) {
                            System.out.println("How much do you want to deposit?");
                            double money = scannerMoney.nextDouble();
                            listAccount.get(i).insertMoney(money);
                            System.out.println("new balance: " +  listAccount.get(i).getMoney());
                            break menu;
                        }
                    }
                    System.out.println("No exists account");
                    break;
                }
                case 3: {
                    System.out.println("Enter the owner's name");
                    String name = scannerName.nextLine();
                    for (int i = 0; i < listAccount.size(); i++) {
                        if (name.equals(listAccount.get(i).getName())) {
                            System.out.println("How much do you want to withdraw?");
                            double money = scannerMoney.nextDouble();
                            try {
                                listAccount.get(i).withdrawMoney(money);
                                break menu;
                            } catch (Exception error) {
                                System.out.println("no money sufficient");
                                break menu;
                            }
                        }
                    }
                    System.out.println("No exists account");
                    break;
                }
                case 4: {
                    System.out.println("4");
                    break;
                }
                case 5: {
                    System.out.println("Enter the owner's name");
                    String name = scannerName.nextLine();
                    System.out.println("initial amount of money");
                    double money = scannerMoney.nextDouble();
                    System.out.println("Select an account type");
                    System.out.println("1) Current account");
                    System.out.println("2) Savings account");
                    int type = scannerType.nextInt();
                    switch (type) {
                        case 1: {
                            BankAccount account = new BankAccount(name, money, TypeAccount.CURRENT_ACCOUNT);
                            listAccount.add(account);
                        }
                        case 2: {
                            BankAccount account = new BankAccount(name, money, TypeAccount.SAVINGS_ACCOUNT);
                            listAccount.add(account);
                        }
                    }
                    break;
                }
                case 6: {
                    break loop;
                }
            }
        }
    }

}
