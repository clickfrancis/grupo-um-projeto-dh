package br.com.getmoneyone;

public class ContaEspecial extends Conta {
	
	double limite;
	double valorDebito;
	double valorCredito;
	double movimentacoes;
	double saldo;

	protected ContaEspecial(int numero, String cpf) {
		super(numero, cpf);
		
	}

	protected void debito() {
		if (movimentacoes < 10) {        
			saldo = getSaldo();  
			if (saldo >= valorDebito) {   //Lógica para quando o saldo é maior do que o valor debitado.
				saldo -= valorDebito;
				movimentacoes ++;		  //variavel de controle para as mobimentações (limitado a 10 movimentos).
				setSaldo(saldo);
			} else {
				usarLimite();
			}
			
		System.out.println("DEBITO " + valorDebito);
		System.out.println("SALDO " + saldo);
		System.out.println("MOVIMENTAÇÕES: " + movimentacoes);
		} else {
			System.out.println("LIMITE 10 MOVIMENTAÇOES");
		}
	}

	public void credito() {
		//TODO: LÓGICA CRÉDITO;
	}
	
	public void usarLimite() {
		double limiteUtilizado = valorDebito - saldo;  //Lógica para quando o limite precisa ser utilizado.
		if (limiteUtilizado <= 1000) {
		limite -= limiteUtilizado;                     //Atualiza limite
		saldo -= valorDebito;
		saldo += limiteUtilizado;                      //Adiciona o limite utilizado com saldo.
		movimentacoes ++;
		setSaldo(saldo);
		System.out.println("Saldo insuficiente, foi utilizado R$" + limiteUtilizado + " do seu limite, Limite ATUAL: " + limite);
		} else {
			System.out.println("Ultrapassa seu saldo, e não tem mais limite disponível");
		}
	}
}
