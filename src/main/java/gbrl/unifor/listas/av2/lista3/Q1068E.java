package gbrl.unifor.listas.av2.lista3;

import gbrl.unifor.collections.pilhas.PilhaEstatica;

import java.util.Scanner;

public class Q1068E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            String exp = sc.next();
            PilhaEstatica<Character> pilha = new PilhaEstatica<>();
            boolean error = false;

            for (int i = 0; i < exp.length(); i++)
                try {
                    if (exp.charAt(i) == '(') pilha.push(exp.charAt(i));
                    else if (exp.charAt(i) == ')') pilha.pop();
                } catch (Exception e) {
                    error = true;
                }

            error = !pilha.isEmpty() || error;
            System.out.println((error) ? "incorrect" : "correct");
        } while (sc.hasNext());
    }
}
