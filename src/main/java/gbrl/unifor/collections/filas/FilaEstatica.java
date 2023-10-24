package gbrl.unifor.collections.filas;

import gbrl.unifor.collections.abstracts.ColecaoA;
import gbrl.unifor.collections.interfaces.ColecaoI;
import gbrl.unifor.collections.interfaces.FilaI;

public class FilaEstatica<E> extends ColecaoA<E> implements FilaI<E> {
    private E[] elements;
    private int inicio;
    private int fim;
    private int initialCapacity;

    public FilaEstatica() {
        novo();
    }

    public FilaEstatica(int initialCapacity) {
        if (initialCapacity > 0) this.initialCapacity = initialCapacity;
        else if (initialCapacity == 0) this.initialCapacity = 10;
        else throw new IllegalArgumentException("Capacidade Ilegal: " + initialCapacity);
        clear();
    }

    public FilaEstatica(ColecaoI<E> c) {
        E[] objs = c.toArray();
        if ((count = objs.length) != 0) elements = objs;
        else novo();
    }

    private void novo() {
        this.initialCapacity = 10;
        clear();
    }

    private int plusArray() {
        int size = size() - 1;
        E[] vAux = (E[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, vAux, 0, size);
        elements = vAux;
        return size;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[this.initialCapacity];
        inicio = 0;
        fim = -1;
    }

    @Override
    public E[] toArray() {
        return elements.clone();
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public boolean enqueue(E element) {
        fim++;
        if (fim == elements.length) fim = 0;
        if (fim == inicio && size() > 1) fim = plusArray();
        elements[fim] = element;
        count++;
        return true;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        return elements[inicio++];
    }

    @Override
    public E peek() {
        return elements[inicio];
    }

    @Override
    public String toString() {
        int tam = size() - 1;
        String str = "[";
        for (int i = 0; i < tam; i++) str += (i != tam - 1) ? elements[i] + ", " : elements[i];
        return str += "]";
    }
}
