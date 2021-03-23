package org.EDAII.practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ciudad {
	
	//private static Ciudad ciudad;
	private int []listaDias;
	private int calles;
	private int avenidas;
	private int inicio;
	private int fin;
	private int d1;
	private int d2;
	private int [][] ciudad; 
	Distrito []distritos = new Distrito[500];
	ArrayList<Resultado> resultados = new ArrayList<Resultado>(); // Luego utilizar collections.sort
	private static String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "practica01"+ File.separator;


	Ciudad(String archivo) {
		
		/** Probamos con datos estaticos, luego hacemos la lectura del archivo **/
		this.calles = 500;
		this.avenidas = 500;
		ciudad = new int [calles][avenidas];
	}
	
	
	//NO TOCAR--------------------------------------------------------------------
//	private void cargarArchivo(String archivo) {
//		JFileChooser file = new JFileChooser();
//	   	file.setDialogTitle("Cargar archivo");
//	   	file.setCurrentDirectory(new File(dir));
//	   	file.setFileSelectionMode(JFileChooser.FILES_ONLY);
//	   	file.setMultiSelectionEnabled(false);
//	   	file.setAcceptAllFileFilterUsed(false);
//	   	FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .txt", "txt");
//	    file.addChoosableFileFilter(filtro);
//	   	file.showOpenDialog(null);
//	   	File f=file.getSelectedFile();
//	   	try {
//	   		if(f == null) {
//		    	JOptionPane.showMessageDialog(null, "Carga de archivo cancelada");
//	   		}else if(!f.exists())	{
//	   			JOptionPane.showMessageDialog(null,"El archivo no existe");
//
//			}else {
//				try {
//					ciudad = new Ciudad(archivo);
//					JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente");
//				}catch(FileNotFoundException e) {
//					System.out.println(e.getMessage());
//				}
//			}
//	   	} catch (Exception e) {
//			System.out.println(e.getMessage());
//	   	}
//
//	}

	public void RecorrerCiudad() 
	{
		//d(4*((m-1) DIV 4), 10*((n-1) DIV 10))
		// m = calles , n = avenidas
		for(int n = 0; n < avenidas; n+=10) // El primero será d(0, 0) !En EL ARRAY, teoricamente será d(1,1)
		{                                   // El segundo será d(4, 1) y así.. 
			for(int m = 0; m < calles; m+=4) 
			{
				// Generar datos distrito
				// add distrito
			}
		}
	}
	
	public String toString() {
		return null;
		
	}
	
	public void FuerzaBruta() {
		for (Distrito distrito : distritos) {
			for (int i = 0; i < distrito.toString(); i++) {// tiene que recorrer distrito desde la pos 0 hasta el maximo
															// de la
															// matriz d(0,0) a d(2,2) por ejemplo
				// Obtener el valor de cada posicion mediante el toString
				// de cada objeto de la clase distrito
			}
		}
	}

	
	public void DyV() {
		DyV(avenidas,calles, listaDias, inicio, fin);
	}
	
	// Con el DyV debemos encontrar el nº maximo de casos de cada distrito en el array de casos.
	// Creo que debería ir en Distrito.
	private int DyV(int avenidas, int calles, int []listaDias , int inicio, int fin)
	{
		if (inicio==fin) {
			return inicio;
		}
		if (inicio+1==fin) {
			if(listaDias[inicio] >= listaDias[fin]) {
				return inicio;
			}else {
				return fin;
			}
		}
		
		int mitad = (inicio+fin)/2;
		if ((listaDias[mitad] > listaDias[mitad-1]) && listaDias[mitad] >listaDias[mitad+1]) {
			return mitad;
		}
		
		if(listaDias[mitad-1] > listaDias[mitad]) {
			return DyV(avenidas, calles, listaDias, inicio, mitad-1);
		}
		if (listaDias[mitad+1] > listaDias[mitad]) {
			return DyV(avenidas, calles, listaDias, mitad+1, fin);
		}
		int izq = DyV(avenidas, calles, listaDias,inicio, mitad-1);
		int der = DyV(avenidas, calles, listaDias,inicio, mitad-1);
		
		if (listaDias[izq]>= listaDias[der]) {
			return izq;
		}else {
			return der;
		}
	}
	
	String getResultados(){
		return resultados.toString().replace("[", "").replace("]", "");
		
	}
	
	public void guardarResultado(String nombre) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(nombre));
		pw.println("Resultados");
		for (Resultado r : resultados) {
			pw.println(r.toString());
		}
		pw.close();
	}
}
