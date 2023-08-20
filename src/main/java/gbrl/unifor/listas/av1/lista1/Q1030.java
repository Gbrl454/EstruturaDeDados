package gbrl.unifor.listas.av1.lista1;

import java.util.Scanner;

public class Q1030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();
        for (int i = 1; nc >= i; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println("Case " + i + ": " + josephus(n, k));
        }
    }

    private static int josephus(int n, int k) {
        return (n == 1) ? 1 : ((josephus(n - 1, k) + k - 1) % n + 1);
    }
}

