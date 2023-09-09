package conexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    // criar 3 constantes - URL DO BANCO / USER / SENHA
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/teste";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";


    public static Connection createConnectionMySQL() throws Exception{
        Connection connection = DriverManager.getConnection(DATABASEURL, USER, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = createConnectionMySQL();

        if(connection != null){
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            connection.close();
        }
    }
}
