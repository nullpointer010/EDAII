package org.EDAII.practica1;

public class Resultado implements Comparable<Resultado> 
{	
	//private int calle;
	//private int avenida;
	Distrito distrito;
	private int dia;
	private int valor;
	
	public Resultado(Distrito distrito, int dia, int valor){
		
	}
	
	public String toString() {
		return null;
		
	}
	
	@Override
    public int compareTo(Resultado other)
    {
        return Integer.compare(this.dia, other.dia);
    }

}
