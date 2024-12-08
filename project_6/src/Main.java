import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros você vai digitar? ");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        for(int c = 0; c < numeros.length; c++) {
            System.out.print("Digite um número: ");
            numeros[c] = sc.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS:");
        for(int numero : numeros) {
            if(numero < 0) {
                System.out.println(numero);
            }
        }
    }
}