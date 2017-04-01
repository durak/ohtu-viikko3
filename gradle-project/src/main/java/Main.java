import java.util.*;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int luku = 3;
        Multiplier kolme = new Multiplier(luku);
        System.out.println("anna luku ");
        final int luku2 = scanner.nextInt();

        System.out.println("luku kertaa kolme on "+kolme.multipliedBy(luku2) );

    }
}
