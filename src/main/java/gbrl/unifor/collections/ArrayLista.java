package gbrl.unifor.collections;

@SuppressWarnings("unchecked")
public class ArrayLista<E> {
    private Object[] v = new Object[10];
    private int count = 0;

    private Object[] plusArray() {
        return new Object[v.length * 2];
    }

    public void add(Object e) {
        if (count == v.length) {
            Object[] vAux = plusArray();
            System.arraycopy(v, 0, vAux, 0, v.length);
            v = vAux;
        }
        v[count] = e;
        count++;
    }

    public void add(int index, Object e) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        if (count == v.length) {
            Object[] vAux = plusArray();
            System.arraycopy(v, 0, vAux, 0, index);
            System.arraycopy(v, index, vAux, index + 1, count - index);
            v = vAux;
        } else
            System.arraycopy(v, index, v, index + 1, count - index);

        v[index] = e;
        count++;
    }

    public void clear() {
        v = new Object[10];
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public E get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Índice " + index + " fora dos limites para comprimento " + count);
        return (E) v[index];
    }

    public int indexOf(Object e) {
        for (int i = 0; i < count; i++) {
            if (v[i].equals(e)) return i;
        }
        return -1;
    }

    public boolean contains(Object e) {
        for (int i = 0; i < count; i++) {
            if (v[i].equals(e)) return true;
        }
        return false;
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

