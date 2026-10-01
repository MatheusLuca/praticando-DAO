package br.com.fiap.dao;

import br.com.fiap.factory.ConectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PedidoDao {

    //Variavel que não pode ser reatribuida que vai armazenar uma conexao
    private final Connection conn;


    // Assim que instanciar o PedidoDao ele vai chamar o construtor que vai armazenaxr a conexao na variavel conn

    public PedidoDao(Connection conn) throws SQLException {
        this.conn = ConectionFactory.pegarConexao();
    }

    //Metodos para operar o banco de dados de Pedido


}
