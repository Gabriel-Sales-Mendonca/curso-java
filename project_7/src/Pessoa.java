public class Pessoa {
    private String nome;
    private int idade;
    private double altura;

    // inicio get e set
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    // fim get e set

    public Pessoa(String nome, int idade, double altura) {
        setNome(nome);
        setIdade(idade);
        setAltura(altura);
    }

    public static double calculaMedia(Pessoa[] listaDePessoas) {
        double soma = 0;
        for(Pessoa pessoa : listaDePessoas) {
            soma += pessoa.altura;
        }
        return soma / listaDePessoas.length;
    }
}
