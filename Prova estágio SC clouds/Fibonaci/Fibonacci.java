import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 1, n;

        while (opcao != 0) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1 - Fibonacci (recursivo)");
            System.out.println("2 - Fibonacci (linear)");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    System.out.print("Insira o numero desejado: ");
                    n = validarInput(sc);
                    int fib1 = fibonacci(n);
                    System.out.println("O " + n + "°  numero da sequencia de Fibonacci e " + fib1);
                    break;

                case 2:
                    System.out.print("Insira o numero desejado: ");
                    n = validarInput(sc);
                    int fib2 = fibonacciLinear(n);
                    System.out.println("O " + n + "°  numero da sequencia de Fibonacci e " + fib2);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }

        sc.close();
    }

    public static int validarInput(Scanner sc) {
        int n = -1;
        while (n < 0) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                System.out.println("Entrada invalida, por favor insira um numero inteiro nao negativo:");
                sc.next();
            }
            if (n < 0) {
                System.out.println("Entrada invalida, por favor insira um numero inteiro nao negativo:");
            }
        }
        return n;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int fibonacciLinear(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}
