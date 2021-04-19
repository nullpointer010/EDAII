package org.EDAII.practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

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
	
	/*** Utilizamos arraylist para hacer sort despuÈs ya que el ejercicio nos pide los resultados ordenados por dia
	 * los dias pueden ser duplicados por lo que no podemos usar treeset o treemap
	 * compareTo en resultados. øEn caso de que dos dÌas sean iguales hay que ver el distrito m·s cercano ?
	 */
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
			load(archivo);
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
		for(int n = 0; n < avenidas; n+=d2) // El primero serÔøΩ d(0, 0) !En EL ARRAY, teoricamente serÔøΩ d(1,1)
		{                                   // El segundo serÔøΩ d(4, 1) y asÔøΩ.. 
			for(int m = 0; m < calles; m+=d1) 
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
			for(int u=0; u < distritos[i].numeroDias();u++){ // estos dos for obtienen El d√≠a con mas casos, y dicho n√∫mero de casos
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

			//aqu√≠ se deber√≠an guardar el distrito, d√≠a, y casoMayor, podr√≠a ser un array de Resultados por ejemplo,    Resultado(distrito[i], dia, casoMayor)
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

	// Con el DyV debemos encontrar el nÔøΩ maximo de casos de cada distrito en el array de casos.
	// Creo que deberÔøΩa ir en Distrito.
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
	
	public void DyVMejorado()
	{
		int pos = 0;
		resultados = new ArrayList<Resultado>();
		Resultado res = null;
		for (Distrito distrito : distritos) 
		{
			pos= DyVMejorado(distrito.getListaCasos(),0,distrito.numeroDias());
			res= new Resultado(distrito, pos+1, distrito.get(pos));
			resultados.add(res);
		}
		Collections.sort(resultados);
	}

	// M·s optimizado
	private int DyVMejorado(int []listaDias , int inicio, int fin)
	{	
		if(fin - inicio <= 1) // Caso base
		{
			if(inicio == fin) return inicio;
			
			if(listaDias[inicio] >= listaDias[fin]) {
				return inicio;
			}else {
				return fin;
			}
		}

		int mitad = (inicio+fin)/2;
		if ((listaDias[mitad] > listaDias[mitad-1]) && listaDias[mitad] >listaDias[mitad+1]) {
			return mitad; //PequeÒa opt, ? caso base?
		}
		
		if(listaDias[mitad-1] > listaDias[mitad]) { // Caso recursivo izquierda
			return DyVMejorado(listaDias,inicio, mitad-1);
		}
		return DyVMejorado(listaDias,mitad+1, fin); // Caso recursivo derecha
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
