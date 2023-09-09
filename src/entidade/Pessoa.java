package entidade;

public class Pessoa {
    private int id_pessoa;
    private String nome;
    private int idade;

    public Pessoa(){}

    // alt + insert - mostra opções como criar constructor / getter e setter
    public Pessoa(int id_pessoa, String nome, int idade) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
