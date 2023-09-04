package gbrl.unifor.collections;

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

