package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio3 {
    public static void run(Scanner sc) {
        int n;

        do {
            System.out.println("Qual o valor de N...");
            n = sc.nextInt();
        } while (n < 0);


        System.out.println("F (" + n + ") = " + f(n));
    }

    private static int f(int n) {
        return (n < 4) ? (3 * n) : (2 * f(n - 4) + 5);
    }
}
