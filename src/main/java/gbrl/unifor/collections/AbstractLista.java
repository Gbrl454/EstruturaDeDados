package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class AbstractLista<E> implements Lista<E> {
    protected int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    // TODO
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    // TODO
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // TODO
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        add(count, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o))
            return false;
        remove(indexOf(o));
        return true;
    }

    // TODO
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(count, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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

    // TODO
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    // TODO
    @Override
    public E set(int index, E element) {
        return null;
    }

    // TODO
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    // TODO
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    // TODO
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // TODO
    @Override
    public Lista<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
