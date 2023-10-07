package gbrl.unifor.collections.listas;

import gbrl.unifor.collections.abstracts.ListaDinamicaA;
import gbrl.unifor.collections.interfaces.ColecaoI;
import gbrl.unifor.collections.util.Node;

public class ListaDinamica<E> extends ListaDinamicaA<E> {
    public ListaDinamica() {
        super();
    }

    public ListaDinamica(ColecaoI<? extends E> c) {
        super();
        addAll(c);
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Índice: " + index + ", Comprimento: " + count);

        Node<E> novo = new Node<>(element);

        if (index == 0) {
            primeiro = novo;
            ultimo = novo;
            count++;
            return true;
        } else if (index == count) {
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            ultimo = novo;
            count++;
            return true;
        } else {
            Node<E> atual = primeiro;
            for (int i = 0; i < count; i++) {
                if (i == (index - 1)) {
                    atual.proximo.anterior = novo;
                    atual.proximo = novo;
                    count++;
                    return true;
                }
                atual = atual.proximo;
            }
        }
        return false;
    }
}
