package gbrl.unifor.exercicios;

import java.util.Scanner;

public class Exercicio4 {
    public static void run(Scanner sc) {
        int x;
        double x0, e;

        do {
            System.out.println("Qual o valor de X...");
            x = sc.nextInt();
        } while (x < 0);

        do {
            System.out.println("Qual o valor aproximado da raiz de X...");
            x0 = sc.nextDouble();
        } while (x0 < 0);

        do {
            System.out.println("Qual o erro aceitável...");
            e = sc.nextDouble();
        } while (e < 0);

        System.out.println("A raiz de " + x + " com o erro de " + e + " é " + raizQ(x, x0, e));
    }

    private static double raizQ(int x, double x0, double e) {
        double x02 = (x0 * x0);
        double check = (x02 - x);
        check = (check < 0) ? check * (-1) : check;
        if (check <= e) return x0;

        return raizQ(x, ((x02 + x) / (2 * x0)), e);
    }
}
