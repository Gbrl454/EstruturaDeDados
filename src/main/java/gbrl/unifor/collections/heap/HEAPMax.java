package gbrl.unifor.collections.heap;

import gbrl.unifor.collections.abstracts.HEAPA;

public class HEAPMax<E extends Comparable<E>> extends HEAPA<E> {
    public HEAPMax(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected void up(int index) {
        int indexPai;
        E temp;

        if (index != 0) {
            indexPai = (index - 1) / 2;
            if (elements[indexPai].compareTo(elements[index]) < 1) {
                temp = elements[indexPai];
                elements[indexPai] = elements[index];
                elements[index] = temp;
                up(indexPai);
            }
        }
    }

    @Override
    protected void down(int index) {
        int indexMax;
        int indexLeft = 2 * index + 1;
        int indexRight = 2 * index + 2;
        E temp;

        if (indexRight >= count) {
            if (indexLeft >= count) return;
            else indexMax = indexLeft;
        } else {
            if (elements[indexLeft].compareTo(elements[indexRight]) >= 1) indexMax = indexLeft;
            else indexMax = indexRight;
        }

        if (elements[index].compareTo(elements[indexMax]) < 1) {
            temp = elements[indexMax];
            elements[indexMax] = elements[index];
            elements[index] = temp;
            down(indexMax);
        }
    }
}
