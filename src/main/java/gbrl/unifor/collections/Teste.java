package gbrl.unifor.collections;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<Double> doubleListADD = new ArrayList<>();
        doubleListADD.add(1.1);
        doubleListADD.add(2.2);
        doubleListADD.add(3.3);
        doubleListADD.add(4.4);
        doubleListADD.add(5.5);
        ArrayList doubleListREM = new ArrayList<>(doubleListADD);
        doubleListREM.add("A");

        ArrayLista<Double> lista = new ArrayLista<>();
        System.out.println("ADD");
        lista.add(1.0);
        lista.add(3.0);
        lista.add(5.0);
        System.out.println(lista);
        System.out.println("ADDALL");
        lista.addAll(doubleListADD);
        System.out.println(lista);
        System.out.println("REMOVEALL");
        lista.removeAll(doubleListREM);
        System.out.println(lista);

        ArrayList<Double> list = new ArrayList<>();
        System.out.println("ADD");
        list.add(1.0);
        list.add(3.0);
        list.add(5.0);
        System.out.println(list);
        System.out.println("ADDALL");
        list.addAll(doubleListADD);
        System.out.println(list);
        System.out.println("REMOVEALL");
        list.removeAll(doubleListREM);
        System.out.println(list);
    }
}
