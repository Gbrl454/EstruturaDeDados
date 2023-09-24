package gbrl.unifor.collections;

public class PilhaDinamica<E> {
    private int count;
    private Node<E> topo;

    public PilhaDinamica() {
        clear();
    }

    public E push(E item) {
        Node<E> atual = new Node<>(item);

        if (topo != null) {
            atual.anterior = topo;
            topo.proximo = atual;
        }
        topo = atual;
        count++;
        return item;
    }

    public E pop() {
        count--;
        Node<E> topo = this.topo;
        this.topo = topo.anterior;
        this.topo.proximo = null;
        return topo.item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E peek() {
        return topo.item;
    }

    public void clear() {
        count = -1;
        topo = null;
    }

    public int size() {
        return count + 1;
    }

    @Override
    public String toString() {
        Node<E> atual = topo;
        String str = "]";
        while (atual != null) {
            str = (atual.anterior == null) ? atual.item + str : ", " + atual.item + str;
            atual = atual.anterior;
        }
        return "[" + str;
    }

    private static class Node<E> {
        E item;
        Node<E> anterior;
        Node<E> proximo;

        Node(E item) {
            this.item = item;
        }
    }
}
