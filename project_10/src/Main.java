import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        Instant dataBD;

        System.out.print("Digite a data (dd/MM/aaaa HH:mm): ");
        String dataUsuarioString = sc.nextLine();
        DateTimeFormatter dataUsuarioFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime dataUsuario = LocalDateTime.parse(dataUsuarioString, dataUsuarioFormatada);
        String zonaDoUsuario = ZoneId.systemDefault().toString();
        ZoneId localZoneId = ZoneId.of(zonaDoUsuario);

        System.out.println("Data informada: " + dataUsuario);

        System.out.println("Salvando data no banco de dados...");
        Thread.sleep(2000);

        String dataUsuarioConfigurada = dataUsuario + localZoneId.toString();
        dataBD = Instant.parse(dataUsuarioConfigurada);

        System.out.println("Data no banco de dados: " + dataBD);
    }
}