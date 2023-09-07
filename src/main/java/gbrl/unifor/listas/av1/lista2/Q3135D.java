package gbrl.unifor.listas.av1.lista2;

import gbrl.unifor.collections.LinkedLista;

import java.util.Scanner;

public class Q3135D {
    public static void main(String[] args) {
        LinkedLista<String> nomes = new LinkedLista<>();
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
