package br.com.getmoneyone;

public abstract class Conta {

    private final int numero;

    private final String cpf;

    private double saldo;

    private Boolean status;

    private int movimentacao;

    protected Conta(int numero, String cpf) {
        this.numero = numero;
        this.cpf = cpf;
    }


    public int getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    abstract protected void debito(double saque);

    abstract public void credito(double deposito);

    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }
}
