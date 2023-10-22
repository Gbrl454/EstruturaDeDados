package gbrl.unifor.listas.av2.lista3;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Q1062D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            n = sc.nextInt();
            if (n == 0) break;

            while (true) {
                Stack<Integer> pilhaE = new Stack<>();
                for (int i = 0; i < n; i++) {
                    int ent = sc.nextInt();
                    if (ent == 0) break;
                    pilhaE.push(ent);
                }

                if (pilhaE.size() != n) break;

                Stack<Integer> pilhaS = new Stack<>();
                for (int i = 1; i <= n; i++) pilhaS.push(i);

                Stack<Integer> pilhaA = new Stack<>();
                for (int i = 0; i < n; i++) {
                    if (!pilhaE.isEmpty()) pilhaA.push(pilhaE.pop());
                    while (!pilhaA.isEmpty() && (Objects.equals(pilhaA.peek(), pilhaS.peek()))) {
                        pilhaA.pop();
                        pilhaS.pop();
                        i--;
                    }
                }
                System.out.println((pilhaA.isEmpty() && pilhaE.isEmpty() && pilhaS.isEmpty()) ? "Yes" : "No");
            }
            System.out.println();
        }
    }
}
