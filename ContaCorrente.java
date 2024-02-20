package br.com.vainaweb.backendt1.vaiNuBank;

public class ContaCorrente extends Conta implements OperacoesBancarias
{
	private float limiteDeCredito;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(int numeroConta, String nomeTitular, long cpf, String agencia, float limiteDeCredito) {
		super(numeroConta, nomeTitular, cpf, agencia);
		this.limiteDeCredito = limiteDeCredito;
	}	
	
	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	
	
	@Override
	public void depositar(float valor)
	{
		if(valor <= 0)
			throw new IllegalArgumentException("Valor inválido de depósito");
		
		setSaldo(getSaldo() + valor);
		System.out.println("Valor depositado, novo saldo: " + getSaldo());
		
	}

	@Override
	public void sacar(float valor)
	{
		//verifica 
		if(valor > getSaldo()) 
		{
			if(getLimiteDeCredito() > valor) 
			{
				System.out.println("Voce usou seu limite de credito para está operação");
				
				setSaldo(getSaldo() - valor);
				setLimiteDeCredito(getLimiteDeCredito() - valor);
			}
			else 
			{
				throw new IllegalArgumentException("Valor de saque nao é valido");
			}	
		} 
		else
		{	
			setSaldo(getSaldo() - valor);  //saque
			System.out.println("Saque efetuado, novo saldo: " + getSaldo());
		}
		
	}

	//transfere para conta do tipo conta corrente
	@Override
	public void transferir(ContaCorrente contaTransferencia, float valor) {
		if(valor > getSaldo()) 
		{
			if(getLimiteDeCredito() + getSaldo() >= valor) 
			{
				System.out.println("Voce usou seu limite de credito para está operação");
				
				setLimiteDeCredito(getLimiteDeCredito() + getSaldo() - valor);
				setSaldo(getSaldo() - valor);
				
				contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
				
			}
			else 
			{
				throw new IllegalArgumentException("Valor de saque nao é valido");
			}	
		} 
		else
		{
			setSaldo(getSaldo() - valor);
			contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
		}
		
	}

	//transfere para conta do tipo conta poupanca
	@Override
	public void transferir(ContaPoupanca contaTransferencia, float valor) {
		if(valor > getSaldo()) 
		{
			if(getLimiteDeCredito() + getSaldo() >= valor) 
			{
				System.out.println("Voce usou seu limite de credito para está operação");
				
				setLimiteDeCredito(getLimiteDeCredito() + getSaldo() - valor);
				setSaldo(getSaldo() - valor);
				
				contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
				
			}
			else 
			{
				throw new IllegalArgumentException("Valor de saque nao é valido");
			}	
		} 
		else
		{
			setSaldo(getSaldo() - valor);
			contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
		}
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return String.format(super.toString() +
				"Limite de credito %.2f%n===========================", getLimiteDeCredito());
	}
	
}
