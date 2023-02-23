package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) {

    	Scanner scan = new Scanner(System.in);
    	//ContaPoupanca c4 = new ContaPoupanca(4,)
    	
    	
    	
    	ContaCorrente c1 = new ContaCorrente(1,123,1,"Isaac",3000.0f,1000f);
    	
    	c1.visualizar();
    	
    	ContaCorrente c2 = new ContaCorrente(1,123,1,"Isaac",3000.0f,1000f);
    	
    	c1.visualizar();
    	
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
    		
    		opcao=scan.nextInt();
    		
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
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = scan.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}

				keyPress();
				
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				// Condicional para checar se a conta existe
				
				System.out.println("Número da Agencia: ");
				agencia = scan.nextInt();
				
				System.out.println("Nome do Titular: ");
				scan.skip("\\R?");
				titular =  scan.nextLine();
				
				// Busca do tipo
				tipo = 0;
				
				System.out.println("Saldo da Conta: ");
				saldo = scan.nextFloat();
				
				switch(tipo) {
					case 1 ->{
						System.out.println("Limite da Conta Corrente: ");
						limite = scan.nextFloat();
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = scan.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				// Chamada para o Método Deletar
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = scan.nextFloat();
				
				// Chamada para o Método Sacar
				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");
				
				System.out.println("Número da Conta: ");
				numero = scan.nextInt();
				
				System.out.println("Valor do Depósito: ");
				valor = scan.nextFloat();
				
				// Chamada para o Método Depositar

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