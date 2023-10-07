package gbrl.unifor.collections.abstracts;

import gbrl.unifor.collections.interfaces.ColecaoI;

public abstract class ColecaoA<E> implements ColecaoI<E> {
    protected int count;

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
