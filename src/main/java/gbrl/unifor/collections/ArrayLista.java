package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ArrayLista<E> extends AbstractLista<E> {
    private int initialCapacity;
    private E[] v;

    public ArrayLista() {
        novo();
    }

    public ArrayLista(int initialCapacity) {
        if (initialCapacity > 0)
            this.initialCapacity = initialCapacity;
        else if (initialCapacity == 0)
            this.initialCapacity = 10;
        else
            throw new IllegalArgumentException("Capacidade Ilegal: " + initialCapacity);

        clear();
    }

    public ArrayLista(Collection<E> c) {
        E[] objs = (E[]) c.toArray();
        if ((count = objs.length) != 0)
            v = objs;
        else
            novo();
    }

    private void novo() {
        this.initialCapacity = 10;
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[v.length * 2];
    }

    @Override
    public boolean addAll(int index, Collection<E> c) {
        ArrayLista<E> lista = new ArrayLista<>(c);
        if (lista.size() == 0) return false;
        for (int i = 0; i < lista.size(); i++)
            add(index + i, lista.get(i));
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        ArrayLista lista = new ArrayLista<>(c);
        if (lista.size() == 0) return false;
        for (int i = 0; i < c.size(); i++)
            remove(lista.get(i));
        return true;
    }

    @Override
    public void sort(Comparator<E> c) {
        if (c == null) c = (Comparator<E>) Comparator.naturalOrder();

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < count; i++) {
                if (c.compare(v[i - 1], v[i]) > 0) {
                    E temp = v[i - 1];
                    v[i - 1] = v[i];
                    v[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
    public void clear() {
        v = (E[]) new Object[this.initialCapacity];
        count = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + ", Comprimento " + count);
        return v[index];
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        if (count == v.length) {
            E[] vAux = plusArray();
            System.arraycopy(v, 0, vAux, 0, index);
            System.arraycopy(v, index, vAux, index + 1, count - index);
            v = vAux;
        } else
            System.arraycopy(v, index, v, index + 1, count - index);

        v[index] = element;
        count++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count)
            return null;

        E e = get(index);
        for (int i = index; i < count; i++)
            v[i] = v[i + 1];

        count--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++)
            if (v[i].equals(o)) return i;
        return -1;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < count; i++) {
            str += (i != count - 1) ? v[i] + ", " : v[i];
        }
        return str += "]";
    }
}
