package gbrl.unifor.listas.av1.lista2;

import gbrl.unifor.collections.listas.ListaEstatica;

import java.util.Scanner;

// 12 sergio ana maria carlos eva joaquim jo mara laura lucas ari paulo

public class Q3135E {
    public static void main(String[] args) {
        ListaEstatica<String> nomes = new ListaEstatica<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int min = 2;
        final int max = 19;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            nomes.add(s);
        }

        while (nomes.size() > 0) {
            String outNomes = "";

            for (int tam = min; tam < max; tam++) {
                for (int i = 0; i < nomes.size(); i++) {
                    if (nomes.get(i).length() == tam) {
                        if (outNomes.length() > 0) outNomes += ", ";

                        outNomes += nomes.get(i);
                        nomes.remove(i);
                        break;
                    }
                }
            }

            System.out.println(outNomes);
        }
    }
}
