package gbrl.unifor.collections;

@SuppressWarnings("unchecked")
public class Pilha<E> {
    private int count;
    private E[] elements;
    private int initialCapacity;

    public Pilha() {
        novo();
    }

    private void novo() {
        this.initialCapacity = 10;
        clear();
    }

    private E[] plusArray() {
        return (E[]) new Object[elements.length * 2];
    }

    public E push(E item) {
        count++;
        if (elements.length < count) plusArray();
        elements[count] = item;
        return item;
    }

    public E pop() {
        count--;
        return elements[count + 1];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E peek() {
        return elements[count];
    }

    public void clear() {
        elements = (E[]) new Object[this.initialCapacity];
        count = -1;
    }

    public int size() {
        return count + 1;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i <= count; i++)
            str += (i != count) ? elements[i] + ", " : elements[i];
        return str += "]";
    }
}
