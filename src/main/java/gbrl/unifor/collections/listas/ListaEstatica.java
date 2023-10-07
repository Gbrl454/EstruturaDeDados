package gbrl.unifor.collections.listas;

import gbrl.unifor.collections.abstracts.ListaA;
import gbrl.unifor.collections.interfaces.ColecaoI;

public class ListaEstatica<E> extends ListaA<E> {
    private E[] elements;
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
            elements = objs;
        else novo();
    }

    private void novo() {
        this.initialCapacity = 10;
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[elements.length * 2];
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[this.initialCapacity];
        count = 0;
    }

    @Override
    public E[] toArray() {
        return elements.clone();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);
        return elements[index];
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        if (count == elements.length) {
            E[] vAux = plusArray();
            System.arraycopy(elements, 0, vAux, 0, index);
            System.arraycopy(elements, index, vAux, index + 1, count - index);
            elements = vAux;
        } else System.arraycopy(elements, index, elements, index + 1, count - index);

        elements[index] = element;
        count++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count) return null;

        E e = get(index);
        for (int i = index; i < count - 1; i++)
            elements[i] = elements[i + 1];

        count--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++)
            if (elements[i].equals(o)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = count; i >= 0; i--)
            if (elements[i].equals(o)) return i;
        return -1;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);
        elements[index] = element;
        return elements[index];
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size(); i++) {
            str += (i != size() - 1) ? elements[i] + ", " : elements[i];
        }
        return str += "]";
    }
}
