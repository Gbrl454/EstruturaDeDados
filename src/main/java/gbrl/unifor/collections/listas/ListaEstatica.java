package gbrl.unifor.collections.listas;

import gbrl.unifor.collections.abstracts.ListaA;
import gbrl.unifor.collections.interfaces.ColecaoI;

public class ListaEstatica<E> extends ListaA<E> {
    private E[] vector;
    private int initialCapacity;

    public ListaEstatica() {
        novo();
    }

    public ListaEstatica(int initialCapacity) {
        if (initialCapacity > 0)
            this.initialCapacity = initialCapacity;
        else if (initialCapacity == 0)
            this.initialCapacity = 10;
        else
            throw new IllegalArgumentException("Capacidade Ilegal: " + initialCapacity);

        clear();
    }

    public ListaEstatica(ColecaoI<E> c) {
        E[] objs = c.toArray();
        if ((count = objs.length) != 0)
            vector = objs;
        else
            novo();
    }

    private void novo() {
        this.initialCapacity = 10;
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[vector.length * 2];
    }

    @Override
    public void clear() {
        vector = (E[]) new Object[this.initialCapacity];
        count = 0;
    }

    @Override
    public E[] toArray() {
        return vector.clone();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);
        return vector[index];
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        if (count == vector.length) {
            E[] vAux = plusArray();
            System.arraycopy(vector, 0, vAux, 0, index);
            System.arraycopy(vector, index, vAux, index + 1, count - index);
            vector = vAux;
        } else System.arraycopy(vector, index, vector, index + 1, count - index);

        vector[index] = element;
        count++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count) return null;

        E e = get(index);
        for (int i = index; i < count - 1; i++)
            vector[i] = vector[i + 1];

        count--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++)
            if (vector[i].equals(o)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = count; i >= 0; i--)
            if (vector[i].equals(o)) return i;
        return -1;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);
        vector[index] = element;
        return vector[index];
    }
}