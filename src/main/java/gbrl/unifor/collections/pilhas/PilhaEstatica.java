package gbrl.unifor.collections.pilhas;

import gbrl.unifor.collections.abstracts.ColecaoA;
import gbrl.unifor.collections.interfaces.PilhaI;

import java.util.EmptyStackException;

public class PilhaEstatica<E> extends ColecaoA<E> implements PilhaI<E> {
    private E[] elements;

    public PilhaEstatica() {
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[elements.length * 2];
    }

    @Override
    public int size() {
        return count + 1;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[10];
        count = -1;
    }

    @Override
    public E[] toArray() {
        return elements.clone();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + size());
        return elements[index];
    }

    @Override
    public E push(E item) {
        count++;
        if (elements.length < count) plusArray();
        elements[count] = item;
        return item;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return elements[count--];
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return elements[count];
    }

    @Override
    public int search(Object o) {
        for (int i = 0; i < count; i++)
            if (elements[i].equals(o)) return i;
        return -1;
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
