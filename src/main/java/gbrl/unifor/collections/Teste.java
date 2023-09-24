package gbrl.unifor.collections;

import java.util.Stack;

public class Teste {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha();
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        System.out.println(pilha);
        pilha.pop();
        System.out.println(pilha);
        System.out.println(pilha.isEmpty());
        System.out.println(pilha.size());
        pilha.push("D");System.out.println(pilha);
        System.out.println(pilha.peek());
        pilha.clear();
        System.out.println(pilha);

        System.out.println("-----------------------------------------------------------------------------------------");

        PilhaDinamica<String> pilhaD = new PilhaDinamica();
        pilhaD.push("A");
        pilhaD.push("B");
        pilhaD.push("C");
        System.out.println(pilhaD);
        pilhaD.pop();
        System.out.println(pilhaD);
        System.out.println(pilhaD.isEmpty());
        System.out.println(pilhaD.size());
        pilhaD.push("D");System.out.println(pilhaD);
        System.out.println(pilhaD.peek());
        pilhaD.clear();
        System.out.println(pilhaD);

        System.out.println("-----------------------------------------------------------------------------------------");

        Stack<String> stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.push("D");System.out.println(stack);
        System.out.println(stack.peek());
        stack.clear();
        System.out.println(stack);


    }
}
