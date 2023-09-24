package gbrl.unifor.collections;

import java.util.Collection;

public abstract class AbstrataLista<E> implements Lista<E> {
    protected int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // TODO
    @Override
    public Object[] toArray() {
        return new Object[0];
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

    @Override
    public boolean addAll(Collection<E> c) {
        addAll(count, c);
        return true;
    }
}