package br.com.vainaweb.backendt1.vaiNuBank;

public abstract class Conta
{
	private int numeroConta;
	private String nomeTitular;
	private float saldo;
	private long cpf;
	private String agencia;
	
	public Conta() {
		
	}
	public Conta(int numeroConta, String nomeTitular, long cpf, String agencia) {

		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
		this.agencia = agencia;
		this.cpf = cpf;
	
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	//Informa as informaçoes da conta
		//Nome do titular, cpf, numero
		public String toString() 
		{
			return String.format("===========================%nNome: %s%nNumero da conta:%d%nAgencia %s%nCpf: %d%nSaldo:%.2f%s%n",
					nomeTitular, numeroConta, agencia, cpf, saldo, (saldo < 0 ? " - você está devendo!" : ""));
			
		}	

}
