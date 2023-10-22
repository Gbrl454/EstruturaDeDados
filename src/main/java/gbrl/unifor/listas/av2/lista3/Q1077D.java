package gbrl.unifor.listas.av2.lista3;

import gbrl.unifor.collections.pilhas.PilhaDinamica;

import java.util.Scanner;

public class Q1077D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String infix = sc.nextLine();
            String postfix = infixToPostfix(infix);
            System.out.println(postfix);
        }
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        PilhaDinamica<Character> pilha = new PilhaDinamica<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) postfix.append(c);
            else if (c == '(') pilha.push(c);
            else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') postfix.append(pilha.pop());
                pilha.pop();
            } else {
                while (!pilha.isEmpty() && precedente(c) <= precedente(pilha.peek())) postfix.append(pilha.pop());
                pilha.push(c);
            }
        }
        while (!pilha.isEmpty()) postfix.append(pilha.pop());
        return postfix.toString();
    }

    public static int precedente(char operador) {
        return switch (operador) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
