import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPrimos {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int escolha;

while (true) {
    System.out.println("Escolha uma opção:");
    System.out.println("1. Encontrar números primos de forma iterativa");
    System.out.println("2. Encontrar números primos de forma recursiva");
    System.out.println("3. Encontrar números primos de forma linear");
    System.out.println("4. Sair");
    System.out.print("Digite sua escolha: ");
    escolha = scanner.nextInt();

    if (escolha == 4) {
        break;
    }

    System.out.print("Digite um número maior que 1: ");
    int num = scanner.nextInt();

    while (num <= 1) {
        System.out.print("Número inválido. O número N precisa ser maior que 1: ");
        num = scanner.nextInt();
    }

    List<Integer> primos;

    switch (escolha) {
        case 1:
            primos = encontrarPrimosIterativamente(num);
            break;
        case 2:
            primos = encontrarPrimosRecursivamente(num, 2, new ArrayList<>());
            break;
        case 3:
            primos = encontrarPrimosLinearmente(num);
            break;
        default:
            System.out.println("Escolha inválida. Tente novamente.");
            continue;
    }

    System.out.println("Números primos até " + num + ": " + primos);
}

scanner.close();
}

public static List<Integer> encontrarPrimosIterativamente(int n) {
List<Integer> primos = new ArrayList<>();

for (int i = 2; i <= n; i++) {
    if (ehPrimo(i)) {
        primos.add(i);
    }
}

return primos;
}

public static List<Integer> encontrarPrimosRecursivamente(int n, int atual, List<Integer> primos) {
if (atual > n) {
    return primos;
}

if (ehPrimo(atual)) {
    primos.add(atual);
}

return encontrarPrimosRecursivamente(n, atual + 1, primos);
}

public static List<Integer> encontrarPrimosLinearmente(int n) {
List<Integer> primos = new ArrayList<>();
boolean[] crivo = new boolean[n + 1];

for (int i = 2; i <= n; i++) {
    if (!crivo[i]) {
        primos.add(i);
        for (int j = i * 2; j <= n; j += i) {
            crivo[j] = true;
        }
    }
}

return primos;
}

public static boolean ehPrimo(int num) {
if (num <= 1) {
    return false;
}

for (int i = 2; i * i <= num; i++) {
    if (num % i == 0) {
        return false;
    }
}

return true;
}
}