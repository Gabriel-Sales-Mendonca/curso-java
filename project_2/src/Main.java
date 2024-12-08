import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cod = sc.nextInt();
        int qtd = sc.nextInt();

        double total;
        if(cod == 1) {
            total = qtd * 4;
        } else if(cod == 2){
            total = qtd * 4.5;
        } else if(cod == 3) {
            total = qtd * 5;
        } else if(cod == 4) {
            total = qtd * 2.0;
        } else {
            total = qtd * 1.5;
        }

        Locale.setDefault(Locale.US);
        System.out.printf("Total: R$ %.2f%n", total);

        sc.close();
    }
}