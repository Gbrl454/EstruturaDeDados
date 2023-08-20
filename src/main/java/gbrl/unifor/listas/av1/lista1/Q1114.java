package gbrl.unifor.listas.av1.lista1;

import java.util.Scanner;

public class Q1114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        senha(sc);
    }

    private static void senha(Scanner sc) {
        int senha = sc.nextInt();
        if (senha == 2002) {
            System.out.println("Acesso Permitido");
        } else {
            System.out.println("Senha Invalida");
            senha(sc);
        }
    }
}
