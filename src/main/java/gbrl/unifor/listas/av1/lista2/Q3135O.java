package gbrl.unifor.listas.av1.lista2;

import gbrl.unifor.collections.listas.ListaDinamicaOrdenada;
import gbrl.unifor.collections.listas.ListaEstatica;

import java.util.Scanner;

public class Q3135O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        ListaEstatica<ListaDinamicaOrdenada<String>> nomesPorTamanho = new ListaEstatica<>();
        for (int i = 0; i < 20; i++) nomesPorTamanho.add(new ListaDinamicaOrdenada<>());

        for (int i = 0; i < n; i++) {
            String nome = scanner.next();
            nomesPorTamanho.get(nome.length()).add(nome);
        }


        while (!nomesPorTamanho.isEmpty()) {
            ListaEstatica<String> list = new ListaEstatica<>();
            for (int i = 0; i < nomesPorTamanho.size(); i++) {
                if (nomesPorTamanho.get(i).isEmpty()) {
                    nomesPorTamanho.remove(i);
                    i--;
                } else {
                    list.add(nomesPorTamanho.get(i).get(0));
                    nomesPorTamanho.get(i).remove(0);
                }
            }

            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(
                            (i == list.size() - 1) ? list.get(i) + "\n" : list.get(i) + ", "
                    );
                }
            }
        }
    }
}