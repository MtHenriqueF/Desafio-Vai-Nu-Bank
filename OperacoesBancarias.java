package br.com.vainaweb.backendt1.vaiNuBank;

public interface OperacoesBancarias
{
	void depositar(float valor);
	void sacar(float valor);
	void transferir(ContaCorrente numeroDaConta, float valor);
	void transferir(ContaPoupanca numeroDaConta, float valor);

}
