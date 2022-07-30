package br.com.getmoneyone;

import java.util.Scanner;

public class ContaEspecial extends Conta {
	
	private double limite = 1000;
	char tipoMovimentacao;
	char continuar;
	double movimentacoes;

	protected ContaEspecial(int numero, String cpf) {
		super(numero, cpf);	
		setSaldo(0.0);
	}

	protected void debito(double saque) { 
		double saldo = getSaldo();
		if (saldo >= saque) {                          //Lógica para quando o saldo é maior do que o valor debitado.
			saldo -= saque;
			setSaldo(saldo);
			System.out.println("DEBITO " + saque);
				
		} else {
			usarLimite(saque);
		}
		System.out.println("SALDO " + saldo);
	}

	public void credito(double deposito) {
		double saldo = getSaldo();
		saldo += deposito;
		setSaldo(saldo);
		System.out.println("CREDITO " + deposito);
		System.out.println("SALDO " + saldo);
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
			System.out.println("Saldo insuficiente, foi utilizado R$" + limiteUtilizado + " do seu limite, Limite ATUAL: " + limite);
			System.out.println("DEBITO " + saque);
		} else {
			System.out.println("Ultrapassa seu saldo, e não tem mais limite disponível!");
		}
	}
	
	public void menu() {
		Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("LIMITE " + getLimite());
    	
    	while (movimentacoes < 10) {
    		System.out.println("Saldo atual: R$ " + getSaldo());
    		System.out.println("MOVIMENTO [D]Débito ou [C]Crédito");
    		tipoMovimentacao = entrada.next().charAt(0);
    	
    		if (tipoMovimentacao == 'C') {
    		System.out.println("Valor do crédito: R$ ");
    		double valorDeposito = entrada.nextDouble();
    		credito(valorDeposito);
    		movimentacoes++;
    		} else if (tipoMovimentacao == 'D') {
    			System.out.println("Valor do débito: R$ ");
    			double valorSaque = entrada.nextDouble();
    			debito(valorSaque);
    			movimentacoes++;
    		} else {
    			System.out.println("Opcão inválida!");
    		}
    		
    		System.out.println("Continuar [S][N]: ");
    		continuar = entrada.next().charAt(0);
    		if (continuar == 'N') {
    			break;
    		} else if (continuar == 'S' && movimentacoes >= 10) {
    			System.out.println("Você atingiu o número máximo de movimentações. Finalizando...");
    			break;
    		}
    		System.out.println("=======================================");
    	}
    	System.out.println("Saldo atual R$ " + getSaldo() + " Limite disponível R$ " + getLimite());
		
	}
}