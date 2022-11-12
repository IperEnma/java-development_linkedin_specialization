import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loop: while (true) {
            System.out.println("=========================");
            System.out.println("1) query data");
            System.out.println("2) insert money");
            System.out.println("3) withdraw dinero");
            System.out.println("4) check last 10 movements");
            System.out.println("5) exit");
            int option = scanner.nextInt();
            System.out.println("=========================");

            switch (option) {
                case 1: {
                    System.out.println("1");
                    break;
                }
                case 2: {
                    System.out.println("2");
                    break;
                }
                case 3: {
                    System.out.println("3");
                    break;
                }
                case 4: {
                    System.out.println("4");
                    break;
                }
                case 5:{
                    break loop;
                }
            }
        }
    }

}
