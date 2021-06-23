package org.EDAII.practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ciudad {

	private int calles;
	private int avenidas;
	private int numeroDias;
	private int d1;
	private int d2;
	private ArrayList<Distrito> distritos;

	public ArrayList<Distrito> getDistritos() {
		return distritos;
	}

	/*** Utilizamos arraylist para hacer sort despu�s ya que el ejercicio nos pide los resultados ordenados por dia
	 * los dias pueden ser duplicados por lo que no podemos usar treeset o treemap
	 * compareTo en resultados. �En caso de que dos d�as sean iguales hay que ver el distrito m�s cercano ?
	 */
	ArrayList<Resultado> resultados = new ArrayList<Resultado>(); // Luego utilizar collections.sort
	
	public Ciudad() 
	{
		this.distritos = new ArrayList<Distrito>();
	}
	
	public Ciudad(int avenidas, int calles, int d1, int d2, int dias, int caso)
	{
		this.avenidas = avenidas;
		this.calles = calles;
		this.d1=d1;
		this.d2=d2;
		this.numeroDias = dias;
		this.distritos = new ArrayList<Distrito>();
		
		recorrerRellenarCiudad(caso);
	}


	public void cargarArchivo(String file) {
		try {
			Scanner sc = new Scanner(new File(file));
			int avenidaD = 1;
			int calleD = 1;
			while (sc.hasNextLine())
			{
				String s = sc.nextLine();
				if (s.startsWith("@") || s.isEmpty() && s.startsWith("#"))
					continue;

				if (s.startsWith("n")) {
					String[] x = s.split("=");
					this.calles = Integer.parseInt(x[1]);
					continue;
				}

				if (s.startsWith("m")) {
					String[] x = s.split("=");
					this.avenidas = Integer.parseInt(x[1]);
					continue;
				}
				
				if (s.startsWith("d1")) {
					String[] x = s.split("=");
					this.d1 = Integer.parseInt(x[1]);
				}
				
				if (s.startsWith("d2")) {
					String[] x = s.split("=");
					this.d2 = Integer.parseInt(x[1]);
				}
				
				if (s.startsWith("dn")) {
					String[] x = s.split("=");
					this.numeroDias = Integer.parseInt(x[1]);
				}

				if (s.startsWith("D")) 
				{
					String[] nombre = s.split(" ");
					// D382 1,4;2,8;3,12;4,63;5,69;6,500
					Distrito distrito = new Distrito(nombre[0], avenidaD, calleD, numeroDias);
					String[] stringCasos = nombre[1].split(";");
					distrito.rellenarCasos(stringCasos);
					
					distritos.add(distrito);
					
					/* Calculamos para pasar al siguiente distrito */
					if(avenidaD + d1 < avenidas) 
					{
						avenidaD += d1;
				    }else {
				    	if(calleD + d2 < calles) {
				    		calleD += d2;
				    		avenidaD = 1;
				    	} else {
				    		// Tenemos mas distritos de los que podemos almacenar, por lo que rompemos
				    		break;
				    	}
				    }						
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public void recorrerRellenarCiudad(int caso) 
	{
		//d(4*((m-1) DIV 4), 10*((n-1) DIV 10))
		// m = avenidas(col) , n = calles(fil)
		// d1 avenidas, d2 = calles

		// Calcular el n total de avenidas = ((div entera) (n-1) DIV d1) + 1
		// Calcular m total de calles  = ((div entera)(m-1) DIV d2) + 1
		
		//PRECONDICIONES n y m DEBEN SER > 1
		for(int n = 1; n < calles; n+=(d2))
		{
			for(int m = 1; m < avenidas; m+=(d1)) 
			{
				// Generar datos distrito
				// add distrito
				
				Distrito distrito = new Distrito("D"+(m+n)+""+n, m, n, numeroDias);
				Utilities.rellenar(distrito,numeroDias,caso);
				distritos.add(distrito);
			}
		}
	}

	public String toString() {
		return numeroDias+"dias"+calles+"x"+avenidas;// Lo utilizamos para el archivo de pruebas
	}

	public void FuerzaBruta() 
	{
		Resultado res = null;
		int casoMayor = 0;
		int dia = 0;
		for (Distrito distrito : distritos) 
		{
			for(int i=0; i < distrito.numeroDias(); i++)
			{ /*  // La primera condición es para evitar el arrayoutbound
				// Como sabemos que es una curva, no hace falta comparar todos los valores con todos
				// Basta con comprar el valor actual con el siguiente, al ser ascendente
				// si es valor actual es mayor que el siguiente, se sabrá que ese es el pico
				if(i == distrito.numeroDias()-1)
				{
					casoMayor = distrito.get(i);
					dia = i;
					break;
				}
				if(distrito.get(i) > distrito.get(i+1)) 
				{
					casoMayor = distrito.get(i);
					dia = i;
					break;
				}*/
				if(distrito.get(i) > casoMayor) // O(n) 
				{
					casoMayor = distrito.get(i);
					dia = i;
				}
				//(d((31,1),3,120), (d((1,1),4,63), (d((11,1),4,63), (d((21,1),4,69), (d((41,1),4,630)
			}
			res= new Resultado(distrito, dia+1, casoMayor);
			resultados.add(res);
		}
		Collections.sort(resultados);
	}


	/*public void DyV() {
		resultados = new ArrayList<Resultado>();
		for (Distrito distrito : distritos) {
			pos= DyV(d.getArray(),O,d.getArray().length);
			Yres= new Y(d.getNombre(), pos+1, d.getArray[pos]);
			resultado.add(res);
		}
	}*/

	// Con el DyV debemos encontrar el n� maximo de casos de cada distrito en el array de casos.
	// Creo que deber�a ir en Distrito.
	@SuppressWarnings("unused")
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

	// M�s optimizado
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
			return mitad; //Peque�a opt, ? caso base?
		}
		
		if(listaDias[mitad-1] > listaDias[mitad]) { // Caso recursivo izquierda
			return DyVMejorado(listaDias,inicio, mitad-1);
		}
		return DyVMejorado(listaDias,mitad+1, fin); // Caso recursivo derecha
	}

	String getResultados()
	{
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
	
	public int getCalles() {
		return calles;
	}

	public int getAvenidas() {
		return avenidas;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public int getD1() {
		return d1;
	}

	public int getD2() {
		return d2;
	}
}
