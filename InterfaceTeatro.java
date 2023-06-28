/*Feito por Gabriel Buonamici Agnoletto(tia: 32368607) e João Vitor Newton Santos(tia: 32370377)
Por favor desconsiderar o envio anterior a este, como já tinha enviado antes, não consegui editar o envio, então o Gabriel mandou a versão atualizada no moodle dele */

import java.util.Scanner; 

public class InterfaceTeatro {
    private static Teatro teatro;
    private static Scanner scanner;

    public static void main(String[] args) {
        teatro = new Teatro();
        scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            apresentaMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarEspetaculo();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    compraEntradas();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    private static void apresentaMenu() {
        System.out.println("*** MACK THEATER ***");
        System.out.println("1) Cadastrar Espetáculo");
        System.out.println("2) Cadastrar Cliente");
        System.out.println("3) Compra de Entradas");
        System.out.println("4) Sair");
        System.out.println("Selecione uma opção:");
    }

    private static int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        return opcao;
    }

    private static void cadastrarEspetaculo() {
        System.out.println("*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        Espetaculo espetaculo = new Espetaculo(nome, data, hora, preco);
        teatro.cadastrarEspetaculo(espetaculo);

        System.out.println("\n>>> Retorna ao menu principal <<<\n");
    }

    private static void cadastrarCliente() {
        System.out.println("*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);
        teatro.cadastrarCliente(cliente);

        System.out.println("\n>>> Retorna ao menu principal <<<\n");
    }

    private static void compraEntradas() {
        System.out.println("*** VENDA DE ENTRADAS - ESPETÁCULOS ***");
        teatro.apresentaEspetaculos();

        System.out.print("Selecione um espetáculo: ");
        int numeroEspetaculo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        teatro.selecionaEspetaculo(numeroEspetaculo);

        System.out.println("||| Assentos Disponíveis |||");
        teatro.getEspetaculoSelecionado().apresentaAssentos();

        boolean comprarOutraEntrada = true;

        while (comprarOutraEntrada) {
            System.out.print("Selecione um assento: ");
            int assento = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            System.out.println("||| Tipos de Entrada |||");
            System.out.println("1) Inteira");
            System.out.println("2) Meia        50% do valor da entrada");
            System.out.println("3) Professor   40% do valor da entrada");
            System.out.print("Selecione um tipo de entrada: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            teatro.novaEntrada(tipo, assento);

            System.out.print("Deseja comprar uma outra entrada (S/N)? ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("N")) {
                comprarOutraEntrada = false;
            }
        }

        System.out.print("Informe o CPF do Cliente Cadastrado: ");
        String cpf = scanner.nextLine();

        double valorTotal = teatro.finalizaCompra(cpf);
        System.out.println("Valor Total: R$ " + valorTotal);

        System.out.println("\n>>> Retorna ao menu principal <<<\n");
    }
}