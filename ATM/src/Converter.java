import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert mount in EURO: ");
        double euros = scanner.nextInt();
        double usd = euros * 1.0362688 ;
        System.out.println("USD: " + usd);
    }
}
