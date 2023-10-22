package gbrl.unifor.collections.abstracts;

import gbrl.unifor.collections.interfaces.HEAPI;

public abstract class HEAPA<E extends Comparable<E>> extends ColecaoA<E> implements HEAPI<E> {
    protected final int initialCapacity;
    protected E[] elements;

    protected HEAPA(int initialCapacity) {
        if (initialCapacity > 0) this.initialCapacity = initialCapacity;
        else if (initialCapacity == 0) this.initialCapacity = 10;
        else throw new IllegalArgumentException("Capacidade Ilegal: " + initialCapacity);
        clear();
    }

    @Override
    public void clear() {
        elements = (E[]) new Comparable[this.initialCapacity];
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
    public boolean insert(E e) {
        if (count == elements.length)
            throw new IndexOutOfBoundsException("Capacidade máxima de " + initialCapacity + " elementos atingida no HEAP");

        elements[count] = e;
        count++;
        up(count - 1);
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new RuntimeException("HEAP vazio");

        E e = elements[0];
        elements[0] = elements[count - 1];
        count--;
        if (count > 0) down(0);
        return e;
    }

    @Override
    public E get() {
        return get(0);
    }

    @Override
    public boolean merge(HEAPI heapA, HEAPI heapB) {
        return false;
    }

    protected abstract void up(int index);

    protected abstract void down(int index);

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size(); i++) str += (i != size() - 1) ? elements[i] + ", " : elements[i];
        return str += "]";
    }
}
