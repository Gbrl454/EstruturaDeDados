package gbrl.unifor.collections.interfaces;

public interface ColecaoI<E> {
    /**
     * Retorna true se a coleção estiver vazia, caso contrário, false.
     */
    boolean isEmpty();

    /**
     * Retorna o número de elementos na coleção.
     */
    int size();

    /**
     * Remove todos os elementos da coleção.
     */
    void clear();

    /**
     * Converte a coleção em um array.
     */
    E[] toArray();

    /**
     * Retorna o elemento na posição especificada.
     */
    E get(int index);
}
