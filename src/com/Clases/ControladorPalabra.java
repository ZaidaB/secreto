package com.Clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.BD.BaseDeDatos;

public class ControladorPalabra {
String palabra;
String categoria;

public void elegirCategoriaPalabra() throws UnsupportedEncodingException, FileNotFoundException, IOException{
	BaseDeDatos buscarPalabra=new BaseDeDatos();
	String[] aux= buscarPalabra.elegirCategoria();
	this.setCategoria(aux[1]);
	this.setPalabra(buscarPalabra.elegirPalabra(aux)[0]);
}


public String getPalabra() {
	return palabra;
}
public void setPalabra(String palabra) {
	this.palabra = palabra;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}


}
