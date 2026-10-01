package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    // Classe de criação do metodo para abrir conexao com banco
    // Declaramos constantes com a url , usuario e senha do banco
    private static final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String user = "rm572228";
    private static final String password = "260497";

    //Chamamos um método estatico -> não precisamos instanciar um objeto para usarmos o metodo
    //Chamamos através do nome da classe.
    // Esse método retorna um objeto do tipo conncetion

    public static Connection pegarConexao() throws SQLException {

        // O driverManager devolve um objeto do tipo conection

        return DriverManager.getConnection(url, user, password);
    }


}
