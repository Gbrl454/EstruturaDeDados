package gbrl.unifor.listas.av1.lista1;

import java.util.Scanner;

public class Q1113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ordem(sc);
    }

    private static void ordem(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x != y) {
            System.out.println((x > y) ? "Decrescente" : "Crescente");
            ordem(sc);
        }
    }
}
