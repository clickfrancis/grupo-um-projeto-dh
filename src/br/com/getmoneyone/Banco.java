package br.com.getmoneyone;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
    	
    	
    	Scanner entrada = new Scanner(System.in);
    	
    	ContaEspecial especial = new ContaEspecial(1234, "098765");
    	
    	System.out.println("LIMITE " + especial.getLimite());
    	
    	while (especial.movimentacoes < 10) {
    		System.out.println("Saldo atual: R$ " + especial.getSaldo());
    		System.out.println("MOVIMENTO [D]Débito ou [C]Crédito");
    		especial.tipoMovimentacao = entrada.next().charAt(0);
    	
    		if (especial.tipoMovimentacao == 'C') {
    		System.out.println("Valor do crédito: R$ ");
    		double valorDeposito = entrada.nextDouble();
    		especial.credito(valorDeposito);
    		} else if (especial.tipoMovimentacao == 'D') {
    			System.out.println("Valor do débito: R$ ");
    			double valorSaque = entrada.nextDouble();
    			especial.debito(valorSaque);
    		} else {
    			System.out.println("Opcão inválida!");
    		}
    		
    		System.out.println("Continuar [S][N]: ");
    		especial.continuar = entrada.next().charAt(0);
    		if (especial.continuar == 'N') {
    			break;
    		} else if (especial.continuar == 'S' && especial.movimentacoes >= 10) {
    			System.out.println("Você atingiu o número máximo de movimentações. Finalizando...");
    			break;
    		}
    		System.out.println("=======================================");
    	}
    	System.out.println("Saldo atual R$ " + especial.getSaldo() + " Limite disponível R$ " + especial.getLimite());
    }
}
