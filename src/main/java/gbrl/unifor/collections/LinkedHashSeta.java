package gbrl.unifor.collections;

public class LinkedHashSeta<E> {
    private Node<E> primeiro;
    private Node<E> ultimo;
    private int count = 0;

    public LinkedHashSeta() {
        novo();
    }

    private void novo() {
        primeiro = null;
        ultimo = null;
        count = 0;
    }

    public boolean add(E element) {
        Node<E> novo = new Node<>(element);
        if (contains(novo.item)) {
            return false;
        }

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else if (novo.compareTo(primeiro) < 0) {
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;
        } else if (novo.compareTo(ultimo) > 0) {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        } else {
            Node<E> aux = primeiro;

            while (aux != null && ((novo.compareTo(aux)) >= 0)) aux = aux.proximo;

            novo.anterior = aux.anterior;
            aux.anterior.proximo = novo;
            novo.proximo = aux;
            aux.anterior = novo;
        }

        return true;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = primeiro; x != null; x = x.proximo) {
            if (o.equals(x.item)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<E> atual = primeiro;
        String str = "[";
        while (atual != null) {
            str += (atual.proximo == null) ? atual.item : atual.item + ", ";
            atual = atual.proximo;
        }
        return str + "]";
    }

    private static class Node<E> implements Comparable<Node<E>> {
        E item;
        Node<E> anterior;
        Node<E> proximo;

        Node(E item) {
            this.item = item;
        }

        @Override
        public int compareTo(Node<E> o) {
            String obj = objToAscii(o.item);
            String itm = objToAscii(item);
            return itm.compareTo(obj);
        }

        private String objToAscii(E item) {
            String input = item.toString();
            String ascii = "";

            for (int i = 0; i < input.length(); i++) {
                ascii += input.charAt(i) + " ";
            }

            return ascii;
        }
    }
}
