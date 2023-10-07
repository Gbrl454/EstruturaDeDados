package gbrl.unifor.collections.interfaces;

public interface ListaI<E> extends ColecaoI<E> {
    /***
     * Adiciona um elemento à lista.
     */
    boolean add(E e);

    /**
     * Insere um elemento em uma posição específica da lista.
     */
    boolean add(int index, E element);

    /**
     * Remove o elemento na posição especificada.
     */
    E remove(int index);

    /**
     * Remove a primeira ocorrência do objeto na lista.
     */
    E remove(Object o);

    /**
     * Remove todos os elementos da lista que também estão na coleção especificada.
     */
    boolean removeAll(ColecaoI<? extends E> c);

    /**
     * Adiciona todos os elementos de uma coleção à lista.
     */
    boolean addAll(ColecaoI<? extends E> c);

    /**
     * Adiciona todos os elementos de uma coleção a partir de uma posição específica.
     */
    boolean addAll(int index, ColecaoI<? extends E> c);

    /**
     * Retorna true se a lista contiver o objeto especificado, caso contrário, false.
     */
    boolean contains(Object o);

    /**
     * Retorna true se a lista contiver todos os elementos da coleção especificada, caso contrário, false.
     */
    boolean containsAll(ColecaoI<? extends E> c);

    /**
     * Retorna o índice da primeira ocorrência do objeto na lista, ou -1 se não for encontrado.
     */
    int indexOf(Object o);

    /**
     * Retorna o índice da última ocorrência do objeto na lista, ou -1 se não for encontrado.
     */
    int lastIndexOf(Object o);

    /**
     * Substitui o elemento na posição especificada por um novo elemento.
     */
    E set(int index, E element);
}
