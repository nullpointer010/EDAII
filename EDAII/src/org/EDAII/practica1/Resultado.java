package org.EDAII.practica1;
import java.lang.Comparable;

public class Resultado implements Comparable<Resultado> 
{	
	//private int calle;
	//private int avenida;
	Distrito distrito;
	private int dia;
	private int valor;
	
	public Resultado(Distrito distrito, int dia, int valor){
		
		super();
		this.distrito = distrito;
		this.dia = dia;
		this.valor = valor;
		
	}
	
	public String toString() {
		
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
		
        return Integer.compare(this.dia, other.dia);
        
    }

}
