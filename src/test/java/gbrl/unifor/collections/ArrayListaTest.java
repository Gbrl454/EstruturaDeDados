package gbrl.unifor.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListaTest {
    private ArrayLista<String> arrayLista;

    @BeforeEach
    public void setUp() {
        arrayLista = new ArrayLista<>();
    }

    @Test
    @DisplayName("Adicionando elementos e os pegando")
    void testAddGet() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");

        assertEquals("Item 1", arrayLista.get(0));
        assertEquals("Item 2", arrayLista.get(1));
        assertEquals("[Item 1, Item 2]", arrayLista.toString());
    }

    @Test
    @DisplayName("Adicionando muitos elementos")
    void testAddN() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");
        arrayLista.add("Item 3");
        arrayLista.add("Item 4");
        arrayLista.add("Item 5");
        arrayLista.add("Item 7");
        arrayLista.add("Item 8");
        arrayLista.add("Item 9");
        arrayLista.add("Item 10");
        arrayLista.add("Item 11");
        arrayLista.add(5, "Item 6");
        arrayLista.add("Item 12");
        arrayLista.add("Item 13");
        arrayLista.add("Item 14");
        arrayLista.add("Item 15");
        arrayLista.add("Item 16");
        arrayLista.add("Item 17");
        arrayLista.add("Item 18");
        arrayLista.add("Item 19");
        arrayLista.add("Item 20");
        arrayLista.add("Item 21");
        assertEquals("Item 1", arrayLista.get(0));
        assertEquals("Item 2", arrayLista.get(1));
        assertEquals("Item 3", arrayLista.get(2));
        assertEquals("Item 4", arrayLista.get(3));
        assertEquals("Item 5", arrayLista.get(4));
        assertEquals("Item 6", arrayLista.get(5));
        assertEquals("Item 7", arrayLista.get(6));
        assertEquals("Item 8", arrayLista.get(7));
        assertEquals("Item 9", arrayLista.get(8));
        assertEquals("Item 10", arrayLista.get(9));
        assertEquals("Item 11", arrayLista.get(10));
        assertEquals("Item 12", arrayLista.get(11));
        assertEquals("Item 13", arrayLista.get(12));
        assertEquals("Item 14", arrayLista.get(13));
        assertEquals("Item 15", arrayLista.get(14));
        assertEquals("Item 16", arrayLista.get(15));
        assertEquals("Item 17", arrayLista.get(16));
        assertEquals("Item 18", arrayLista.get(17));
        assertEquals("Item 19", arrayLista.get(18));
        assertEquals("Item 20", arrayLista.get(19));
        assertEquals("Item 21", arrayLista.get(20));

        assertEquals("[Item 1, Item 2, Item 3, Item 4, Item 5, Item 6, Item 7, Item 8, Item 9, Item 10, Item 11, Item 12, Item 13, Item 14, Item 15, Item 16, Item 17, Item 18, Item 19, Item 20, Item 21]"
                , arrayLista.toString());
    }

    @Test
    @DisplayName("Adicionando elementos e os pegando de índice inválido")
    void testGetIndexOutOfBounds() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");

        assertEquals(
                "Índice 5 fora dos limites para comprimento 2",
                assertThrows(IndexOutOfBoundsException.class, () -> arrayLista.get(5)).getMessage());
        assertEquals("Item 1", arrayLista.get(0));
        assertEquals("Item 2", arrayLista.get(1));
        assertEquals("[Item 1, Item 2]", arrayLista.toString());
    }

    @Test
    @DisplayName("Vendo o comprimento")
    void testSize() {
        assertEquals(0, arrayLista.size());

        arrayLista.add("Item 1");
        arrayLista.add("Item 2");

        assertEquals(2, arrayLista.size());
        assertEquals("[Item 1, Item 2]", arrayLista.toString());
    }

    @Test
    @DisplayName("Adicionando elementos colocando um índice")
    void testAddIndex() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 3");
        arrayLista.add(1, "Item 2");

        assertEquals("Item 1", arrayLista.get(0));
        assertEquals("Item 2", arrayLista.get(1));
        assertEquals("Item 3", arrayLista.get(2));
        assertEquals("[Item 1, Item 2, Item 3]", arrayLista.toString());
    }

    @Test
    @DisplayName("Adicionando elementos colocando um índice muito maior que o contador")
    void testAddIndexMaisN() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");
        assertEquals(
                "Índice: 7, Comprimento: 2",
                assertThrows(IndexOutOfBoundsException.class, () -> arrayLista.add(7, "Item 7")).getMessage());
    }

    @Test
    @DisplayName("Adicionando elementos colocando um índice igual ao contador")
    void testAddIndexMais1() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");
        arrayLista.add(2, "Item 3");

        assertEquals("Item 1", arrayLista.get(0));
        assertEquals("Item 2", arrayLista.get(1));
        assertEquals("Item 3", arrayLista.get(2));
        assertEquals("[Item 1, Item 2, Item 3]", arrayLista.toString());
    }

    @Test
    @DisplayName("Limpando items")
    void testClear() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");
        arrayLista.clear();

        assertTrue(arrayLista.isEmpty());
        assertEquals(0, arrayLista.size());
        assertEquals("[]", arrayLista.toString());
    }

    @Test
    @DisplayName("Pegando elemento por Índice")
    void testIndexOf() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");

        assertEquals(0, arrayLista.indexOf("Item 1"));
        assertEquals(1, arrayLista.indexOf("Item 2"));
        assertEquals(-1, arrayLista.indexOf("Item 3"));
        assertEquals("[Item 1, Item 2]", arrayLista.toString());
    }

    @Test
    @DisplayName("Verificando se contém item")
    void testContains() {
        arrayLista.add("Item 1");
        arrayLista.add("Item 2");

        assertTrue(arrayLista.contains("Item 1"));
        assertTrue(arrayLista.contains("Item 2"));
        assertFalse(arrayLista.contains("Item 3"));
        assertEquals("[Item 1, Item 2]", arrayLista.toString());
    }
}
