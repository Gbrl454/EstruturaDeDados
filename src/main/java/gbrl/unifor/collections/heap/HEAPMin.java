package gbrl.unifor.collections.heap;

import gbrl.unifor.collections.abstracts.HEAPA;

public class HEAPMin<E extends Comparable<E>> extends HEAPA<E> {
    public HEAPMin(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected void up(int index) {
        int indexPai;
        E temp;

        if (index != 0) {
            indexPai = (index - 1) / 2;

            if (elements[indexPai].compareTo(elements[index]) >= 1) {
                temp = elements[indexPai];
                elements[indexPai] = elements[index];
                elements[index] = temp;
                up(indexPai);
            }
        }
    }

    @Override
    protected void down(int indice) {
        int indiceFilhoEsq = 2 * indice + 1;
        int indiceFilhoDir = 2 * indice + 2;
        int indiceMin;
        E temp;

        if (indiceFilhoDir >= count) {
            if (indiceFilhoEsq >= count) return;
            else indiceMin = indiceFilhoEsq;
        } else {
            if (elements[indiceFilhoEsq].compareTo(elements[indiceFilhoDir]) <= 0) indiceMin = indiceFilhoEsq;
            else indiceMin = indiceFilhoDir;
        }

        if (elements[indice].compareTo(elements[indiceMin]) > 0) {
            temp = elements[indiceMin];
            elements[indiceMin] = elements[indice];
            elements[indice] = temp;
            down(indiceMin);
        }
    }
}
