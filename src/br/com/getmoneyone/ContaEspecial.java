package br.com.getmoneyone;

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
			if (saldo >= saque) {   //Lógica para quando o saldo é maior do que o valor debitado.
				saldo -= saque;
				movimentacoes ++;		  //variavel de controle para as mobimentações (limitado a 10 movimentos).
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
			movimentacoes++;
			setSaldo(saldo);
			System.out.println("CREDITO " + deposito);
			System.out.println("SALDO " + saldo);
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void usarLimite(double saque) {
		double saldo = getSaldo();
		double limiteUtilizado = saque - saldo;  //Lógica para quando o limite precisa ser utilizado.
		if (limiteUtilizado <= 1000 && limite >= limiteUtilizado) {
		limite -= limiteUtilizado;                     //Atualiza limite
		saldo -= saque;
		saldo += limiteUtilizado;                      //Adiciona o limite utilizado com saldo.
		movimentacoes ++;
		setSaldo(saldo);
		System.out.println("Saldo insuficiente, foi utilizado R$" + limiteUtilizado + " do seu limite, Limite ATUAL: " + limite);
		System.out.println("DEBITO " + saque);
		} else {
			System.out.println("Ultrapassa seu saldo, e não tem mais limite disponível!");
		}
	}
}