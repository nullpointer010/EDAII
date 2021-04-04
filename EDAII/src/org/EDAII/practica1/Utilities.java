package org.EDAII.practica1;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
public class Utilities {
	
	Scanner sc = new Scanner(nombreArchivo);
	
	public static void main(String[] args) {
		
	}

	private void weidbull(double b, double t, double d, double x) {
		
	}
	
	/*
	 *  public static float weibull(float alfa, float beta){ //un método que genera un número que distribuye weibull, pero no una curva.
		float u = (float) Math.random();
		float x = (float) Math.pow(-Math.log(u)*Math.pow(beta, alfa), 1/alfa);
		return x;
	}
	 */
	
	
	private void weibull(double a, double t, double x) { //este método aplica la función de densidad para una x que distribuye weibull

		//a = parametro de forma, α
		//t = parámetro de escala, λ 

		/* Un valor α < 1 indica que la tasa de fallos decrece con el tiempo.
           Cuando  α = 1 , la tasa de fallos es constante en el tiempo.
           Un valor α > 1 indica que la tasa de fallos crece con el tiempo. */

		double a1 = a;
		double t1 = t;
		double x1 = x; //eje de abscisas
		double e = Math.E;
		double funcionDensidad; 


		//funcionDensidad = (t1*a1) * (Math.pow((t1*x1), a1-1)) * Math.pow(e,(Math.pow(-(t1*x1),t1)));


		double [] curva = new double[(int)x]; //array donde se guardan los resultados de dicha función, lo que en una gráfica serían los valores de y

		for (double i = 1; i<=(x1); i++) {

			funcionDensidad = (t1*a1) * (Math.pow((t1*i), a1-1)) * Math.pow(e,(Math.pow(-(t1*i),t1)));
			curva[(int)i-1] = funcionDensidad;
		}
	}
	
	Ciudad generarCiudad(archivo archivo) {
		int avenidas = leer("Introduce el minimo de avenidad", 2, Integer.MAX_VALUE);
		int calles = leer("Introduce el minimo de avenidad", 2, Integer.MAX_VALUE);
		int d1 = leer("Introduce el minimo de avenidad", 2, Integer.MAX_VALUE);
		int d2 = leer("Introduce el minimo de avenidad", 2, Integer.MAX_VALUE);
		System.out.println("CASOS");
		System.out.println("Caso 1: Mejor caso");
		
		int caso = leer("Introduzca caso",1,5);
		System.out.println("Nombre");
		String nombreArchivo = sc.nextLine();
		
	}
	
	public void rellenar(Distrito d, int dia, int caso) {
		
		switch (caso) {
		case 1:
			
			break;

		default:
			break;
		}
	}
}
