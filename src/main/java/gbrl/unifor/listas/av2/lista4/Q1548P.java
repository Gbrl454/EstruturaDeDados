package gbrl.unifor.listas.av2.lista4;

import gbrl.unifor.collections.filas.FilaDinamicaPrioridade;

import java.util.Scanner;

public class Q1548P {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaDinamicaPrioridade<Integer> fila = new FilaDinamicaPrioridade<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m;
            do m = sc.nextInt(); while (m < 1 || m > 1000);

            for (int j = 0; j < m; j++) {
                int p;
                do p = sc.nextInt(); while (p < 1 || p > 1000);
                fila.enqueue(fila.size(), p);
            }

            int diff = 0;
            for (int j = fila.size() - 1; j >= 0; j--) if (fila.dequeue() == j) diff++;

            System.out.println(diff);
        }
    }
}
