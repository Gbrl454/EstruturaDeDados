package gbrl.unifor.listas.av2.lista5;

import java.util.Scanner;

public class Q1257 {
    private static final int HC_C = 65;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int l;
            do l = sc.nextInt(); while (l < 1 || l > 100);

            int calc = 0;
            for (int j = 0; j < l; j++) {
                String str = sc.next().toUpperCase();
                String[] strArr = str.split("");
                for (int k = 0; k < strArr.length; k++) calc += (pocisao(strArr[k], j, k));
            }
            System.out.println(calc);
        }
    }

    private static int pocisao(String chr, int ent, int pos) {
        return (chr.hashCode() - HC_C) + ent + pos;
    }
}
