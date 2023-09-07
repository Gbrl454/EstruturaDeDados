package gbrl.unifor.collections;

import java.util.LinkedList;

public class Teste {
    public static void main(String[] args) {
        LinkedLista<String> linkedLista = new LinkedLista<>();
        linkedLista.add("Theo");
        linkedLista.add("Nelio");
        linkedLista.add("Moacir");
        linkedLista.add("Silvain");
        linkedLista.add("Stefania");
        linkedLista.add("Ubirajara");
        linkedLista.add("Jacqueline");
        linkedLista.add("Brian");
        linkedLista.add("Mayara");
        linkedLista.add("Honorio");
        linkedLista.add("Joyce");
        linkedLista.add("Jussara");
        System.out.println(linkedLista);
        linkedLista.remove(1);
        System.out.println(linkedLista);
    }
}
