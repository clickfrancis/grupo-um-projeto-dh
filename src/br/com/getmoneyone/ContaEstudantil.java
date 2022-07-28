package br.com.getmoneyone;

public class ContaEstudantil extends Conta{
    private double limiteEstudantil = 5000;

    public double getLimiteEstudantil() {
        return limiteEstudantil;
    }

    protected ContaEstudantil(int numero, String cpf) {

        super(numero, cpf);
        setSaldo(0.0);
    }

    @Override
    protected void debito(double valor) {
        if(valor <= getSaldo()){
            setSaldo(getSaldo()-valor);
        }
        else{
            System.out.println("Saldo insuficiente, utilize seu limite estudantil");
        }
    }

    @Override
    public void credito(double valor) {
        setSaldo(getSaldo()+valor);
    }

    public void usarEstudantil(double valor){
        if(valor <= limiteEstudantil) {
            credito(valor);
            limiteEstudantil -= valor;
        }
        else {
            System.out.println("Limite estudantil insuficiente");
        }
    }
}
