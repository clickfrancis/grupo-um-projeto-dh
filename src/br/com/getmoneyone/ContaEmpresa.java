package br.com.getmoneyone;

public class ContaEmpresa extends Conta {
	
	private double emprestimoEmpresa;
	

	protected ContaEmpresa(int numero, String cpf) {
		super(numero, cpf);
	    setSaldo(0.0);
	}

	@Override
	protected void debito(double saque) {
		double saldo = getSaldo();
		if(saldo >= saque) {
			saldo = saldo - saque;
			setSaldo(saldo);
			System.out.println("DEBITO " + saque);
		}else{
		}
	System.out.println("SALDO " + saldo);
		
	}

	@Override
	public void credito(double deposito) {
		double saldo = getSaldo();
		saldo = saldo + deposito;
		setSaldo(saldo);
		System.out.println("CREDITO " + deposito);
		System.out.println("SALDO " + saldo);
	}
	
	public void pedirEmprestimo() {
		
		
	}
	
	
}

