package gbrl.unifor.collections;

import java.util.LinkedList;

public class Teste {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add(1,"C");
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));

        LinkedLista<String> linkedLista = new LinkedLista<>();
        linkedLista.add("A");
        linkedLista.add("B");
        linkedLista.add(1,"C");
        System.out.println(linkedLista);
        System.out.println(linkedLista.get(1));
    }
}
