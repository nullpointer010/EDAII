package org.EDAII.practica2;

public class Distrito {
	
	private int avenida;
	private int calle;
	private String nombre;

	// Llamamemos a esto lista casos
	private int [] listaCasos; // En la practica dice que lo analizamos para 1 a�o (365 dias)

	/*** Vamos a plantearlo de la siguiente forma:
	    La posici�n del array (i+1) (listaCasos.indexOf) nos indicar� el n�mero del d�a y el dato correspondiente a esa posici�n
	    nos indicar� los casos de ese d�a. 
		Los d�as van de 0 a X que es menor o igual a 365.
		As� evitaremos guardarlo en la variable.
	***/
	public Distrito(String nombre, int avenida, int calle, int dias) 
	{
		this.calle = calle;
		this.avenida = avenida;
		this.nombre = nombre;
		this.listaCasos = new int[dias];
	}
	
	public void rellenarCasos(String[] stringCasos)
	{
		for(int i = 0;i < stringCasos.length;i++)
		{
		    try
		    {
		    	String [] casoDia = stringCasos[i].split(",");
		    	int dia = Integer.parseInt(casoDia[0]);
		    	int casos = Integer.parseInt(casoDia[1]);
		    	listaCasos[dia-1] = casos;
		    }
		    catch (NumberFormatException nfe)
		    {
		        //No hacer nada si esta mal, se represantara con 0 el dia
		    }
		}
	}
	
	public void set(int value, int index)
	{
		listaCasos[index] = value;
	}
	
	public int get(int index)
	{
		return listaCasos[index];
	}
	
	public int numeroDias() 
	{
		return listaCasos.length-1;
	}
	
	public int[] getDistrito() 
	{
		int[] distrito = new int[2];
		distrito[0] = avenida; // d1
		distrito[1] = calle; // d2
		return distrito; // Retorna el d1 y d2 de cada distrito
	}
	
	public String toString() {
		
		return "("+(this.avenida)+","+(this.calle)+")";
		
	}
	
	public String stringDistritos() 
	{
		String a = nombre + " ";
		String b = "";
		
		for(int i = 0; i < listaCasos.length; i++) 
		{
			if(i != 0)
				b = ";"+(i+1)+","+listaCasos[i];
			else
				b = (i+1)+","+listaCasos[i];
			a += b;
		}
		return a;		
	}
	
	public int[] getListaCasos()
	{
		return listaCasos;
	}
}
