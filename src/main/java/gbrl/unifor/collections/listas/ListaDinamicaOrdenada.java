package gbrl.unifor.collections.listas;

import gbrl.unifor.collections.abstracts.ListaDinamicaA;
import gbrl.unifor.collections.util.Node;

public class ListaDinamicaOrdenada<E extends Comparable<E>> extends ListaDinamicaA<E> {
    @Override
    public boolean add(E e) {
        Node<E> novo = new Node<>(e);
        if (contains(novo.item)) return false;

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
            count++;
        } else if (novo.item.compareTo(primeiro.item) < 0) {
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;
            count++;
        } else if (novo.item.compareTo(ultimo.item) > 0) {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
            count++;
        } else {
            Node<E> aux = primeiro;

            while (aux != null && ((novo.item.compareTo(aux.item)) >= 0)) aux = aux.proximo;

            novo.anterior = aux.anterior;
            aux.anterior.proximo = novo;
            novo.proximo = aux;
            aux.anterior = novo;
            count++;
        }

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        return add(element);
    }
}
