package br.com.getmoneyone;

public abstract class Conta {

    private final int numero;

    private final String cpf;

    private Double saldo;

    private Boolean status;

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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    abstract protected void debito();

    abstract public void credito ();

}
