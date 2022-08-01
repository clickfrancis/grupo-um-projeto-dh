package br.com.getmoneyone.entities;

import br.com.getmoneyone.entities.Conta;

import java.util.Scanner;

public class ContaEmpresa extends Conta {

    private double emprestimoEmpresa = 10000;


    public ContaEmpresa(int numero, String cpf) {
        super(numero, cpf);
        setSaldo(0.0);
    }

    @Override
    protected void debito(double saque) {
        double saldo = getSaldo();
        if (saldo >= saque) {
            saldo = saldo - saque;
            setSaldo(saldo);
            System.out.println("\nSaque de: " + saque);
            System.out.println("\nSaque realizado com sucesso.");
            System.out.println("Seu novo saldo é: " + saldo);
        } else {
            System.out.println("\nSaque não realizado. O valor do saque é maior que o saldo na conta.");
            System.out.println("O saldo na sua conta é: " + getSaldo());
        }
    }

    @Override
    public void credito(double deposito) {
        double saldo = getSaldo();
        saldo = saldo + deposito;
        setSaldo(saldo);
        System.out.println("\nDepósito de: " + deposito);
        System.out.println("\nDepósito realizado com sucesso.");
        System.out.println("Seu novo saldo é: " + saldo);
    }

    public double getEmprestimoEmpresa() {
        return emprestimoEmpresa;
    }

    public void pedirEmprestimo(double saque) {
        double saldo = getSaldo();
        if (saque > emprestimoEmpresa) {
            System.out.println("O valor que você quer sacar é maior que o limite disponível");
        } else {
            emprestimoEmpresa = emprestimoEmpresa - saque;
            saldo = saldo + saque;
            setSaldo(saldo);
            System.out.println("SALDO + VALOR DE EMPRESTIMO SOLICITADO " + saldo);
        }
    }

    public void operacao() {
        char tipoMovimentaçao;
        char continuar;

        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Valor de emprestimo: " + emprestimoEmpresa);
            System.out.println("SALDO ATUAL " + getSaldo());
            System.out.println("MOVIMENTO D-Debito ou C-Credito ou E-Emprestimo");
            tipoMovimentaçao = entrada.next().charAt(0);

            if (tipoMovimentaçao == 'C') {
                System.out.println("Valor do credito: ");
                double valorDeposito = entrada.nextDouble();
                credito(valorDeposito);
            } else if (tipoMovimentaçao == 'D') {
                System.out.println("Valor debito: ");
                double valorSaque = entrada.nextDouble();
                debito(valorSaque);
            } else if (tipoMovimentaçao == 'E') {
                System.out.println("Qual valor de emprestimo deseja sacar:");
                double valorEmprestimo = entrada.nextDouble();
                pedirEmprestimo(valorEmprestimo);
            } else {
                System.out.println("Opçao invalida");
            }

            System.out.println("Continuar S-Sim ou N-Nao");
            continuar = entrada.next().charAt(0);
            if (continuar == 'S' && i > 10) {
                System.out.println("Voce chegou no fim da sua movimentaçao");
            } else if (continuar == 'N') {
                System.out.println("Fim da operaçao");
                break;
            }
        }
        System.out.println("Seu saldo atualizado seria " + getSaldo() + " Seu valor atual de emprestimo seria de " + emprestimoEmpresa);


    }
}

