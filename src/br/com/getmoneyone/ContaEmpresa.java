package br.com.getmoneyone;

import java.util.Scanner;

public class ContaEmpresa extends Conta {
	
	private double emprestimoEmpresa = 10000;
	

	protected ContaEmpresa(int numero, String cpf) {
		super(numero, cpf);
	    setSaldo(0.0);
	}

	@Override
	protected void debito(double saque) {
		double saldo = getSaldo();
			saldo = saldo - saque;
			setSaldo(saldo);
			System.out.println("DEBITO " + saque);
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
	
	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}
	
	public void pedirEmprestimo(double saque) {
		double saldo = getSaldo();
		emprestimoEmpresa = emprestimoEmpresa - saque;
	    saldo = saldo + saque;
		setSaldo(saldo);
		System.out.println("SALDO + VALOR DE EMPRESTIMO SOLICITADO" + saldo); 
		System.out.println("");
	}
	
	public void menu() {
		char tipoMovimentaçao;
		char continuar;
		
		Scanner entrada = new Scanner (System.in);
		
		for (int i = 0; i < 10; i ++) {
			System.out.println("Valor de emprestimo: " + emprestimoEmpresa);
			System.out.println("SALDO ATUAL " + getSaldo()); 
			System.out.println("MOVIMENTO D-Debito ou C-Credito ou E-Emprestimo");
			tipoMovimentaçao = entrada.next().charAt(0);
			
			if(tipoMovimentaçao == 'C') {
				System.out.println("Valor do credito: "); 
				double valorDeposito = entrada.nextDouble();
				credito(valorDeposito);	
			}else if(tipoMovimentaçao == 'D') {
				System.out.println("Valor debito: ");
				double valorSaque = entrada.nextDouble();
				debito(valorSaque);
			}else if(tipoMovimentaçao == 'E'){
				double valorEmprestimo = entrada.nextDouble();
				pedirEmprestimo(valorEmprestimo);
			System.out.println("Opçao invalida");
			}
			
			System.out.println("Continuar S-Sim ou N-Nao");
			continuar = entrada.next().charAt(0);
			if(continuar == 'S' && i >10) {
				System.out.println("Voce chegou no fim da sua movimentaçao");
			}else if (continuar == 'N') {
				System.out.println("Fim da operaçao");
				break;
			}
		}
		System.out.println("Seu saldo atualizado seria " + getSaldo() + "Seu valor atual de emprestimo seria de  " + emprestimoEmpresa);
			
		
	}
}

