import java.util.Scanner;

public class SecondProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loop: while (true) {
            System.out.println("=========================");
            System.out.println("1) compare numbers");
            System.out.println("2) exit");
            int option = scanner.nextInt();
            System.out.println("=========================");

            switch (option) {
                case 1: {
                    System.out.println("Ingrese numero: ");
                    int var1 = scanner.nextInt();
                    System.out.println("Ingrese numero: ");
                    int var2 = scanner.nextInt();

                    if (var1 > var2) {
                        System.out.println(var1 + " is greater than " + var2 + "\n");
                    } else if (var1 < var2) {
                        System.out.println(var2 + " is greater than " + var1 + "\n");
                    } else {
                        System.out.println(var2 + " equals " + var1 + "\n");
                    }
                    break;
                }
                case 2:{
                    break loop;
                }
            }
        }
    }
}
