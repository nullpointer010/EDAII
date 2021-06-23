package org.EDAII.practica1;

public class CalcularTiempo 
{
	private Ciudad ciudad;
	//private long tiempoGreedy;
	private long tiempoDyV;
	private long tiempoFuerzaBruta;

	public CalcularTiempo (Ciudad c) 
	{
		this.ciudad = c;
	}

	public void ejecutarTiempoDyV() 
	{
		long tI;
		int nExperimentos = 5; // Numero de veces lanzadas para hacer media
		
		tI = tiempoDyV = 0;

		for (int i=0; i<nExperimentos; i++) 
		{
			tI = System.nanoTime();
			ciudad.DyVMejorado();
			tiempoDyV += System.nanoTime() - tI;
		}
		
		System.out.println("Tiempo medio de ejecutarDyV<T>: " + tiempoDyV/nExperimentos/1e6 + " ms");
	}
	
	public void ejecutarTiempoFuerzaBruta() 
	{
		long tI;
		int nExperimentos = 5; // Numero de veces lanzadas para hacer media
		
		tI = tiempoFuerzaBruta = 0;
		
		for (int i=0; i<nExperimentos; i++) 
		{
			tI = System.nanoTime();
			ciudad.FuerzaBruta();
			tiempoFuerzaBruta += System.nanoTime() - tI;
		}
		
		System.out.println("Tiempo medio de ejecutarFuerzaBruta<T>: " + tiempoFuerzaBruta/nExperimentos/1e6 + " ms");
	}
}
