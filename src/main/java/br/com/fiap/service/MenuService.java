package br.com.fiap.service;

public class MenuService {

    public static String imprimirMenu(){
        return """
                  1. Cadastrar cliente \s
                  2. Listar clientes \s
                  3. Buscar cliente por id \s
                  4. Atualizar cliente \s
                  5. Remover cliente \s
                  6. Cadastrar pedido \s
                  7. Listar pedidos \s
                  8. Listar pedidos de um cliente \s
                  9. Sair \s
                """;
    }



}
