package gbrl.unifor.collections.interfaces;

public interface PilhaI<E> extends ColecaoI<E> {
    /**
     * Adiciona um elemento ao topo da pilha.
     */
    E push(E item);

    /**
     * Remove e retorna o elemento no topo da pilha.
     */
    E pop();

    /**
     * Retorna o elemento no topo da pilha sem removê-lo.
     */
    E peek();

    /**
     * Retorna a posição de um item na pilha
     */
    int search(Object o);
}
