package org.EDAII.practica3;

public class CalcularTiempo 
{
	private Ciudad ciudad;
	//private long tiempoGreedy;
	private long tiempoProgramacionDinamica;

	public CalcularTiempo (Ciudad c) 
	{
		this.ciudad = c;
	}

	public void ejecutarTiempoProgramacionDinamica() 
	{
		long tI;
		int nExperimentos = 5; // Numero de veces lanzadas para hacer media
		
		tI = tiempoProgramacionDinamica = 0;

		for (int i=0; i<nExperimentos; i++) 
		{
			tI = System.nanoTime();
			ciudad.ProgramacionDinamica();
		}
		
		System.out.println("Tiempo medio de ejecutar ProgramacionDinamica: " + tiempoProgramacionDinamica/nExperimentos/1e6 + " ms");
	}
	
}
