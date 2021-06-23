package org.EDAII.practica2;
import java.lang.Comparable;

public class Resultado implements Comparable<Resultado> 
{	
	Distrito distrito;
	private int dia;
	private int valor;
	
	public Resultado(Distrito distrito, int dia, int valor)
	{	
		this.distrito = distrito;
		this.dia = dia;
		this.valor = valor;	
	}
	
	public String toString() 
	{
		String cadena = "(d("+this.distrito.toString()+","+this.dia+","+this.valor+")";
		return cadena;	
	}
	
	@Override
    public int compareTo(Resultado other) {

		/* int aux=0;

		if (this.valor<other.dia){  
			aux = -1;      
		}else if (this.valor>other.dia) {   
			aux = 1;     
		} else {
			if (this.valor<other.dia) {  
				aux = -1;     
			}else if (this.valor>other.dia) { 
				aux = 1;   
			}else {  
				aux = 0;   
			}
		}
		return aux; */
		int aux = Integer.compare(this.dia, other.dia);
		if(aux == 0)
			aux = Integer.compare(this.valor, other.valor);
        return aux;
        
    }

}
