package org.EDAII.practica1;

import java.util.Random;

public class Utilities {

	
	/*
	 *  public static float weibull(float alfa, float beta){ //un método que genera un número que distribuye weibull, pero no una curva.
		float u = (float) Math.random();
		float x = (float) Math.pow(-Math.log(u)*Math.pow(beta, alfa), 1/alfa);
		return x;
	}
	 */
	
	
	private static void weibull(double a, double t, double x) { //este método aplica la función de densidad para una x que distribuye weibull

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
	
	public static void caso1(Distrito d, int dias)
	{
		//Genera curva random suavizada
		/*Elige el dia en el que empieze a descender
		randomDia(1/3 a 2/3)


		casos de random(1 a 20)

		if(i >= randomDia)
			pos[i] = antiguo numero - casos random
			if[pos[i] < 0] pos[i] = 0;
		else
			pos[i] = antiguo numero + casos random

		antiguonumero = pos[i]*/
		
		int oldNum = 0;
		Random rand = new Random();
		double porcentajeRandom = (rand.nextInt(7 - 3 + 1) + 3)/10.0;

		int diaRandomPico = (int)(dias * porcentajeRandom);

		double multiplicador = 2.0 - porcentajeRandom;

		int casosDia = 0;
		
		for(int i = 0; i < dias; i++) 
		{
			casosDia = (int)((rand.nextInt(20 - 1 + 1) + 1) * multiplicador);
			if(i <= diaRandomPico)
			{
				casosDia += oldNum;
				d.set(casosDia, i);
			}else 
			{
				casosDia = oldNum - casosDia;
				if(casosDia < 0) casosDia = 0;
				d.set(casosDia, i);
			}
			oldNum = casosDia;
		}
	}
	
	public static void caso2(Distrito d, int dias)
	{
		int [] list = new int[dias];
	    double mean = 0.0;
	    double std = 1.0;
	    
	    Random rng = new Random();

	    for(int i = 0;i<list.length;i++) 
	    {
	      list[i] = (int)(mean + std * 
	    		  rng.nextGaussian());
	    }
	    for(int i = 0;i<list.length;i++) 
	    {
	            d.set(list[i], i); 
	    }
	}
	
	public static void caso3(Distrito d, int dias)
	{
		weibull(0, 1, dias);
	}
	
	public static void caso4(Distrito d, int dias)
	{
		for (int i = 0; i < dias; i++) {
			d.set(i, dias-i);
		}
	}
	
	public static void caso5(Distrito d, int dias)
	{
		for (int i = 0; i <= dias/2; i++) {
			d.set(i, dias);
		}
		for (int i = 0; i < dias/2; i++) {
			d.set(i, dias/2-1-i);
		}
	}	
    
    public static void rellenar(Distrito d, int dia, int caso) 
	{
		
		switch (caso) 
		{
		case 1: 
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			caso1(d, dia);
		break;
		default:
			System.out.println("El caso no es válido");
			break;
		}
	}
}
