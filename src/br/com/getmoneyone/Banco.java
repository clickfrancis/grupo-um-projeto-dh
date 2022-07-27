package br.com.getmoneyone;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
    	
    	Scanner entrada = new Scanner(System.in);
    	
    	
    	ContaEspecial especial = new ContaEspecial(1234, "098765");
    	
    	especial.limite = 1000;
    	especial.setSaldo(1000.0);
    	
    	while (especial.movimentacoes < 10) {
    		System.out.println("Saldo atual: R$ " + especial.getSaldo());
    		System.out.println("MOVIMENTO [D]Débito ou [C]Crédito");
    		especial.tipoMovimentacao = entrada.next().charAt(0);
    		
    		
    		if (especial.tipoMovimentacao == 'C') {
    		System.out.println("Valor do crédito: R$ ");
    		especial.valorCredito = entrada.nextDouble();
    		especial.credito();
    		} else if (especial.tipoMovimentacao == 'D') {
    			System.out.println("Valor do débito: R$ ");
    			especial.valorDebito = entrada.nextDouble();
    			especial.debito();
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
    	System.out.println("Saldo atual R$ " + especial.getSaldo() + " Limite disponível R$ " + especial.limite);
    }
}
