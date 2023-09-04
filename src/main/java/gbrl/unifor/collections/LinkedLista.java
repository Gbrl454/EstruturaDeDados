package gbrl.unifor.collections;

import java.util.Collection;

public class LinkedLista<E> extends AbstractLista<E> {
    private Node<E> primeiro;
    private Node<E> ultimo;

    @Override
    public boolean contains(Object o) {
        Node<E> atual = primeiro;
        while (atual != null) {
            if (atual.item == o) return true;
            atual = atual.proximo;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        Node novo = new Node(e);

        if (primeiro == null) primeiro = novo;
        else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
        }

        ultimo = novo;
        count++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(int index, E element) {
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return -1;
    }

    @Override
    public String toString() {
        Node<E> atual = primeiro;
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

