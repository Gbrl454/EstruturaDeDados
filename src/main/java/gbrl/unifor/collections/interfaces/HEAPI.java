package gbrl.unifor.collections.interfaces;

public interface HEAPI<E> {
    /***
     * Adiciona um elemento ao HEAP.
     */
    boolean insert(E e);

    /**
     * Remove o elemento prioritário do HEAP.
     */
    E remove();

    /**
     * Retorna o elemento prioritário do HEAP.
     */
    E get();

    /**
     * Para heaps binários, esse método combina dois heaps em um único heap. A operação de união é útil em algoritmos de fila de prioridade.
     */
    boolean merge(HEAPI heapA, HEAPI heapB);

}
