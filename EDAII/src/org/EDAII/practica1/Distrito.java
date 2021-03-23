package org.EDAII.practica1;

import java.util.ArrayList;
import java.util.Arrays;

public class Distrito {
	
	private int avenida;
	private int calle;

	// Llamamemos a esto lista casos
	private ArrayList<Integer> listaCasos = new ArrayList<Integer>(365); // En la practica dice que lo analizamos para 1 año (365 dias)

	/*** Vamos a plantearlo de la siguiente forma:
	    La posición del array (i+1) (listaCasos.indexOf) nos indicará el número del día y el dato correspondiente a esa posición
	    nos indicará los casos de ese día. 
		Los días van de 0 a X que es menor o igual a 365.
		Así evitaremos guardarlo en la variable.
	***/
	public Distrito(int avenida, int calle) 
	{
		this.calle = calle;
		this.avenida = avenida;
		/*for(int i = 0; i < listaCasos.length; i++) {
			listaCasos[i] = -1;
		}*/
		//Arrays.fill(listaCasos, -1);
	}
	
	public void add(int valor)
	{
		listaCasos.add(valor);
	}
	
	public int get(int index)
	{
		return listaCasos.get(index);
	}
	
	public int numeroDias() 
	{
		return listaCasos.size();
	}
	
	public int[] getDistrito() 
	{
		int[] distrito = new int[2];
		distrito[0] = avenida; // d1
		distrito[1] = calle; // d2
		return distrito; // Retorna el d1 y d2 de cada distrito
	}
	
	public String toString() {
		return null;
		
	}

}
