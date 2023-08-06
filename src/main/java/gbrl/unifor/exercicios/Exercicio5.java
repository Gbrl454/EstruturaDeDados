package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio5 {
    public static void run(Scanner sc) {
        int m, n;

        do {
            System.out.println("Qual o valor de M...");
            m = sc.nextInt();
        } while (m < 0);

        do {
            System.out.println("Qual o valor de N...");
            n = sc.nextInt();
        } while (n < 0);

        System.out.println("Dada a definição da função de Ackerman A(" + m + ", " + n + ") = " + a(m, n));
    }

    private static int a(int m, int n) {
        if (m > 0) {
            return (n == 0) ? a(n - 1, 1) : a(m - 1, a(m, n - 1));
        }
        return n + 1;
    }
}
