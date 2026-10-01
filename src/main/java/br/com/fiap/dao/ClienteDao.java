package br.com.fiap.dao;

import br.com.fiap.ClienteNaoEncontrado;
import br.com.fiap.factory.ConectionFactory;
import br.com.fiap.model.Cliente;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    // Os métodos para operar com o banco de dados será implementado abaixo

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

    //Metodo retorna lista de clientes
    public List buscarClientes() throws SQLException {
        String buscarClientes = """
                                SELECT * FROM TB_CLIENTE
                                """;
        PreparedStatement stmt = conn.prepareStatement(buscarClientes);
        ResultSet res = stmt.executeQuery();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        while(res.next()){
            int codigoColuna = res.getInt("cd_cliente");
            String nomeColuna = res.getString("nm_cliente");
            String emailColuna = res.getString("ds_email");
            String telefoneColuna = res.getString("nr_telefone");
            listaCliente.add(montarObjetoResultado(codigoColuna, nomeColuna, emailColuna, telefoneColuna));
        }

        return listaCliente;
    }

    //Metodo que montar um objeto Cliente de acordo com a quantidade de registro de clientes no BD
    private Cliente montarObjetoResultado(int codigo, String nome, String email, String telefone ){
        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        return cliente;
    }

    public Cliente buscarClientePorId( int id ) throws SQLException, ClienteNaoEncontrado {
        String buscarPorId = """
                            SELECT cd_cliente, nm_cliente, ds_email, nr_telefone
                            FROM TB_CLIENTE
                            WHERE cd_cliente = ?
                             """;

        PreparedStatement stmt = conn.prepareStatement(buscarPorId);
        stmt.setInt(1, id);

        ResultSet res = stmt.executeQuery();
        if(!res.next()){
            throw new ClienteNaoEncontrado("Cliente não localizado!");
        }else{
            int codigoColuna = res.getInt("cd_cliente");
            String nomeColuna = res.getString("nm_cliente");
            String emailColuna = res.getString("ds_email");
            String telefoneColuna = res.getString("nr_telefone");
            return montarObjetoResultado(codigoColuna, nomeColuna, emailColuna, telefoneColuna);
        }
    }


}
