package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("unchecked")
public class ArrayLista<E> implements Lista<E> {
    private int count = 0;
    private E[] v;

    public ArrayLista() {
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[v.length * 2];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < count; i++) {
            if (v[i].equals(e)) return true;
        }
        return false;
    }

    // TODO
    @Override
    public Iterator iterator() {
        return null;
    }

    // TODO
    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public void add(E e) {
        if (count == v.length) {
            E[] vAux = plusArray();
            System.arraycopy(v, 0, vAux, 0, v.length);
            v = vAux;
        }
        v[count] = e;
        count++;
    }

    @Override
    public void remove(E e) {
        remove(indexOf(e));
    }

    // TODO
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    // TODO
    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        v = (E[]) new Object[10];
        count = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites para comprimento " + count);
        return v[index];
    }

    // TODO
    @Override
    public E set(int index, E element) {
        return null;
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
    public Object remove(int index) {
        if (index < 0 || index > count)
            return null;

        Object o = get(index);
        for (int i = index; i < count; i++) {
            v[i] = v[i + 1];
        }
        count--;
        return o;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < count; i++) {
            if (v[i].equals(e)) return i;
        }
        return -1;
    }

    // TODO
    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    // TODO
    @Override
    public ListIterator listIterator() {
        return null;
    }

    // TODO
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    // TODO
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    // TODO
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    // TODO
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    // TODO
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    // TODO
    @Override
    public E[] toArray(E[] a) {
        return null;
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

