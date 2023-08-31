package controller;
import java.io.*;

public class KillController {
	
	private String os() {
		String sistema=System.getProperty("os.name");
		return sistema;
	}
	
	public void listaProcessos() {
		String os=this.os();
		String comando=null;
		String leitor;
		
		if (os.equals("Linux")) {
			comando=" ps -ef";
		}else {
			comando="TASKLIST /FO TABLE";
		}
		try {
			Process processos=Runtime.getRuntime().exec(comando);
			BufferedReader input=new BufferedReader(new InputStreamReader(processos.getInputStream()));
			while((leitor=input.readLine())!=null) {
				System.out.println(leitor);
			}
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid(String pid) {
		String os=this.os();
		StringBuilder comandoKill=new StringBuilder();
		
		if(os.equals("Linux")) {
			comandoKill.append("kill-9 ");
		}else {
			comandoKill.append("TASKKILL /PID ");
		}
		
		comandoKill.append(pid);
		
		try {
			Runtime.getRuntime().exec(comandoKill.toString());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void mataNome(String nomeProcesso) {
		String os=this.os();
		StringBuilder comandoNome=new StringBuilder();
		if(os.equals("Linux")) {
			comandoNome.append("pkill -f");
		}else {
			comandoNome.append("TASKKILL /IM ");
		}
		
		comandoNome.append(nomeProcesso);
		
		try {
			Runtime.getRuntime().exec(comandoNome.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
