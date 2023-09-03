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

    // TODO
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // TODO
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    // TODO
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    // TODO
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // TODO
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    // TODO
    @Override
    public void clear() {

    }

    // TODO
    @Override
    public E get(int index) {
        return null;
    }

    // TODO
    @Override
    public E set(int index, E element) {
        return null;
    }

    // TODO
    @Override
    public void add(int index, E element) {

    }

    // TODO
    @Override
    public E remove(int index) {
        return null;
    }

    // TODO
    @Override
    public int indexOf(Object o) {
        return 0;
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
