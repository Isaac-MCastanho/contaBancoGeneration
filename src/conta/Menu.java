package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) {

    	Scanner scan = new Scanner(System.in);
    	
    	int opcao;
    	
    	Conta c1 = new Conta(1,123,1,"Isaac",3000.0f);
    	
    	c1.visualizar();
    	
    	
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
    		
    		switch(opcao) {
    		case 1:
    			System.out.println("Criar conta\n\n");
    			break;
    		case 2:
    			System.out.println("Listar todas as conta\n\n");
    			break;
    		case 3:
    			System.out.println("Consultar dados da conta - por número\n\n");
    			break;
    		case 4:
    			System.out.println("Atualizar dados da conta \n\n");
    			break;
    		case 5:
    			System.out.println("Apagar conta\n\n");
    			break;
    		case 6:
    			System.out.println("Saque\n\n");
    			break;
    		case 7:
    			System.out.println("Depósito\n\n");
    			break;
    		case 8:
    			System.out.println("Transferencia entre contas\n\n");
    			break;
    		default:
    			System.out.println("Criar conta\n\n");
    			break;
    		}
    	}
    	
    }
}