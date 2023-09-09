package pessoacrud;

import conexao.Conexao;
import entidade.Pessoa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaCrud {
    // ESTRUTRA DAO (CRUD - JAVA)
    // CRUD - C -> CREATE / R -> READ / U -> UPDATE / D -> DELETE

    public void criarPessoa(Pessoa pessoa){
        // RECEITA DE BOLO

        // 1 - variavel comando sql (String)
        String sql = "INSERT INTO pessoa (nome, idade) VALUES (?,?)";

        // Chamar duas classes (Connection e PreparedStatement)
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,pessoa.getNome());
            preparedStatement.setInt(2, pessoa.getIdade());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
        }
    }

    public List<Pessoa> mostraPessoas(){
        String sql = "SELECT * FROM pessoa";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // armazena os dados do banco no array
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        // Mostra o resultado do array
        ResultSet resultSet = null;

        try{

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                // instanciar a classe pessoa
                Pessoa pessoa = new Pessoa();

                // passando como argumento o nome da tabela
                pessoa.setId_pessoa(resultSet.getInt("id_pessoa"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setIdade(resultSet.getInt("idade"));

                pessoas.add(pessoa);
            }

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
        }

        return pessoas;
    }

    public void atualizarPessoa(Pessoa pessoa){
        String sql = "UPDATE pessoa SET nome=?, idade=? WHERE id_pessoa=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setInt(2, pessoa.getIdade());
            preparedStatement.setInt(3, pessoa.getId_pessoa());

            // NUNCA SE ESQUEÇA DO .EXECUTE
            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Atualizado com suceso!");

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro: " + exception);
        }
    }

    public void deletePessoa(int id){
        String sql = "DELETE FROM pessoa WHERE id_pessoa=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro: " + exception);

        }
    }
}
