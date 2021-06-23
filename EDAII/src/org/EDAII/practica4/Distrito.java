package org.EDAII.practica4;

public class Distrito implements Comparable<Distrito>{
	int id;
	int peso;
	int valor;
	private static int idAI = 1;
	
	public Distrito(int peso, int valor) {
		this.id = idAI;
		this.peso = peso;
		this.valor = valor;
		idAI++;
	}

	@Override
	public String toString() {
		return "Objeto [id="+this.id+", peso=" + peso + ", valor=" + valor + "]";
	}

	@Override
	public int compareTo(Distrito o) {
		return Integer.compare(this.peso, o.peso);
	}
	
	
}