package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.println("A conta número: "+numero+" não foi encontrada!");
		}
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		for(Conta conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("A conta foi criada!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta número: "+conta.getNumero()+" foi atualizada!");
		}else {
			System.out.println("A conta número: "+conta.getNumero()+" não foi atualizada!");
		}
		
	}
	
	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.println("A conta número: "+numero+" foi excluida!");
				
			}
		}else {
			System.out.println("A conta número: "+numero+" não foi excluida!");
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numero, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	/* Implementar Métodos Auxiliares */
	public int gerarNumero () {
		return listaContas.size() + 1;
	}
	
	public Conta buscarNaCollection(int num) {
		for(var conta : listaContas) {
			if(conta.getNumero() == num) {
				return conta;
			}
		}
		
		return null;
	};
	public int retornaTipo(int num) {
		for(var conta : listaContas) {
			if(conta.getNumero() == num) {
				return conta.getTipo();
			}
		}
		
		return 0;
	};

}
