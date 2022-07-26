package br.com.getmoneyone;

public class ContaPoupanca extends Conta {

    protected ContaPoupanca(int numero, String cpf) {
        super(numero, cpf);
    }

    @Override
    protected void debito() {

    }

    @Override
    public void credito() {

    }

}
