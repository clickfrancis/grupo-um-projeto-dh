package br.com.getmoneyone;

import java.util.Scanner;

/**
 * @author Gabriel Marcolino Rodrigues
 */

public class ContaCorrente extends Conta {

    private int contadorTalao;
    private boolean talaoSolicitado;

    public ContaCorrente(int numero, String cpf) {
        super(numero, cpf);
    }

    public boolean isTalaoSolicitado() {
        return talaoSolicitado;
    }

    public void setTalaoSolicitado(boolean talaoSolicitado) {
        this.talaoSolicitado = talaoSolicitado;
    }

    @Override
    protected void debito(double saque) {
        if (saque > super.getSaldo()) {
            System.out.println("Saldo insuficiente. Saldo atual: " + super.getSaldo() + " valor: " + saque);
        }
        super.setSaldo(super.getSaldo() - saque);
    }

    @Override
    public void credito(double deposito) {
        if (deposito < 0) {
            System.out.println("Não é possível depositar um valor negativo");
        }
        super.setSaldo(super.getSaldo() + deposito);
    }

    public void pedirTalao() {
        if (this.contadorTalao >= 3) {
            this.talaoSolicitado = true;
            System.out.println("Limite de solicitação de cheque atingido");
        } else {
            this.contadorTalao++;
            this.talaoSolicitado = true;
            this.debito(30.0);
            System.out.println("Saldo atual: " + super.getSaldo());
        }
    }

    public void movimentacoes() {
        ContaCorrente cc = new ContaCorrente(123, "123");
        Scanner scan = new Scanner(System.in);
        System.out.println("CONTA CORRENTE\n");
        System.out.printf("Saldo atual: R$ %.1f", cc.getSaldo());

        char solicitacao;
        char opcao;
        cc.setTalaoSolicitado(false);
        for (int i = 0; i < 3; i++) { // movimentações: até 10
            System.out.println(i);
            System.out.print("Movimento [D]ébito ou [C]redito? ");
            opcao = scan.next().charAt(0);

            if (opcao == 'D') {
                System.out.print("Valor do movimento: R$ ");
                cc.debito(scan.nextDouble());

                System.out.println("Continuar S/N: ");
                opcao = scan.next().charAt(0);

                if (opcao == 'S') {
                    continue;
                } else if (opcao == 'N') {
                    System.out.print("Deseja solicitar cheque? S/N");
                    solicitacao = scan.next().charAt(0);

                    if (solicitacao == 'S') {
                        cc.pedirTalao();
                        break;
                    }
                    break;
                }
            } else if (opcao == 'C') {
                System.out.print("Valor do movimento: R$ ");
                cc.credito(scan.nextDouble());

                System.out.println("Continuar S/N: ");
                opcao = scan.next().charAt(0);

                if (opcao == 'S') {
                    continue;
                } else if (opcao == 'N') {
                    System.out.print("Deseja solicitar cheque? S/N");
                    solicitacao = scan.next().charAt(0);

                    if (solicitacao == 'S') {
                        cc.pedirTalao();
                        break;
                    }
                    break;
                }
            }
        }

        if (!cc.isTalaoSolicitado()) {
            System.out.print("Deseja solicitar cheque? S/N: ");
            solicitacao = scan.next().charAt(0);

            if (solicitacao == 'S')
                cc.pedirTalao();
        }
//        System.out.printf("Saldo atual: R$ %.1f\n", cc.getSaldo());
    }

}