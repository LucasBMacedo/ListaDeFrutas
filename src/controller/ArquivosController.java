package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File (path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
				
			}
			
		} else {
			throw new IOException("Diretório inválido");
		}
		
	}

	@Override
	public void createFile(String path, String nome) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido");
		}
	}

	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase", "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equalsIgnoreCase("fim")) {
			buffer.append(linha + "\r\n");
			}
		}
		return buffer.toString();
	}

	@SuppressWarnings("resource")
	@Override
	public void readFile(String path, String nome, int filter) throws IOException {
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			if (filter == 0) { //Leitura Simples 
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			} else { //Filtragem.
				String[] colunas = linha.split(",");
				int foodNameIdx = -1, sciNameIdx = -1, groupIdx = -1, subGroupIdx = -1;

				for (int i = 0; i < colunas.length; i++) {
					String col = colunas[i].toLowerCase();
					if (col.contains("food name")) foodNameIdx = i;
					else if (col.contains("scientific name")) sciNameIdx = i;
					else if (col.equals("group")) groupIdx = i;
					else if (col.contains("sub group")) subGroupIdx = i;
				}
				// Verificação aqui:
				if (foodNameIdx == -1 || sciNameIdx == -1 || groupIdx == -1 || subGroupIdx == -1) {
					throw new IOException("Erro ao identificar colunas no cabeçalho. Verifique o formato do CSV.");
				}

				linha = buffer.readLine();
				while (linha != null) {
					String[] campos = linha.split(",");
					if (campos.length > groupIdx && campos[groupIdx].equalsIgnoreCase("Fruits")) {
						System.out.println(campos[foodNameIdx] + "\t" + campos[sciNameIdx] + "\t" + campos[subGroupIdx]);
					}
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File (path, nome);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo inválido");
		}
	}	
}
