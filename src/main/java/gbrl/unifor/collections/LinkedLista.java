package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedLista<E> implements Lista<E> {
    private Node primeiro;
    private Node ultimo;
    private int count = 0;

    // TODO
    @Override
    public int size() {
        return 0;
    }

    // TODO 
    @Override
    public boolean isEmpty() {
        return false;
    }

    // TODO 
    @Override
    public boolean contains(Object o) {
        return false;
    }

    // TODO 
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    // TODO 
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // TODO 
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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

    // TODO 
    @Override
    public boolean remove(Object o) {
        return false;
    }

    // TODO 
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // TODO 
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    // TODO 
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    // TODO 
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // TODO 
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    // TODO 
    @Override
    public void clear() {

    }

    // TODO 
    @Override
    public E get(int index) {
        return null;
    }

    // TODO 
    @Override
    public E set(int index, E element) {
        return null;
    }

    // TODO 
    @Override
    public void add(int index, E element) {

    }

    // TODO 
    @Override
    public E remove(int index) {
        return null;
    }

    // TODO 
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    // TODO 
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    // TODO 
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    // TODO 
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // TODO 
    @Override
    public Lista<E> subList(int fromIndex, int toIndex) {
        return null;
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

