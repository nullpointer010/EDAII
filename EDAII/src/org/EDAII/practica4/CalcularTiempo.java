package org.EDAII.practica4;


public class CalcularTiempo 
{
	private Backtracking ciudad;
	//private long tiempoGreedy;
	private long tiempoBacktracking;

	public CalcularTiempo (Backtracking c) 
	{
		this.ciudad = c;
	}

	public void ejecutarTiempoBacktracking() 
	{
		long tI;
		int nExperimentos = 5; // Numero de veces lanzadas para hacer media
		
		tI = tiempoBacktracking = 0;

		for (int i=0; i<nExperimentos; i++) 
		{
			tI = System.nanoTime();
			ciudad.backtracking();
			tiempoBacktracking += System.nanoTime() - tI;
		}
		
		System.out.println("Tiempo medio de ejecutar BackTracking: " + tiempoBacktracking/nExperimentos/1e6 + " ms");
	}
	
}
