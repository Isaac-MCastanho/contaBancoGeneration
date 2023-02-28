package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) {

    	Scanner scan = new Scanner(System.in);
    	ContaController contas= new ContaController();
    	
    	
    	
System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
			
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();

    
    	
    	int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;
    	while(true) {
    		System.out.println("|************************************************|");
    		System.out.println("|                                                |");
    		System.out.println("|       "+Cores.TEXT_RED+"      Banco do Brazil com Z      "+Cores.TEXT_RESET+"        |");
    		System.out.println("|                                                |");
    		System.out.println("|************************************************|");
    		System.out.println("|      1 - Criar conta                           |");
    		System.out.println("|      2 - Listar todas as conta                 |");
    		System.out.println("|      3 - Buscar conta por numero               |");
    		System.out.println("|      4 - Atualizar dados da conta              |");
    		System.out.println("|      5 - Apagar conta                          |");
    		System.out.println("|      6 - Sacar                                 |");
    		System.out.println("|      7 - Depositar                             |");
    		System.out.println("|      8 - Transferir valores entre contas       |");
    		System.out.println("|      9 - Sair                                  |");
    		System.out.println("|                                                |");
    		System.out.println("|************************************************|");
    		System.out.println("|         Entre com a opção desejada:            |");
    		System.out.println("|                                                |");
    		try {
    			
    			opcao=scan.nextInt();
    		}catch(InputMismatchException e) {
    			System.out.println("Digite valores inteiros!");
    			scan.nextLine();
    			opcao=0;
    		}
    		
    		if(opcao == 9) {
    			System.out.println("\nBanco do Brazil com Z - Agradecemos sua preferencia, volte sempre!");
    			scan.close();
    			System.exit(0);
    		}
    		
    		switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Número da Agencia: ");
				agencia = scan.nextInt();
				
				System.out.println("Nome do Titular: ");
				scan.skip("\\R?");
				titular =  scan.nextLine();
				
				do {
					System.out.println("Tipo da Conta (1-CC / 2-CP): ");
					tipo = scan.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Saldo da Conta: ");
				saldo = scan.nextFloat();
				
				switch(tipo) {
					case 1 ->{
						System.out.println("Limite da Conta Corrente: ");
						limite = scan.nextFloat();
						contas.cadastrar(  new ContaCorrente(0, agencia, tipo, titular, saldo, limite));
						
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = scan.nextInt();
						contas.cadastrar( new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario));
						;
					}
				}

				keyPress();
				
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();				
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
				
				System.out.println("Número da Agencia: ");
				agencia = scan.nextInt();
				
				System.out.println("Nome do Titular: ");
				scan.skip("\\R?");
				titular =  scan.nextLine();
				
				// Busca do tipo
				tipo = contas.retornaTipo(numero);
				
				System.out.println("Saldo da Conta: ");
				saldo = scan.nextFloat();
				
				switch(tipo) {
					case 1 ->{
						System.out.println("Limite da Conta Corrente: ");
						limite = scan.nextFloat();
						contas.atualizar( new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						//cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = scan.nextInt();
						contas.atualizar(  new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						//cp.visualizar();
					}
				}
				}else {
					
					System.out.println("Conta não encontrada! ");
				}
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = scan.nextFloat();
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				System.out.println("Valor do Depósito: ");
				valor = scan.nextFloat();
				
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				System.out.println("Número da Conta - Origem: ");
				numero = scan.nextInt();
				
				System.out.println("Número da Conta - Destino: ");
				numeroDestino = scan.nextInt();
				
				System.out.println("Valor da Transferência: ");
				valor = scan.nextFloat();
				
				// Chamada para o Método Transferir
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
		}
	}
	
}

public static void keyPress() {

	try {

		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		System.in.read();

	} catch (IOException e) {

		System.out.println("Você pressionou uma tecla diferente de enter!");

	}
}
}