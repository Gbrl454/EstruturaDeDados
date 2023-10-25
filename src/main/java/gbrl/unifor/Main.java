package gbrl.unifor;

import gbrl.unifor.collections.filas.FilaEstatica;

public class Main {
    static FilaEstatica<String> fila = new FilaEstatica<>();

    public static void main(String[] args) {
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
        add("H");
        add("I");
        add("J");
        rem();
        add("K");
 //       add("L");
//        add("M");
//        add("N");
//        add("O");
//        add("P");
//        add("Q");
//        add("R");
    }

    private static void add(String e) {
        fila.enqueue(e);
        System.out.println(fila + " -> " + fila.size());
    }

    private static void rem() {
        fila.dequeue();
        System.out.println(fila + " -> " + fila.size());
    }
}