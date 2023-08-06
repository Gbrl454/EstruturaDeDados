package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio6 {
    public static void run(Scanner sc) {
        int x, n;

        do {
            System.out.println("Qual o valor de X...");
            x = sc.nextInt();
        } while (x < 0);

        do {
            System.out.println("Qual o valor de N...");
            n = sc.nextInt();
        } while (n < 0);

        System.out.println("f(" + x + ", " + n + ") = " + f(x, n));
    }

    private static long f(long x, int n) {
        return switch (n) {
            case 0 -> 1;
            case 1 -> x;
            case 2 -> x * x;
            default -> x * f(x, n - 1);
        };
    }
}
