package br.com.vainaweb.backendt1.vaiNuBank;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App 
{
	private static Scanner input = new Scanner(System.in);
	private static Map<Integer, ContaCorrente> contasCorrente = new HashMap<Integer, ContaCorrente>();
	private static Map<Integer, ContaPoupanca> contasPoupanca = new HashMap<Integer, ContaPoupanca>();
	
	
	public static void main(String[] args)
	{
		char decisao = 'n';
				
		do {
			menu();
			
			System.out.println("Deseja fazer outra operação? [s/n]");
			decisao = input.next().charAt(0);
		} while(decisao == 's' || decisao == 'S');
		
		
		
	}
	
	public static void menu() 
	{
		System.out.printf("Escolha uma opçao de operação%n%n[1] Cadastrar conta Poupança%n"
				+ "[2] Cadastrar conta corrente%n[3] Remover conta corrente%n[4] Remover conta poupança"
				+ "%n[5] Buscar uma conta corrente%n[6] Buscar uma conta poupança%n");
		
		int operacao = input.nextInt();		
		
		switch(operacao) 
		{
		//int numeroConta, String nomeTitular, long cpf, String agencia
			case 1:
				
				System.out.println("Digite o numero da conta: ");
				int numeroContaPoupanca = input.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				String nomeContaPoupanca = input.next();
				
				System.out.println("Digite o cpf: ");
				long cpfPoupanca = input.nextLong();
				
				System.out.println("Digite a agencia: ");
				String agenciaPoupanca = input.next();
				
				ContaPoupanca contaPoupanca = new ContaPoupanca(numeroContaPoupanca, 
						nomeContaPoupanca, cpfPoupanca, agenciaPoupanca);
				
				
				contasPoupanca.put(numeroContaPoupanca, contaPoupanca);
				
			break;
			
			case 2:
				
				System.out.println("Digite o numero da conta: ");
				int numeroContaCorrente = input.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				String nomeContaCorrente = input.next();
				
				System.out.println("Digite o cpf: ");
				long cpfCorrente = input.nextLong();
				
				System.out.println("Digite a agencia: ");
				String agenciaCorrente = input.next();
				
				System.out.println("Limite de crédito: ");
				float limiteCredito = input.nextFloat();
				
				ContaCorrente contaCorrente = new ContaCorrente(numeroContaCorrente,
						nomeContaCorrente, cpfCorrente, agenciaCorrente, limiteCredito);
				
				contasCorrente.put(numeroContaCorrente, contaCorrente);
			break;
			
			case 3:
				
				System.out.println("Para remover uma conta corrente digite o numero da mesma: ");
				int deleteCorrente = input.nextInt();
				contasCorrente.remove(deleteCorrente);
				
				
			break;
			
			case 4:
				
				System.out.println("Para remover uma conta poupança digite o numero da mesma: ");
				int deletePoupanca = input.nextInt();
				contasPoupanca.remove(deletePoupanca);
				
			break;
			
			case 5:
				
				System.out.println("Para buscar uma conta corrente digite o numero da mesma: ");
				int buscarCorrente = input.nextInt();
				if(contasPoupanca.get(buscarCorrente) == null) {
					System.out.println("Conta corrente foi removida ou nao existe");
				} else 
				{
					System.out.println(contasCorrente.get(buscarCorrente));
				}
				
			break;
			
			case 6:
				
				System.out.println("Para buscar uma conta poupança digite o numero da mesma: ");
				int buscarPoupanca = input.nextInt();
				if(contasPoupanca.get(buscarPoupanca) == null) {
					System.out.println("Conta poupança foi removida ou não existe");
				} else
				{
					System.out.println(contasPoupanca.get(buscarPoupanca));
				}
				
				
			break;
			default:
				System.out.println("Operação inválida");
		}
	}

}//fim da main
