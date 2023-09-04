package gbrl.unifor.collections;

import java.util.LinkedList;

public class Teste {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println(linkedList.indexOf("A"));

        LinkedLista<String> linkedLista = new LinkedLista<>();
        linkedLista.add("A");
        linkedLista.add("B");
        linkedLista.add("C");
        System.out.println(linkedLista.indexOf("A"));
    }
}
