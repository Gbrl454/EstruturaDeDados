package gbrl.unifor.collections;

import gbrl.unifor.collections.heap.HEAPMax;

public class Teste {
    public static void main(String[] args) {

        // x = y | 0
        // x > y | 1
        // x < y | -1

//        Integer indiceFilhoEsq = 3;
//        Integer indiceFilhoDir = 1;
//        System.out.println(indiceFilhoEsq.compareTo(indiceFilhoDir));
//        System.out.println(indiceFilhoEsq.compareTo(indiceFilhoDir) <= 0);
//        System.out.println(indiceFilhoEsq + " | "+indiceFilhoDir);
//        System.out.println(3 <= 1);


        HEAPMax<Integer> heap = new HEAPMax<>(10);

        heap.insert(1);
        System.out.println(heap);
        heap.insert(3);
        System.out.println(heap);
        heap.insert(6);
        System.out.println(heap);
        heap.insert(5);
        System.out.println(heap);
        heap.insert(9);
        System.out.println(heap);
        heap.insert(8);
        System.out.println(heap);
        heap.insert(-2);
        System.out.println(heap);

        System.out.println("Menor: " + heap.get());
        System.out.println("Removendo...");
        heap.remove();
        System.out.println(heap);

        System.out.println("Menor: " + heap.get());
        System.out.println("Removendo...");
        heap.remove();
        System.out.println(heap);
    }
}
