package br.com.fiap.view;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.model.Cliente;
import br.com.fiap.service.MenuService;

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
                        System.out.println("Entrei no case 2");
                        break;
                    case 9:
                        pararProgama = 0;
                        break;
                }





        }



    }
}
