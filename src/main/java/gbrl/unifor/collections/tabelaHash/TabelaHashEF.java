package gbrl.unifor.collections.tabelaHash;

import gbrl.unifor.collections.listas.ListaEstatica;

public class TabelaHashEF<E> {
    private final int tamanho;
    private ListaEstatica[] tabela;

    public TabelaHashEF(int n) {
        this.tamanho = n;
        clear();
    }

    public void clear() {
        tabela = new ListaEstatica[tamanho];
    }

    private int h(E x) {
        return x.hashCode() % tabela.length;
    }

    public void add(E element) {
        int posicao = h(element);
        if (tabela[posicao] == null) tabela[posicao] = new ListaEstatica<E>();
        tabela[posicao].add(element);
    }

    public void remove(E element) {
        int posicao = h(element);
        if (tabela[posicao] != null) tabela[posicao].remove(element);
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < tabela.length; i++) str += tabela[i] + ((i == tabela.length - 1) ? "" : ", ");
        return str + "]";
    }
}
