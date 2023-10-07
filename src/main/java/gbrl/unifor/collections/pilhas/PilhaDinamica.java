package gbrl.unifor.collections.pilhas;

import gbrl.unifor.collections.abstracts.ColecaoA;
import gbrl.unifor.collections.interfaces.PilhaI;
import gbrl.unifor.collections.util.Node;

import java.util.EmptyStackException;

public class PilhaDinamica<E> extends ColecaoA<E> implements PilhaI<E> {
    private Node<E> topo;

    public PilhaDinamica() {
        clear();
    }

    @Override
    public int size() {
        return count + 1;
    }

    @Override
    public void clear() {
        count = -1;
        topo = null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size() - 1];
        for (int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + size());

        Node<E> atual = topo;
        for (int i = 0; i < size(); i++) {
            if (i == index) return atual.item;
            atual = atual.anterior;
        }
        return null;
    }

    @Override
    public E push(E item) {
        Node<E> atual = new Node<>(item);

        if (topo != null) {
            atual.anterior = topo;
            topo.proximo = atual;
        }

        topo = atual;
        count++;
        return item;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        else if (size() == 1) clear();
        else {
            count--;
            Node<E> top = this.topo;
            this.topo = top.anterior;
            this.topo.proximo = null;
            return top.item;
        }
        return null;

    }

    @Override
    public E peek() {
        return topo.item;
    }

    @Override
    public int search(Object o) {
        int index = 0;
        for (Node<E> x = topo; x != null; x = x.proximo) {
            if (o.equals(x.item)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<E> atual = topo;
        String str = "]";
        while (atual != null) {
            str = (atual.anterior == null) ? atual.item + str : ", " + atual.item + str;
            atual = atual.anterior;
        }
        return "[" + str;
    }
}
