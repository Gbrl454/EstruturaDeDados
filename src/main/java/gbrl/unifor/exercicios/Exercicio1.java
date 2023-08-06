package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio1 {
    public static void run(Scanner sc) {
        int n, k;

        do {
            System.out.println("Qual o valor de N...");
            n = sc.nextInt();
        } while (n < 0);

        do {
            System.out.println("Qual o valor de K...");
            k = sc.nextInt();
        } while (k < 0);

        System.out.println("Comb (" + n + ", " + k + ") = " + comb(n, k));
    }

    private static int comb(int n, int k) {
        if (k == n) return 1;
        if (k > 1 && k < n) return comb(n - 1, k - 1) + comb(n - 1, k);
        return n;
    }
}
