// Código de Lívia Barcellos Botelho

package br.com.getmoneyone;

import java.util.Scanner;

public class ContaEstudantil extends Conta {
    private double limiteEstudantil = 5000;

    protected ContaEstudantil(int numero, String cpf) {
        super(numero, cpf);
        setSaldo(0.0);
    }

    @Override
    protected void debito(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente, utilize seu limite estudantil");
        }
    }

    @Override
    public void credito(double valor) {
        setSaldo(getSaldo() + valor);
    }

    public void usarEstudantil(double valor, ContaEstudantil conta) {
        if (valor <= conta.limiteEstudantil) {
            conta.limiteEstudantil -= valor;
            credito(valor);
        } else {
            System.out.println("Limite estudantil insuficiente");
        }
    }

    public void movimentacao() {
        ContaEstudantil conta = new ContaEstudantil(13, "123456");
        String movimento;
        double valor;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Saldo Atual: " + conta.getSaldo());
            System.out.println("Limite estudantil disponível: " + conta.limiteEstudantil);
            System.out.println("Qual movimento deseja realizar?");
            System.out.println("D-Debito, C-Credito ou L-Utilizar Limite Estudantil");
            movimento = sc.nextLine();

            System.out.println("Qual o valor do movimento?");
            valor = sc.nextDouble();

            if (movimento.equals("C")) {
                conta.credito(valor);
            } else if (movimento.equals("D")) {
                conta.debito(valor);
            } else if (movimento.equals("L")) {
                conta.usarEstudantil(valor, conta);
            }
            sc.nextLine();

            System.out.println("Deseja continuar?");
            System.out.println("S / N");
            movimento = sc.nextLine();
            if (movimento.equals("N"))
                break;
        }
        if (conta.limiteEstudantil != 5000) {
            System.out.println("É necessário repor seu limite, deseja depositar?");
            System.out.println("S / N");
            movimento = sc.nextLine();

            if (movimento.equals("N")) {
                System.out.println("Você tem um mês para pagar o saldo devedor");
            } else {
                System.out.println("Qual o valor do movimento?");
                valor = sc.nextDouble();
                conta.limiteEstudantil += valor;
            }
        }
        sc.close();
    }
}