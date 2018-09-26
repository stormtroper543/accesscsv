package asociacionesCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Asociaciones {
	
	
public static void main(String[] args) {
	System.out.println("0");
	csv();
	System.out.println("1");
	ArrayList<String> lista = guardado();
	System.out.println("2");
	lista.remove(0);
	System.out.println("3");
	//System.out.println(lista.toString());
	
	ArrayList<String> esto = cambiacomas(lista);
	System.out.println("4");
	
	//System.out.println(esto.toString());
	fin(esto);
	System.out.println("5");
}


public static void csv() {
	
	String datos = "contacts";
	String usuario = "Julen Gasco";
	String ubicacion = "desktop";
	FileReader f = null;
	try {
		f = new FileReader("C:\\Users\\"+usuario+"\\"+ubicacion+"\\" + datos +".csv");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BufferedReader b = new BufferedReader(f);
	String cadena ="";
	try {
		PrintWriter salida = new PrintWriter("C:\\Users\\"+usuario+"\\"+ubicacion+"\\" + "datos" +".txt");
		try {
			//int i =0;
			while((cadena = b.readLine())!=null) {
			      //System.out.println(i);
			salida.println(cadena);
			//i++;
			     
			  }
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

	
}

public static ArrayList<String> guardado() {
	
	String datos = "contacts";
	String usuario = "Julen Gasco";
	String ubicacion = "desktop";
	FileReader f = null;
	try {
		f = new FileReader("C:\\Users\\"+usuario+"\\"+ubicacion+"\\" + datos +".csv");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BufferedReader b = new BufferedReader(f);
	String cadena ="";
	ArrayList<String> lista = new ArrayList<String>();
	
		try {
			while((cadena = b.readLine())!=null) {
				lista.add(cadena);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(lista.toString());
		return lista;
	
}

public static ArrayList<String> cambiacomas(ArrayList<String> lista) {
	
	ArrayList<String> resultado = new ArrayList<String>();
	
	for(int i = 0; i< lista.size(); i++) {
		
		
		resultado.add(i, lista.get(i).replaceAll(",", "/"));
	}
	
	return resultado;

}

public static void fin(ArrayList<String> lista) {
	String datos = "importaesto";
	String usuario = "Julen Gasco";
	String ubicacion = "desktop";
	ArrayList<String> file = new ArrayList<String>();
	PrintWriter salida;
	try {
		salida = new PrintWriter("C:\\Users\\"+usuario+"\\"+ubicacion+"\\" + datos +".csv");
		for(int i = 0; i < lista.size();i++) {
			file.add(i, lista.get(i) + "\n");
			System.out.println(file.get(i));
		}
		salida.println(file.toString());
		salida.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	     
	
 }
}
