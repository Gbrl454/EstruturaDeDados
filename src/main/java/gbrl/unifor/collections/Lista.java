package gbrl.unifor.collections;

import java.util.Collection;
import java.util.Comparator;

public interface Lista<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    boolean addAll(Collection<E> c);

    boolean addAll(int index, Collection<E> c);

    boolean removeAll(Collection<?> c);

    void sort(Comparator<E> c);

    void clear();

    E get(int index);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);
}
