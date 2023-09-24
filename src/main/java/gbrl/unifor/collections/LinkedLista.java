package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Comparator;

public class LinkedLista<E> extends AbstrataLista<E> {
    private Node<E> primeiro;
    private Node<E> ultimo;

    public LinkedLista() {
        novo();
    }

    // public LinkedLista(Collection<E> c) {
    //     novo();
    //     if (!c.isEmpty())
    //         addAll(c);
    // }

    private void novo() {
        primeiro = null;
        ultimo = null;
        count = 0;
    }

    @Override
    public boolean addAll(int index, Collection<E> c) {
        //     LinkedLista<E> lista = new LinkedLista<>(c);
        //     if (lista.size() == 0) return false;
        //     for (int i = 0; i < lista.size(); i++)
        //         add(index + i, lista.get(i));
        //     return true;
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        //    LinkedLista lista = new LinkedLista<>(c);
        //    if (lista.size() == 0) return false;
        //    for (int i = 0; i < c.size(); i++)
        //        remove(lista.get(i));
        //    return true;
        return false;
    }

    // TODO
    @Override
    public void sort(Comparator<E> c) {
    }

    @Override
    public void clear() {
        primeiro = null;
        ultimo = null;
        count = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);

        Node<E> atual = primeiro;
        for (int i = 0; i < count; i++) {
            if (i == index) return atual.item;
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        Node<E> novo = new Node<>(element);

        if (index == 0) {
            primeiro = novo;
            ultimo = novo;
            count++;
        } else if (index == count) {
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            ultimo = novo;
            count++;
        } else {
            Node<E> atual = primeiro;
            for (int i = 0; i < count; i++) {
                if (i == (index - 1)) {
                    atual.proximo.anterior = novo;
                    atual.proximo = novo;
                    count++;
                    return;
                }
                atual = atual.proximo;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count)
            return null;

        if (index == 0) {
            E ret = primeiro.item;
            Node<E> prox = primeiro.proximo;
            if (prox != null)
                prox.anterior = null;
            primeiro = primeiro.proximo;
            count--;
            return ret;
        }

        if (index == count - 1) {
            E ret = ultimo.item;
            ultimo.anterior.proximo = null;
            ultimo = ultimo.anterior;
            count--;
            return ret;
        }

        Node<E> atual = primeiro;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                Node<E> anterior = atual.anterior;
                if (anterior != null)
                    anterior.proximo = atual.proximo;

                Node<E> proximo = atual.proximo;
                if (proximo != null)
                    proximo.anterior = atual.anterior;

                count--;
                return atual.item;
            }
            atual = atual.proximo;
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = primeiro; x != null; x = x.proximo) {
            if (o.equals(x.item)) return index;
            index++;
        }
        return -1;
    }

    // TODO
    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
