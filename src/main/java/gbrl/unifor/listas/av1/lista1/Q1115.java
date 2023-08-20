package gbrl.unifor.listas.av1.lista1;

import java.util.Scanner;

public class Q1115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        quadrante(sc);
    }

    private static void quadrante(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x != 0 && y != 0) {
            String quadrante;
            if (x > 0) {
                if (y > 0)
                    quadrante = "primeiro";
                else
                    quadrante = "quarto";
            } else {
                if (y > 0)
                    quadrante = "segundo";
                else
                    quadrante = "terceiro";
            }
            System.out.println(quadrante);
            quadrante(sc);
        }
    }
}
