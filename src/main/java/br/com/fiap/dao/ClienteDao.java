package br.com.fiap.dao;

import br.com.fiap.factory.ConectionFactory;
import br.com.fiap.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    // variavel final -> impede que esse valor seja reatribuido;
    private final Connection conn;

    // Construtor do ClienteDao.
    // Ao instanciar um ClienteDao, o construtor será executado.
    // O método pegarConexao() é chamado e retorna um objeto Connection
    // representando uma conexão com o banco de dados.
    // Essa conexão é armazenada na variável de classe "conn".

    public ClienteDao() throws SQLException {
        this.conn = ConectionFactory.pegarConexao();
    }

    public Cliente cadastrarCliente(Cliente cliente) throws SQLException{
        String cadastrarSQL = """
                INSERT INTO tb_cliente (cd_cliente, nm_cliente, ds_email, nr_telefone)
                VALUES(sq_cliente.NEXTVAL, ?, ?, ?)
                """;
        PreparedStatement stmt = conn.prepareStatement(cadastrarSQL);

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getTelefone());

        // Retornou um int com o numero de linhas afetadas
        stmt.executeUpdate();

        // Pega o valor gerado automaticamente pelo banco depois de um INSERT
        ResultSet rs = stmt.getGeneratedKeys();

        //Existe uma linha nesse resultset?
        if(rs.next()){
            //Pega o valor da primeira coluna e seta como código do cliente daquela linha
            cliente.setCodigo(rs.getInt(1));
        }

        return cliente;
    }


    // Os métodos para operar com o banco de dados será implementado abaixo






}
