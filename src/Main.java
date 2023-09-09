import entidade.Pessoa;
import pessoacrud.PessoaCrud;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        PessoaCrud pessoaCrud = new PessoaCrud();

        Scanner leia = new Scanner(System.in);

        // CRIANDO - metodo create
        //System.out.println("Digite seu nome: ");
        //String nome = leia.nextLine();
        //System.out.println("Digite sua idade: ");
        //int idade = Integer.parseInt(leia.nextLine());

        //pessoa.setNome(nome);
        //pessoa.setIdade(idade);

        //pessoaCrud.criarPessoa(pessoa);

        // MOSTRANDO OS USUARIOS (alt + enter = Iterate)
        for (Pessoa mostraPessoa : pessoaCrud.mostraPessoas()) {
            System.out.println("Id da pessoa: " + mostraPessoa.getId_pessoa());
            System.out.println("Nome: " + mostraPessoa.getNome());
            System.out.println("Idade: " + mostraPessoa.getIdade());
            System.out.println("-----------------------------------------------");
        }


        // ATUALIZANDO PESSOA
        /*
        System.out.println("Deseja atualizar qual pessoa? [ID]");
        pessoa.setId_pessoa(Integer.parseInt(leia.nextLine()));

        System.out.println("Novo nome: ");
        pessoa.setNome(leia.nextLine());
        System.out.println("Nova idade: ");
        pessoa.setIdade(Integer.parseInt(leia.nextLine()));

        pessoaCrud.atualizarPessoa(pessoa);
        */

        // APAGANDO PESSOA
        System.out.println("Deseja deletar qual pessoa? [ID]");
        int id = Integer.parseInt(leia.nextLine());

        pessoaCrud.deletePessoa(id);
    }
}