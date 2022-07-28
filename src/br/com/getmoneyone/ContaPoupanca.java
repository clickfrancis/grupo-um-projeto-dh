package br.com.getmoneyone;

public class ContaPoupanca extends Conta {

    protected ContaPoupanca(int numero, String cpf, int diaAniversarioPoupanca) {
        super(numero, cpf);
        this.diaAniversarioPoupanca = diaAniversarioPoupanca;
    }

    private final int diaAniversarioPoupanca;

    @Override
    protected void debito(double saque) {
    }

    @Override
    public void credito(double deposito) {
    }

    public int getDiaAniversarioPoupanca() {
        return diaAniversarioPoupanca;
    }

    public void correcao(int diaInfoCliente) {

        if (getSaldo() > 0.0){
            if(diaInfoCliente == diaAniversarioPoupanca) {
                double saldo = (getSaldo()*0.05)+getSaldo();
                setSaldo(saldo);
                System.out.println("Seu saldo foi ajustado para : "+saldo);
            }
            else {
                System.out.println("Ajuste no saldo não realizado.");
                System.out.println("O dia informado não é o mesmo dia do aniversário da poupança.");
            }
        } else {
            System.out.println("Saldo insuficiente para gerar rendimento.");
        }
    }
}
