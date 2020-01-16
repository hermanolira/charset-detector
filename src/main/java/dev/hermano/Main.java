package dev.hermano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dev.hermano.util.CharsetUtil;

public class Main {

	public static void main(String[] args) {

		//String arg = "/home/82616973391/Área\ de\ Trabalho/Marinha_11112019/Marinha_11112019_embarcacoes_PGFN.txt";
		
		File file = new File(args[0]);

		try (InputStream fileInputStream = new FileInputStream(file)) {

			String charset = CharsetUtil.detectCharset(file);

			System.out.println(charset);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, charset/*"UTF-8"*/));

			for (String strLine; (strLine = br.readLine()) != null;) {
				if (strLine.contains("\"836033\";")) {
					System.out.println(strLine);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
