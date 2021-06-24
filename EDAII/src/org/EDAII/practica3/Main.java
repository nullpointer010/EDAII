package org.EDAII.practica3;

import org.EDAII.practica3.CalcularTiempo;

public class Main {
	
	public static void main(String[]args) {
		Ciudad c = new Ciudad("C:\\Users\\skip_\\git\\EDAII\\EDAII\\src\\org\\EDAII\\practica3\\datos2.txt");
		c.setP(40);
		c.ProgramacionDinamica();
		System.out.println(c.getResult());
		System.out.println("");
		CalcularTiempo t = new CalcularTiempo(c);
		CalcularTiempo rendimiento = new CalcularTiempo(c);
		rendimiento.ejecutarTiempoProgramacionDinamica();
	}

}
