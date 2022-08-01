package br.com.getmoneyone.entities;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String cpf) {
        super(numero, cpf);
        this.diaAniversarioPoupanca = diaAniversarioPoupanca;
        setMovimentacao(0);
        setSaldo(0.0);

    }

    private int diaAniversarioPoupanca = 20;

    public int getDiaAniversarioPoupanca() {
        return diaAniversarioPoupanca;
    }

    @Override
    protected void debito(double saque) {
        if (saque > getSaldo()) {
            System.out.println("\nSaque não realizado. O valor do saque é maior que o saldo na conta.");
            System.out.println("O saldo na sua conta é: " + getSaldo());
        } else {
            double novoSaldo = getSaldo() - saque;
            setSaldo(novoSaldo);
            setMovimentacao(getMovimentacao() + 1);
            System.out.println("\nSaque de: " + saque);
            System.out.println("\nSaque realizado com sucesso.");
            System.out.println("Seu novo saldo é: " + getSaldo());
        }
    }

    @Override
    public void credito(double deposito) {
        double novoSaldo = getSaldo() + deposito;
        setSaldo(novoSaldo);
        setMovimentacao(getMovimentacao() + 1);
        System.out.println("\nDepósito de: " + deposito);
        System.out.println("\nDepósito realizado com sucesso.");
        System.out.println("Seu novo saldo é: " + getSaldo());
    }

    public void correcao(int diaInfoCliente) {

        if (getSaldo() > 0.0) {
            if (diaInfoCliente == diaAniversarioPoupanca) {
                double saldo = (getSaldo() * 0.05) + getSaldo();
                setSaldo(saldo);
                System.out.println("\nSeu saldo foi ajustado para : " + saldo);
            } else {
                System.out.println("\nAjuste do saldo não realizado.");
                System.out.println("O dia informado não é o mesmo dia do aniversário da poupança.");
            }
        } else {
            System.out.println("\nSaldo insuficiente para gerar rendimento.");
        }
    }

    public void operacao() {
        int opcao = 0;
        boolean verificador;

        while (getMovimentacao() < 11) {
            verificador = true;
            System.out.println("\nSALDO ATUAL " + getSaldo());
            System.out.println("\n1 - SAQUE");
            System.out.println("2 - DEPÓSITO");
            System.out.println("3 - CORREÇÃO");
            System.out.println("4 - Sair");

            while (verificador) {
                System.out.print("\nInforme um número correspondente ao menu: ");
                try {
                    Scanner menu = new Scanner(System.in);
                    opcao = menu.nextInt();
                    verificador = false;
                } catch (Exception e) {
                    System.out.println("\nSó é permitido números.");
                }
            }
            verificador = true;

            if (opcao > 0 & opcao < 5) {
                switch (opcao) {
                    case 1:
                        while (verificador) {
                            System.out.print("\nInfome o valor que deseja sacar: ");
                            try {
                                Scanner valorSaque = new Scanner(System.in);
                                double valorS = valorSaque.nextDouble();
                                debito(valorS);
                                verificador = false;
                            } catch (Exception e) {
                                System.out.println("\nVocê não digitou o valor corretamente.");
                            }
                        }
                        break;
                    case 2:
                        while (verificador) {
                            System.out.print("\nInfome o valor que deseja depositar: ");
                            try {
                                Scanner valorDeposito = new Scanner(System.in);
                                double valorD = valorDeposito.nextDouble();
                                credito(valorD);
                                verificador = false;
                            } catch (Exception e) {
                                System.out.println("\nVocê não digitou o valor corretamente.");
                            }
                        }
                        break;
                    case 3:
                        while (verificador) {
                            System.out.print("\nInfome a data de aniversário: ");
                            try {
                                Scanner ajuste = new Scanner(System.in);
                                int correcao = ajuste.nextInt();
                                correcao(correcao);
                                verificador = false;
                            } catch (Exception e) {
                                System.out.println("\nVocê não digitou o valor corretamente.");
                            }
                        }
                        break;
                    default:
                        setMovimentacao(11);
                        System.out.println("\nSaindo da conta poupança...");
                        break;
                }
            } else {
                System.out.println("\nOpção inválida!");
            }
        }
    }
}

