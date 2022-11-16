import java.util.Scanner;

public class Interfaz {

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
                case 1: {
                    ATM.queryData();
                    break;
                }
                case 2: {
                    ATM.deposit();
                    break;
                }
                case 3: {
                    ATM.withdraw();
                    break;
                }
                case 4: {
                    ATM.lastMovements();
                    break;
                }
                case 5: {
                    ATM.registerBankAccount();
                    break;
                }
                case 6: {
                    break loop;
                }
            }
        }
    }

}
