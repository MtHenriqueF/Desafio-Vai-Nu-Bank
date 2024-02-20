package br.com.vainaweb.backendt1.vaiNuBank;

public class ContaPoupanca extends Conta implements OperacoesBancarias 
{

	public ContaPoupanca() {
		super();
	}	
		
	public ContaPoupanca(int numeroConta, String nomeTitular, long cpf, String agencia) {
		super(numeroConta, nomeTitular, cpf, agencia);
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
		if(valor > getSaldo() || (valor + valor*0.02f) > getSaldo())
			throw new IllegalArgumentException("Valor de saque nao é valido");
		
		setSaldo(getSaldo() - valor);  //saque
		setSaldo(getSaldo() - valor*0.02f);   //desconto de 2 porcento do valor do saque
		System.out.println("Saque efetuado, novo saldo: " + getSaldo());
		
	}
	
	
	public void renderPoupanca() 
	{
		//rendimento de 0,5%
		float rendimentoPoupanca = 0.005f;
		
		setSaldo(getSaldo() + getSaldo()*rendimentoPoupanca);
		
	}

	//irá retirar do objeto atual dinheiro e adicionará esse para o outro objeto
	
	@Override
	public void transferir(ContaPoupanca contaTransferencia, float valor) 
	{
		//verifica se é possivel fazer a transferencia
		if(valor <= 0 || valor > getSaldo())
			throw new IllegalArgumentException("Valor inválido de depósito");
		
		setSaldo(getSaldo() - valor);
		contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
		
	}
	
	@Override
	public void transferir(ContaCorrente contaTransferencia, float valor) 
	{
		//verifica se é possivel fazer a transferencia
		if(valor <= 0 || valor > getSaldo())
			throw new IllegalArgumentException("Valor inválido de depósito");
		
		setSaldo(getSaldo() - valor);
		contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return String.format(super.toString() + "===========================");
	}

}
