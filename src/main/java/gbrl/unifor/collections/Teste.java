package gbrl.unifor.collections;

public class Teste {
    public static void main(String[] args) {
        LinkedHashSeta<String> listaOrdenada = new LinkedHashSeta<>();
        listaOrdenada.add("Abacaxi");
        listaOrdenada.add("Abacaxi");
        listaOrdenada.add("Abacaxi");
        listaOrdenada.add("Maracuja");
        listaOrdenada.add("Manga");
        listaOrdenada.add("Banana");
        System.out.println(listaOrdenada);

    }
}
