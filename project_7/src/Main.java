import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Quantas pessoas serão digitadas? ");
        int numeroDePessoas = sc.nextInt();
        sc.nextLine();

        Pessoa[] listaDePessoas = new Pessoa[numeroDePessoas];

        for(int c = 0; c < listaDePessoas.length; c++) {
            System.out.printf("Dados da %da pessoa:%n", c + 1);
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            sc.nextLine();

            listaDePessoas[c] = new Pessoa(nome, idade, altura);
        }

        double mediaDaAltura = Pessoa.calculaMedia(listaDePessoas);

        System.out.println("Altura média: " + String.format("%.2f", mediaDaAltura));

        sc.close();
    }
}