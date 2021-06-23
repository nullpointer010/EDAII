package org.EDAII.practica4;

import java.util.ArrayList;

public class Resultado {
	
	private ArrayList<Distrito> resultado;
	private int peso;
	private int valor;
	
	public Resultado() {
		this.resultado = new ArrayList<Distrito>();
		this.peso = 0;
		this.valor = 0;
	}
	
	public void clear() {
		this.resultado.clear();
		this.peso = 0;
		this.valor = 0;
	}
	
	public void add(Distrito o) {
		this.resultado.add(o);
		this.peso += o.peso;
		this.valor += o.valor;
	}

	@Override
	public String toString() {
		return "Resultado (Peso="+this.peso+", Valor="+this.valor+") => "+this.resultado;
	}
	

}
