package gbrl.unifor.listas.av2.lista4;

import gbrl.unifor.collections.filas.FilaEstatica;

import java.util.Objects;
import java.util.Scanner;

public class Q2460E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaEstatica<Integer> fila = new FilaEstatica<>();

        int n;
        do n = sc.nextInt(); while (n < 1 || n > 50000);
        for (int i = 0; i < n; i++) fila.enqueue(sc.nextInt());

        int m;
        do m = sc.nextInt(); while (m < 1 || m > 50000 || m >= n);
        for (int i = 0; i < m; i++) fila = dequeue(sc.nextInt(), fila);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < fila.size(); i++)
            out.append(fila.size() == (i + 1) ? String.valueOf(fila.get(i)) : fila.get(i) + " ");
        System.out.println(out);
    }

    public static FilaEstatica<Integer> dequeue(Integer element, FilaEstatica<Integer> fila) {
        FilaEstatica<Integer> filaAUX = new FilaEstatica<>();
        while (!fila.isEmpty())
            if (!Objects.equals(fila.peek(), element)) filaAUX.enqueue(fila.dequeue());
            else fila.dequeue();
        return filaAUX;
    }
}
