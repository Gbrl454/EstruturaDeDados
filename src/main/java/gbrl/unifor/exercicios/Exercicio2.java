package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio2 {
    public static void run(Scanner sc) {
        int n;

        do {
            System.out.println("Quantos inteiros terão no Vetor?");
            n = sc.nextInt();
        } while (n < 0);

        int[] v = new int[n];

        for (int i = 0; i < v.length; i++) {
            int x;

            do {
                System.out.println("Valor do vetor Vetor na posição " + i + "...");
                x = sc.nextInt();
            } while (x < 0);

            v[i] = x;
        }

        System.out.println("O maior valor armazenado no Vetor é " + max(v, v[0], 0));
    }

    private static int max(int[] v, int x, int p) {
        if (v.length == (p + 1)) return x;
        if (x > v[p + 1]) return max(v, x, p + 1);
        if (x < v[p + 1]) return max(v, v[p + 1], p + 1);
        return x;
    }
}
