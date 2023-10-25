package gbrl.unifor.listas.av2.lista4;

import gbrl.unifor.collections.filas.FilaDinamica;
import gbrl.unifor.collections.util.Node;

import java.util.Scanner;

// 8 5 100 9 81 70 33 2 1000 3 9 33 5
// 100 81 70 2 1000

public class Q2460D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaDinamicaRem<Integer> fila = new FilaDinamicaRem<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) fila.enqueue(sc.nextInt());

        FilaDinamica<Integer> filaAUX = new FilaDinamica<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) filaAUX.enqueue(sc.nextInt());

        fila.dequeue(filaAUX);

        String out = "";
        for (int i = 0; i < fila.size(); i++)
            out += (fila.size() == (i + 1) ? String.valueOf(fila.get(i)) : fila.get(i) + " ");
        System.out.println(out);
        System.out.println("100 81 70 2 1000");
    }
}

class FilaDinamicaRem<E> extends FilaDinamica<E> {
    public void dequeue(FilaDinamica<E> outraFila) {
        for (int i = 0; i < outraFila.size(); i++) {
            for (Node<E> x = inicio; x != null; x = x.proximo) {
                if (x.item == outraFila.get(i)) {
                    if (x.anterior == null) {
                        inicio = x.proximo;
                        inicio.anterior = null;
                    } else {
                        x.anterior.proximo = x.proximo;
                        if (x.proximo != null)
                            x.proximo.anterior = x.anterior;
                    }
                    count--;
                }
            }
        }
    }
}
