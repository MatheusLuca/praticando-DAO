package br.com.fiap.service;

import br.com.fiap.model.Cliente;

import java.util.List;

public class ClienteService {

    public static String imprimirListaCliente(List<Cliente> listaClientes){

        String resultado = "";

        for(Cliente cliente : listaClientes){
            resultado+= """
                    *************
                    Código: %d
                    Nome: %s
                    Email: %s
                    Telefone: %s
                    *************
                    """.formatted(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
        }

        return resultado;
    }

    public static String imprimirClientePorId(Cliente cliente){
        return """
                Codigo: %d
                Nome: %s
                Email: %s
                Telefone: %s
                """.formatted(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }



}
