package gbrl.unifor.listas.av1.lista2;

import gbrl.unifor.collections.listas.ListaDinamicaOrdenada;

import java.util.Scanner;

public class Q2729O {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            ListaDinamicaOrdenada<String> compras = new ListaDinamicaOrdenada<>();
            String listaProdutos = sc.nextLine();
            String[] vetorProdutos = listaProdutos.split(" ");

            for (String vetorProduto : vetorProdutos) compras.add(vetorProduto);

            for (int j = 0; j < compras.size(); j++)
                System.out.print((j == compras.size() - 1) ? compras.get(j) + "\n" : compras.get(j) + " ");
        }
    }
}
