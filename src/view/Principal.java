package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		//String dirWin = "C:\\Windows";
		String dirMac = "/System";
		String path = "/Users/lucasbezerrademacedo/Documents";
		String nome = "generic_food(Planilha1).csv";
		
		try {
			//arqCont.readDir(dirMac);
			//arqCont.createFile(path, nome);
			//arqCont.readFile(path, nome);
			//arqCont.openFile(path, nome);
			arqCont.readFile(path, nome, 1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		}
	}