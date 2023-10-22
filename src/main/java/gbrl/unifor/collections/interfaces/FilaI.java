package gbrl.unifor.collections.interfaces;

public interface FilaI<E> extends ColecaoI<E> {
    /**
     * Adiciona um elemento ao final da fila.
     */
    boolean enqueue(E element);

    /**
     * Remove e retorna o elemento no início da fila.
     */
    E dequeue();

    /**
     * Retorna o elemento no início da fila sem removê-lo.
     */
    E peek();
}
