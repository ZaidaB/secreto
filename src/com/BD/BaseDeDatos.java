package com.BD;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BaseDeDatos {

	public ArrayList<String[]> LeerFicheroCsv(String fichero_a_leer)
			throws UnsupportedEncodingException, FileNotFoundException,
			IOException {

		ArrayList<String[]> datos = new ArrayList<String[]>();

		FileInputStream fis = new FileInputStream(fichero_a_leer);
		// para ficheros con símbolos propios del español,
		// utilizar la codificación "ISO-8859-1"
		InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		BufferedReader br = new BufferedReader(isr);

		String linea = br.readLine();
		while (linea != null) {
			datos.add(linea.split(","));
			linea = br.readLine();
		}

		br.close();
		isr.close();
		fis.close();

		return datos;

	}

	public String[] elegirCategoria() throws UnsupportedEncodingException,
	FileNotFoundException, IOException{
		Random rand = new Random();
		ArrayList<String[]> f = this
				.LeerFicheroCsv("C:\\Users\\Zaida\\FreeLance\\Aprendiendo JSF\\workspace\\Practica1_Ahorcado\\src\\com\\BD\\Categorias.csv");
		int cat=(int)(rand.nextDouble() * f.size());
	System.out.println(cat);
		return f.get(cat);
	}
	
	public String[] elegirPalabra(String[] cat)  throws UnsupportedEncodingException,
	FileNotFoundException, IOException{
		Random rand = new Random();
		ArrayList<String[]> listaPalabras=new ArrayList<String[]>();
		System.out.println(Integer.parseInt(cat[0]));
		switch(Integer.parseInt(cat[0])){
		case 1:
			listaPalabras = this
			.LeerFicheroCsv("C:\\Users\\Zaida\\FreeLance\\Aprendiendo JSF\\workspace\\Practica1_Ahorcado\\src\\com\\BD\\Fobias.csv");
			break;
		case 2:
			listaPalabras = this
			.LeerFicheroCsv("C:\\Users\\Zaida\\FreeLance\\Aprendiendo JSF\\workspace\\Practica1_Ahorcado\\src\\com\\BD\\Frutas.csv");
			break;
		case 3:
			listaPalabras = this
			.LeerFicheroCsv("C:\\Users\\Zaida\\FreeLance\\Aprendiendo JSF\\workspace\\Practica1_Ahorcado\\src\\com\\BD\\Verduras.csv");
			break;
		}
		
		int pa=(int)(rand.nextDouble() * listaPalabras.size());
		return listaPalabras.get(pa);
	}

	public void EscribirFicheroCsv(String fichero_a_escribir,
			ArrayList<String[]> d) throws UnsupportedEncodingException,
			FileNotFoundException, IOException {

		OutputStream fout = new FileOutputStream(fichero_a_escribir);
		// para ficheros con símbolos propios del español,
		// utilizar la codificación "ISO-8859-1"
		OutputStreamWriter out = new OutputStreamWriter(fout, "UTF8");

		for (int i = 0; i < d.size(); i++) {

			String[] fila = d.get(i);

			for (int j = 0; j < fila.length; j++) {
				out.write(fila[j] + ",");
			}

			out.write("\n");
		}
		out.close();
		fout.close();
	}

	public static void main(String[] args) throws UnsupportedEncodingException,
			FileNotFoundException, IOException {

		// construimos una instancia de la clase
		BaseDeDatos le = new BaseDeDatos();
		// leemos un fichero
		ArrayList<String[]> f = le
				.LeerFicheroCsv("C:\\Users\\Zaida\\FreeLance\\Aprendiendo JSF\\workspace\\Practica1_Ahorcado\\src\\com\\BD\\Categorias.csv");
		// f contiene todo el contenido del fichero que acabamos de leer
		// le.EscribirFicheroCsv("C:\\Temp\\salida.csv", f);
		String[] cati=le.elegirCategoria();
		String[] pala=le.elegirPalabra(cati);
		System.out.println(cati[1]);
		System.out.println(pala[0]);
		
	}

}
