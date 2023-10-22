package gbrl.unifor.collections.filas;

import gbrl.unifor.collections.abstracts.ColecaoA;
import gbrl.unifor.collections.interfaces.FilaI;
import gbrl.unifor.collections.util.Node;

public class FilaDinamicaPrioridade<E> extends ColecaoA<E> implements FilaI<E> {
    private Node<E> inicio;
    private Node<E> fim;

    public FilaDinamicaPrioridade() {
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
        return enqueue(element, 0);
    }

    /**
     * Adiciona um elemento à fila com a prioridade especificada.
     */
    public boolean enqueue(E element, int priority) {
        Node<E> novo = new Node<>(element, priority);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
            count++;
        } else if (novo.prioridade.compareTo(inicio.prioridade) < 0) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
            count++;
        } else if (novo.prioridade.compareTo(fim.prioridade) > 0) {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
            count++;
        } else {
            Node<E> aux = inicio;

            while (aux != null && ((novo.prioridade.compareTo(aux.prioridade)) >= 0)) aux = aux.proximo;

            novo.anterior = aux.anterior;
            aux.anterior.proximo = novo;
            novo.proximo = aux;
            aux.anterior = novo;
            count++;
        }
        return true;
    }

    @Override
    public E dequeue() {
        if (inicio != null) {
            Node<E> dado = inicio;
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
}
