import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linhas = sc.nextInt();
        int colunas = sc.nextInt();

        int[][] mat = new int[linhas][colunas];

        for(int linha = 0; linha < linhas; linha++) {
            for(int coluna = 0; coluna < colunas; coluna++) {
                mat[linha][coluna] = sc.nextInt();
            }
        }

        int numero = sc.nextInt();

        for(int linha = 0; linha < linhas; linha++) {
            for(int coluna = 0; coluna < colunas; coluna++) {
                if(mat[linha][coluna] == numero) {
                    System.out.printf("Position %d, %d:%n", linha, coluna);
                    if(coluna > 0) {
                        System.out.println("Left: " + mat[linha][coluna - 1]);
                    }
                    if(coluna < colunas - 1) {
                        System.out.println("Right: " + mat[linha][coluna + 1]);
                    }
                    if(linha > 0) {
                        System.out.println("Up: " + mat[linha - 1][coluna]);
                    }
                    if(linha < linhas - 1) {
                        System.out.println("Down: " + mat[linha + 1][coluna]);
                    }
                }
            }
        }

        sc.close();
    }
}