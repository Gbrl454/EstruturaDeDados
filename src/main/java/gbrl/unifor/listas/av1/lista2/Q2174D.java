package gbrl.unifor.listas.av1.lista2;

import gbrl.unifor.collections.LinkedLista;

import java.util.Scanner;

public class Q2174D {
    public static void main(String[] args) {
        LinkedLista<String> pomekons = new LinkedLista<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (!pomekons.contains(s)) pomekons.add(s);
        }

        System.out.println("Falta(m) " + (151 - pomekons.size()) + " pomekon(s).");

    }
}
