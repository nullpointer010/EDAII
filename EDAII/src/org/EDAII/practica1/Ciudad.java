package org.EDAII.practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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


	public Ciudad(int avenidas, int calles, int d1, int d2, int dias, int caso) {
		this.avenidas = avenidas;
		this.calles = calles;
		this.d1=d1;
		this.d2=d2;

		for (int i = 0; i < (avenidas-1)/d1; i++) {
			for (int j = 0; j < (calles-1)/d2; j++) {
				Distrito d = new Distrito(d1-i+1,d2*j+1);
				Utilities.rellenar(d,dias,caso);
				this.distritos.add(d);
			}
		}


	}


	private void cargarArchivo(String archivo) {
		try {
			load(rutaArchivo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void load(String rutaArchivo) throws FileNotFoundException {
		distritos = new Distrito[500];
		Scanner sc = new Scanner(new File(rutaArchivo));
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
		for(int n = 0; n < avenidas; n+=10) // El primero ser� d(0, 0) !En EL ARRAY, teoricamente ser� d(1,1)
		{                                   // El segundo ser� d(4, 1) y as�.. 
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

		//////////////////////////////////////////////////////////////////////////////////////////
		int i=0;
		for (Distrito distrito : distritos) {

			int casoMayor;
			int dia;
			for(int u=0; u < distritos[i].numeroDias();u++){ // estos dos for obtienen El día con mas casos, y dicho número de casos
				for (int j=1 ; j < distritos[i].numeroDias() + 1; j++){//
					if (distritos[i].get(u) > distritos[i].get(j)){

						casoMayor = distritos[i].get(u);
						dia = u;
					}
					else if (distritos[i].get(j) > distritos[i].get(u)){
						
						casoMayor = distritos[i].get(j);
						dia = j;
					}
				}
			}

			//aquí se deberían guardar el distrito, día, y casoMayor, podría ser un array de Resultados por ejemplo,    Resultado(distrito[i], dia, casoMayor)
			i++;


		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}


	public void DyV() {
		resultados = new ArrayList<Resultado>();
		for (Distrito distrito : distritos) {
			pos= DyV(d.getArray(),O,d.getArray().length);
			Yres= new Y(d.getNombre(), pos+1, d.getArray[pos]);
			resultado.add(res);
		}
	}

	// Con el DyV debemos encontrar el n� maximo de casos de cada distrito en el array de casos.
	// Creo que deber�a ir en Distrito.
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
