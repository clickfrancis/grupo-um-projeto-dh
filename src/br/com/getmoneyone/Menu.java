package br.com.getmoneyone;

import java.util.Scanner;

public class Menu {

    private void exibirMenu() {
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

        System.out.print("DIGITE O NÚMERO DA OPÇÂO DESEJADA: ");
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("   ____          _     __  __                                   ___                 ");
        System.out.println("  / ___|   ___  | |_  |  \\/  |   ___    _ __     ___   _   _   / _ \\   _ __     ___ ");
        System.out.println(" | |  _   / _ \\ | __| | |\\/| |  / _ \\  | '_ \\   / _ \\ | | | | | | | | | '_ \\   / _ \\");
        System.out.println(" | |_| | |  __/ | |_  | |  | | | (_) | | | | | |  __/ | |_| | | |_| | | | | | |  __/");
        System.out.println("  \\____|  \\___|  \\__| |_|  |_|  \\___/  |_| |_|  \\___|  \\__, |  \\___/  |_| |_|  \\___|");


        System.out.println("  _______  _______ .___________..___  ___.   ______   .__   __.  _______ ____    ____   ______   .__   __.  _______ ");
        System.out.println(" /  _____||   ____||           ||   \\/   |  /  __  \\  |  \\ |  | |   ____|\\   \\  /   /  /  __  \\  |  \\ |  | |   ____|");
        System.out.println("|  |  __  |  |__   `---|  |----`|  \\  /  | |  |  |  | |   \\|  | |  |__    \\   \\/   /  |  |  |  | |   \\|  | |  |__   ");
        System.out.println("|  | |_ | |   __|      |  |     |  |\\/|  | |  |  |  | |  . `  | |   __|    \\_    _/   |  |  |  | |  . `  | |   __|  ");
        System.out.println("|  |__| | |  |____     |  |     |  |  |  | |  `--'  | |  |\\   | |  |____     |  |     |  `--'  | |  |\\   | |  |____ ");
        System.out.println(" \\______| |_______|    |__|     |__|  |__|  \\______/  |__| \\__| |_______|    |__|      \\______/  |__| \\__| |_______|");

        System.out.println("   ______         __     __  ___                                 ____               ");
        System.out.println("  / ____/  ___   / /_   /  |/  /  ____    ____   ___    __  __  / __ \\   ____   ___ ");
        System.out.println(" / / __   / _ \\ / __/  / /|_/ /  / __ \\  / __ \\ / _ \\  / / / / / / / /  / __ \\ / _ \\");
        System.out.println("/ /_/ /  /  __// /_   / /  / /  / /_/ / / / / //  __/ / /_/ / / /_/ /  / / / //  __/");
        System.out.println("\\____/   \\___/ \\__/  /_/  /_/   \\____/ /_/ /_/ \\___/  \\__, /  \\____/  /_/ /_/ \\___/ ");
        System.out.println("                                                     /____/                         ");


        int opcao;
        this.exibirMenu();

        do {
            Scanner ler = new Scanner(System.in);
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("CONTA POUPANÇA");
                    break;
                case 2:
                    System.out.println("CONTA CORRENTE");
                    break;
                case 3:
                    System.out.println("CONTA ESPECIAL");
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
            this.exibirMenuNovamente();
        } while (opcao != 6);
    }

    private void exibirMenuNovamente() {
        Scanner scan = new Scanner(System.in);

        System.out.println("6 - SAIR");
        System.out.println("7 - Para exibir o menu novamente");
        System.out.print("Digite a opção desejada: ");

        int opcao = scan.nextInt();
        if (opcao == 7) {
            this.exibirMenu();
        } else if (opcao == 6) {
            System.out.println("Saindo...");
            System.out.println("\n\nVolte logo!");
            System.exit(0);
        } else {
            this.exibirMenuNovamente();
        }
    }

}
