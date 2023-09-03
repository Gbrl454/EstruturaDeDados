package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedLista<E> extends AbstractLista<E> {
    private Node primeiro;
    private Node ultimo;

    // TODO
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        LinkedLista.Node novo = new LinkedLista.Node(e);

        if (primeiro == null) primeiro = novo;
        else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
        }

        ultimo = novo;
        count++;
        return true;
    }

    // TODO
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public String toString() {
        Node atual = primeiro;
        String str = "[";
        while (atual != null) {
            str += (atual.proximo == null) ? atual.item : atual.item + ", ";
            atual = atual.proximo;
        }
        return str + "]";
    }

    private static class Node<E> {
        E item;
        Node<E> anterior;
        Node<E> proximo;

        Node(Node<E> proximo, E item, Node<E> anterior) {
            this.item = item;
            this.anterior = anterior;
            this.proximo = proximo;
        }

        Node(E item) {
            this.item = item;
        }
    }
}

