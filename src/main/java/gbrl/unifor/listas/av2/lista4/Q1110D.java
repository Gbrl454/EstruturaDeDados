package gbrl.unifor.listas.av2.lista4;

import gbrl.unifor.collections.filas.FilaDinamica;

import java.util.Scanner;

public class Q1110D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaDinamica<Integer> fila;
        FilaDinamica<Integer> filaDesc;
        int n;

        while (true) {
            fila = new FilaDinamica<>();
            filaDesc = new FilaDinamica<>();

            do n = sc.nextInt(); while (n < 0 || n > 50);
            if (n == 0) break;

            for (int i = 1; i <= n; i++) fila.enqueue(i);

            while (fila.size() != 2) {
                filaDesc.enqueue(fila.dequeue());
                fila.enqueue(fila.dequeue());
            }
            filaDesc.enqueue(fila.dequeue());

            String strDisCards = "";
            for (int i = 0; i < filaDesc.size(); i++)
                strDisCards += filaDesc.get(i) + ((i == filaDesc.size() - 1) ? "" : ", ");

            System.out.println("Discarded cards: " + strDisCards);
            System.out.println("Remaining card: " + fila.peek());
        }
    }
}
