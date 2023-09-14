package gbrl.unifor.collections;

public class ListaEncadeadaOrdenada<E extends Comparable<E>> {
    private Node<E> primeiro;
    private Node<E> ultimo;
    private int count = 0;

    public ListaEncadeadaOrdenada() {
        novo();
    }

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

    public int size() {
        return count;
    }

    private void novo() {
        primeiro = null;
        ultimo = null;
        count = 0;
    }

    public boolean add(E element) {
        Node<E> novo = new Node<>(element);
        if (contains(novo.item)) {
            return false;
        }

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

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = primeiro; x != null; x = x.proximo) {
            if (o.equals(x.item)) return index;
            index++;
        }
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

        Node(E item) {
            this.item = item;
        }
    }
}