package gbrl.unifor.collections.filas;

import gbrl.unifor.collections.abstracts.ColecaoA;
import gbrl.unifor.collections.interfaces.FilaI;
import gbrl.unifor.collections.util.Node;

public class FilaDinamica<E> extends ColecaoA<E> implements FilaI<E> {
    private Node<E> inicio;
    private Node<E> fim;

    public FilaDinamica() {
        clear();
    }

    @Override
    public void clear() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size() - 1];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + size());
        Node<E> atual = inicio;
        for (int i = 0; i < size(); i++) {
            if (i == index) return atual.item;
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public boolean enqueue(E element) {
        Node<E> novo = new Node<>(element);
        if (inicio == null) inicio = novo;
        else {
            fim.proximo = novo;
            novo.anterior = fim;
        }
        count++;
        fim = novo;
        return true;
    }

    @Override
    public E dequeue() {
        Node<E> dado = inicio;
        if (size() == 1) {
            clear();
            count--;
            return dado.item;
        } else if (dado != null) {
            inicio = inicio.proximo;
            inicio.anterior = null;
            dado.proximo = null;
            count--;
            return dado.item;
        }
        return null;
    }

    @Override
    public E peek() {
        return inicio.item;
    }

    @Override
    public String toString() {
        Node<E> atual = inicio;
        String str = "[";
        while (atual != null) {
            str += (atual.proximo == null) ? atual.item : atual.item + ", ";
            atual = atual.proximo;
        }
        return str + "]";
    }
}
