package view;
import controller.KillController;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		KillController controller=new KillController();
		Scanner sc=new Scanner(System.in);
		int escolha=-1; 
		String pidKill;
		String nomeProcesso=null;
		
		while(escolha!=9) {
			System.out.println("Selecione a opcao\n");
			System.out.println("1) Lista processos\n");
			System.out.println("2)Matar processo por pid\n");
			System.out.println("3)Matar processo por nome\n");
			System.out.println("9)Finalizar");
			escolha=sc.nextInt();
			switch(escolha) {
				case 1:
					controller.listaProcessos(); break;
				case 2:
					System.out.println("Pid do processo para matar:");
					pidKill=sc.next();
					controller.mataPid(pidKill); break;
				case 3:
					System.out.println("Nome do processo para matar:");
					nomeProcesso=sc.next();
					controller.mataNome(nomeProcesso); break;
				case 9:
					System.out.println("Finalizado"); break;
				default:
					System.out.println("Escolha invalida");	
			}
		}
	}
}
