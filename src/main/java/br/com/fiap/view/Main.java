package br.com.fiap.view;

import br.com.fiap.ClienteNaoEncontrado;
import br.com.fiap.dao.ClienteDao;
import br.com.fiap.model.Cliente;
import br.com.fiap.service.ClienteService;
import br.com.fiap.service.MenuService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pararProgama = -1;

        while(pararProgama != 0){

            System.out.println(MenuService.imprimirMenu());
            System.out.println("Digite uma opção: ");
            int opcaoMenu = sc.nextInt();
            sc.nextLine();
                switch (opcaoMenu){
                    case 1:
                        try{
                            System.out.println("Insira o nome: ");
                            String nomeInput = sc.nextLine();
                            System.out.println("Insira o email: ");
                            String emailInput = sc.nextLine();
                            System.out.println("Insira o telefone: ");
                            String telefoneInput = sc.nextLine();

                            Cliente cliente = new Cliente( nomeInput, emailInput, telefoneInput);
                            ClienteDao dao = new ClienteDao();
                            cliente = dao.cadastrarCliente(cliente);

                            System.out.println("O cliente foi cadastrado -> " + cliente.toString());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            System.out.println("Listar Clientes!");
                            ClienteDao dao = new ClienteDao();
                            System.out.println(ClienteService.imprimirListaCliente(dao.buscarClientes()));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        try{
                            System.out.println("Buscar cliente por ID ");
                            System.out.println("Digite um id ");
                            int codigoDigitado = sc.nextInt();
                            ClienteDao dao = new ClienteDao();
                            System.out.println(ClienteService.imprimirClientePorId(dao.buscarClientePorId(codigoDigitado)));
                        }catch (ClienteNaoEncontrado e){
                            System.out.println(e.getMessage());
                            break;
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 9:
                        pararProgama = 0;
                        break;
                }





        }



    }
}
