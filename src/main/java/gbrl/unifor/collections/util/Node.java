package gbrl.unifor.collections.util;

public class Node<E> {
    public E item;
    public Node<E> anterior;
    public Node<E> proximo;
    public int prioridade;

    public Node(E item) {
        this.item = item;
    }

    public Node(E item, int prioridade) {
        this.item = item;
        this.prioridade = prioridade;
    }
}
