package br.com.getmoneyone;

import java.util.Scanner;

public class ContaEspecial extends Conta {
	
	private double limite = 1000;

	protected ContaEspecial(int numero, String cpf) {
		super(numero, cpf);	
		setSaldo(0.0);
	}

	protected void debito(double saque) { 
		double saldo = getSaldo();
		if (saldo >= saque) {                          //Lógica para quando o saldo é maior do que o valor debitado.
			saldo -= saque;
			setSaldo(saldo);
			System.out.println("LIMITE " + limite);
			System.out.println("SALDO ATUAL " + saldo);
		} else {
			usarLimite(saque);
		}
	}

	public void credito(double deposito) {
		double saldo = getSaldo();
		saldo += deposito;
		setSaldo(saldo);
		System.out.println("LIMITE " + limite);
		System.out.println("SALDO ATUAL " + saldo);
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void usarLimite(double saque) {
		double saldo = getSaldo();
		double limiteUtilizado = saque - saldo;    //Lógica para quando o limite precisa ser utilizado.
		if (limiteUtilizado <= 1000 && limite >= limiteUtilizado) {
			limite -= limiteUtilizado;                     //Atualiza limite
			saldo -= saque;
			saldo += limiteUtilizado;                      //Adiciona o limite utilizado com saldo.
			setSaldo(saldo);
			System.out.println("Saldo insuficiente, foi utilizado R$ " + limiteUtilizado + " do seu limite, limite atual: " + limite);
		} else {
			System.out.println("Ultrapassa seu saldo, e não tem mais limite disponível!");
		}
		System.out.println("LIMITE " + limite);
		System.out.println("SALDO ATUAL " + saldo);
	}
	
	public void menu() {
		char tipoMovimentacao;
		char continuar;
		
		Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("LIMITE " + getLimite());
    	
    	for (int i = 0; i < 10; i++) {
    		System.out.println("SALDO ATUAL " + getSaldo());
    		System.out.println("MOVIMENTO [D]Débito ou [C]Crédito");
    		tipoMovimentacao = entrada.next().charAt(0);
    	
    		if (tipoMovimentacao == 'C') {
    		System.out.println("Valor do crédito: R$ ");
    		double valorDeposito = entrada.nextDouble();
    		credito(valorDeposito);
    		
    		} else if (tipoMovimentacao == 'D') {
    			System.out.println("Valor do débito: R$ ");
    			double valorSaque = entrada.nextDouble();
    			debito(valorSaque);
    			
    		} else {
    			System.out.println("Opcão inválida!");
    		}
    		
    		System.out.println("Continuar [S][N]: ");
    		continuar = entrada.next().charAt(0);
    		if (continuar == 'S' && i > 10) {
    			System.out.println("Você atingiu o número máximo de movimentações. Finalizando...");
    		} else if (continuar == 'N') {
    			System.out.println("Encerrando!");
    			break;
    		}
    		System.out.println("=======================================");
    	}
    	System.out.println("Saldo atual R$ " + getSaldo() + " Limite disponível R$ " + getLimite());	
	}
}