package br.com.getmoneyone.app;

import br.com.getmoneyone.entities.*;

import java.util.Scanner;

public abstract class Menu {

    static ContaCorrente contaCorrente = new ContaCorrente(94199, "78454");

    private static void contaPoupanca() {
        ContaPoupanca contaPoupanca = new ContaPoupanca(99999, "255454");
        contaPoupanca.operacao();
    }

    private static void contaEspecial() {
        ContaEspecial especial = new ContaEspecial(8787, "8787");
        especial.menu();
    }

    private static void contaEmpresa() {
        ContaEmpresa empresa = new ContaEmpresa(1212, "1212");
        empresa.operacao();
    }

    private static void contaEstudantil() {
        ContaEstudantil contaEstudantil = new ContaEstudantil(4523, "1845937");
        contaEstudantil.operacao();
    }


    private static void nomeBanco() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                  _______  _______ .____________..___  ___.  _______  .__   __.   _______ ____    ____   ______   .__   ___.  _______ ");
        System.out.println("                 /  _____||   ____||            ||   \\/   | /   __   \\ |  \\ |  | |   ____|\\   \\  /   / /   __  \\  |  \\ |   | |   ____|");
        System.out.println("                |  |  __  |  |__   `----|  |----`|  \\  /  | |  |  |  | |   \\|  | |  |__    \\   \\/   /  |  |  |  | |   \\|   | |  |__   ");
        System.out.println("                |  | |_ | |   __|       |  |     |  |\\/|  | |  |  |  | |  . `  | |   __|    \\_    _/   |  |  |  | |  . `   | |   __|  ");
        System.out.println("                |  |__| | |  |____      |  |     |  |  |  | |  `--'  | |  |\\   | |  |____     |  |     |  `--'  | |   |\\   | |  |____ ");
        System.out.println("                 \\______| |_______|     |__|     |__|  |__|  \\______/  |__| \\__| |_______|    |__|      \\______/  |__ | \\__| |_______|");
        System.out.println("                                                                  AQUI SEU DINHEIRO VALE MAIS!");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void exibirMenu() {
        nomeBanco();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(" __  __   ___   _  _   _   _ ");
        System.out.println("|  \\/  | | __| | \\| | | | | |");
        System.out.println("| |\\/| | | _|  | .` | | |_| |");
        System.out.println("|_|  |_| |___| |_|\\_|  \\___/ \n");

        System.out.println("1 - CONTA POUPANÇA");
        System.out.println("2 - CONTA CORRENTE");
        System.out.println("3 - CONTA ESPECIAL");
        System.out.println("4 - CONTA EMPRESA");
        System.out.println("5 - CONTA ESTUDANTIL");
        System.out.println("6 - SAIR");
        System.out.print("\nDIGITE O NÚMERO DA OPÇÂO DESEJADA: ");
    }

    public static void menu() {

        boolean verificador = true;
        exibirMenu();

        int opcao = 0;
        boolean acesso = false;


        while (verificador) {
            try {
                Scanner menu = new Scanner(System.in);
                opcao = menu.nextInt();
                verificador = false;
            } catch (Exception e) {
                System.out.println("\nSó é permitido números.");
            }
        }

        if (opcao < 1 || opcao > 6) {
            while (!acesso) {
                System.out.print("\nInforme um número correspondente ao menu: ");
                try {
                    Scanner menu = new Scanner(System.in);
                    opcao = menu.nextInt();
                    if (opcao > 0 & opcao < 7) {
                        acesso = true;
                    } else {
                        System.out.print("\nOpção inválida. ");
                    }
                } catch (Exception e) {
                    System.out.println("\nSó é permitido números.");
                }
            }
        }

        do {
            switch (opcao) {
                case 1:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
                    nomeBanco();
                    System.out.println("\n\n\n");
                    System.out.println("\nBEM-VINDO A CONTA POUPANÇA");
                    contaPoupanca();
                    break;
                case 2:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    nomeBanco();
                    System.out.println("\n\n\n\n\n\n\n\n");
                    System.out.println("\nBEM-VINDO A CONTA CORRENTE");
                    contaCorrente.movimentarConta();
                    break;
                case 3:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    nomeBanco();
                    System.out.println("\n\n\n\n\n\n\n\n");
                    System.out.println("\nBEM-VINDO A CONTA ESPECIAL");
                    contaEspecial();
                    break;
                case 4:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    nomeBanco();
                    System.out.println("\n\n\n\n\n\n\n\n");
                    System.out.println("\nBEM-VINDO A CONTA EMPRESA");
                    contaEmpresa();
                    break;
                case 5:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    nomeBanco();
                    System.out.println("\n\n\n\n\n");
                    System.out.println("\nBEM-VINDO A CONTA ESTUDANTIL");
                    contaEstudantil();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.out.println("\n\nVolte logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
            exibirMenuNovamente();
        } while (opcao != 6);
    }

    private static void exibirMenuNovamente() {

        int opcao = 0;
        boolean verificador = true;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("O que deseja fazer agora?\n");
        System.out.println("6 - Voltar ao menu.");
        System.out.println("7 - Sair da aplicação.");
        System.out.print("\nDIGITE O NÚMERO DA OPÇÃO DESEJADA: ");

        while (verificador) {
            try {
                Scanner menu = new Scanner(System.in);
                opcao = menu.nextInt();
                verificador = false;
            } catch (Exception e) {
                System.out.println("\nSó é permitido números.");
            }
        }

        if (opcao == 6) {
            menu();
        } else if (opcao == 7) {
            System.out.println("\nEncerrando aplicação...");
            System.out.println("\n\nVolte logo!");
            System.exit(0);
        } else {
            exibirMenuNovamente();
        }
    }
}
