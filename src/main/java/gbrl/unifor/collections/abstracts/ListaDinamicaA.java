package gbrl.unifor.collections.abstracts;

import gbrl.unifor.collections.util.Node;

public abstract class ListaDinamicaA<E> extends ListaA<E> {
    protected Node<E> primeiro;
    protected Node<E> ultimo;

    public ListaDinamicaA() {
        clear();
    }

    @Override
    public void clear() {
        count = 0;
        primeiro = null;
        ultimo = null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size() - 1];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size()) return null;

        if (index == 0) {
            if (size() > 1) {
                E ret = primeiro.item;
                Node<E> prox = primeiro.proximo;
                if (prox != null) prox.anterior = null;
                primeiro = prox;
                count--;
                return ret;
            } else clear();
        } else if (index == size() - 1) {
            E ret = ultimo.item;
            ultimo.anterior.proximo = null;
            ultimo = ultimo.anterior;
            count--;
            return ret;
        } else {
            int idx = 0;
            for (Node<E> x = primeiro; x != null; x = x.proximo) {
                if (idx == index) {

                    Node<E> anterior = x.anterior;
                    if (anterior != null) anterior.proximo = x.proximo;

                    Node<E> proximo = x.proximo;
                    if (proximo != null) proximo.anterior = x.anterior;

                    count--;
                    return x.item;
                }
                idx++;
            }
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

    @Override
    public int lastIndexOf(Object o) {
        int index = size();
        for (Node<E> x = ultimo; x != null; x = x.anterior) {
            if (o.equals(x.item)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + size());

        Node<E> atual = primeiro;
        for (int i = 0; i < size(); i++) {
            if (i == index) return atual.item;
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + size());

        Node<E> atual = primeiro;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                atual.item = element;
                return atual.item;
            }
            atual = atual.proximo;
        }
        return null;
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
}

