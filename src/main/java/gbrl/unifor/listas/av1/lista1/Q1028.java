package gbrl.unifor.listas.av1.lista1;

import java.util.Scanner;

public class Q1028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            System.out.println(bafo(f1, f2));
        }
    }

    private static int bafo(int n1, int n2) {
        if (n2 == 0)
            return n1;
        else
            return bafo(n2, n1 % n2);
    }
}

