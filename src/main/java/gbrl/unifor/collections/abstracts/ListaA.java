package gbrl.unifor.collections.abstracts;

import gbrl.unifor.collections.interfaces.ColecaoI;
import gbrl.unifor.collections.interfaces.ListaI;

public abstract class ListaA<E> extends ColecaoA<E> implements ListaI<E> {
    @Override
    public boolean add(E e) {
        return add(count, e);
    }

    @Override
    public E remove(Object o) {
        if (!contains(o))
            return null;
        return remove(indexOf(o));
    }

    @Override
    public boolean removeAll(ColecaoI<? extends E> c) {
        if (c.isEmpty()) return false;
        boolean retAll = false;
        for (int i = 0; i < c.size(); i++) {
            E ret = remove(c.get(i));
            retAll = (retAll) || (ret != null);
        }
        return retAll;
    }

    @Override
    public boolean addAll(ColecaoI<? extends E> c) {
        return addAll(count, c);
    }

    @Override
    public boolean addAll(int index, ColecaoI<? extends E> c) {
        if (c.isEmpty()) return false;
        boolean retAll = false;
        for (int i = 0; i < c.size(); i++) {
            boolean ret = add(index, c.get(i));
            index++;
            retAll = (retAll) || (ret);
        }
        return retAll;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(ColecaoI<? extends E> c) {
        if (c.isEmpty()) return false;

        boolean retAll = true;

        for (int i = 0; i < c.size(); i++) {
            boolean ret = contains(c.get(i));
            if (!ret)
                retAll = false;
        }

        return retAll;
    }
}
