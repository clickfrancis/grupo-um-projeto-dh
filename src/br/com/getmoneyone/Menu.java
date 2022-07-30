package br.com.getmoneyone;

import java.util.Scanner;

public abstract class Menu {

    public static void nomeBanco(){
        System.out.println("  _______  _______ .____________..___  ___.  _______  .__   __.   _______ ____    ____   ______   .__   ___.  _______ ");
        System.out.println(" /  _____||   ____||            ||   \\/   | /   __   \\ |  \\ |  | |   ____|\\   \\  /   / /   __  \\  |  \\ |   | |   ____|");
        System.out.println("|  |  __  |  |__   `----|  |----`|  \\  /  | |  |  |  | |   \\|  | |  |__    \\   \\/   /  |  |  |  | |   \\|   | |  |__   ");
        System.out.println("|  | |_ | |   __|       |  |     |  |\\/|  | |  |  |  | |  . `  | |   __|    \\_    _/   |  |  |  | |  . `   | |   __|  ");
        System.out.println("|  |__| | |  |____      |  |     |  |  |  | |  `--'  | |  |\\   | |  |____     |  |     |  `--'  | |   |\\   | |  |____ ");
        System.out.println(" \\______| |_______|     |__|     |__|  |__|  \\______/  |__| \\__| |_______|    |__|      \\______/  |__ | \\__| |_______|");
    }
    public static void exibirMenu() {
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
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
        System.out.println("");


    }

    public static void menu() {

        boolean verificador = true;
        exibirMenu();

        int opcao = 0;
        boolean acesso = false;


        while(verificador){
            System.out.print("\nDIGITE O NÚMERO DA OPÇÃO DESEJADA: ");
            try{
                Scanner menu = new Scanner(System.in);
                opcao = menu.nextInt();
                verificador = false;
            }catch(Exception e){
                System.out.println("\nSó é permitido números.");
            }
        }

        if (opcao < 1 || opcao > 6){
            while (!acesso){
                System.out.print("\nInforme um número correspondente ao menu: ");
                try{
                    Scanner menu = new Scanner(System.in);
                    opcao = menu.nextInt();
                    if (opcao > 0 & opcao < 7) {
                        acesso = true;
                    } else {
                        System.out.print("\nOpção inválida. ");
                    }
                }catch(Exception e){
                    System.out.println("\nSó é permitido números.");
                }
            }
        }

        do {
            switch (opcao) {
                case 1:
                    System.out.println("\nBEM-VINDO A CONTA POUPANÇA");
                    contaPoupanca();
                    break;
                case 2:
                    System.out.println("CONTA CORRENTE");
                    break;
                case 3:
                    System.out.println("CONTA ESPECIAL");
                    contaEspecial();
                    break;
                case 4:
                    System.out.println("CONTA EMPRESA");
                    break;
                case 5:
                    System.out.println("CONTA ESTUDANTIL");
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

    private static void contaPoupanca(){
        ContaPoupanca contaPoupanca = new ContaPoupanca(99999, "255454");
        contaPoupanca.operacao();
    }

    private void contaEspecial() {
    	ContaEspecial especial = new ContaEspecial(8787, "8787");
    	especial.menu();
    }

    private static void exibirMenuNovamente() {

        int opcao = 0;
        boolean verificador= true;

        System.out.println("\nDIGITE O NÚMERO DA OPÇÃO DESEJADA:");
        System.out.println("\n6 - Voltar ao menu para escolher o tipo de conta.");
        System.out.println("7 - Sair da aplicação.");

        while(verificador){
            System.out.print("\nDigite a opção desejada: ");
            try{
                Scanner menu = new Scanner(System.in);
                opcao = menu.nextInt();
                verificador = false;
            }catch(Exception e){
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
