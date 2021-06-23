package org.EDAII.practica2;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Main {
	
	private static String directorioPruebas = System.getProperty("user.dir")
			+File.separator+ "src"
			+File.separator+ "org"
			+File.separator+ "EDAII"
			+File.separator+ "practica2Pruebas"
			+File.separator;
	
	private static String directorioResultados = System.getProperty("user.dir")
			+File.separator+ "src"
			+File.separator+ "org"
			+File.separator+ "EDAII"
			+File.separator+ "practica2PruebasResultados"
			+File.separator;
	
	private static Scanner sc = new Scanner(System.in);
	private static Ciudad c;
	

	public static void main(String[] args) throws IOException {
		boolean repetir = true;
		int opcion;
		/**
		 * IGNORAR ESTAS DOS LINEAS. NO SE LANZABA EL DIALOGO PARA SELECCIONAR EL ARCHIVO
		 * YA QUE SCANNER LO BLOQUEA AUNQUE SE CIERRE ANTES CON .close()
		 * ESTA ES UNA SOLUCION SIMPLE; QUE ES CREAR UNA INSTANCIA ANTES
		 */
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));

		while(repetir) 
		{
			menu();
			opcion = leer("Seleccione una opción", 1,6);
			repetir = ejecutar(opcion);
			
			elegirAlgoritmo();
			
			
			System.out.println("╔═════════════════════════════╗");
			System.out.println("║            MENU             ║");
			System.out.println("╠═════════════════════════════╣");
			System.out.println("║ 1. Mostrar resultados       ║");
			System.out.println("║ 2. Rendimiento              ║");
			System.out.println("║ 3. Salir                    ║");
			System.out.println("╚═════════════════════════════╝");
			opcion = leer("Seleccione una opción", 1,3);
			ejecutar2(opcion);
			
			repetir = false;
		}
	}
	
	private static void menu()
	{
		System.out.println("╔═════════════════════════════╗");
		System.out.println("║            MENU             ║");
		System.out.println("╠═════════════════════════════╣");
		System.out.println("║ 1. Cargar ciudad            ║");
		System.out.println("║ 2. Generar ciudad           ║");
		System.out.println("║ 3. Salir                    ║");
		System.out.println("╚═════════════════════════════╝");
	}
	
	public static int leer(String mensaje, int min, int max)
	{
		System.out.println(mensaje);
		int opcion = sc.nextInt();
		return opcion;
	}
	
	private static boolean ejecutar(int opcion) 
	{	
		boolean repetir = true;
		switch (opcion) 
		{
		case 1:
			cargarCiudad();
			break;
		case 2:
			generarCiudad();
			break;
		case 3:
			repetir = false;
			break;
		default: 
			System.out.println("Programa finalizado");
			return false;
		}
		return repetir;
	}
	
	private static boolean ejecutar2(int opcion) 
	{	
		boolean repetir = true;
		switch (opcion) 
		{
		case 1:
			try {
				mostrarResultado();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			rendimiento();
			break;
		default: 
			System.out.println("Programa finalizado");
			return false;
		}
		return repetir;
	}

	private static void rendimiento()
	{
		CalcularTiempo rendimiento = new CalcularTiempo(c);
		rendimiento.ejecutarTiempoDyV();
		rendimiento.ejecutarTiempoFuerzaBruta();
	}

	private static void generarCiudad() {
		int avenidas = leer("Introduce el número de avenidas:", 2, Integer.MAX_VALUE);
		int calles = leer("Introduce el número de calles:", 2, Integer.MAX_VALUE);
		int d1 = leer("Introduce el número de avenidas correspondientes a un distrito:", 2, Integer.MAX_VALUE);
		int d2 = leer("Introduce el número de calles correspondientes a un distrito:", 2, Integer.MAX_VALUE);
		int dias = leer("Introduce el número de dias sobre los que generar los datos:", 2, Integer.MAX_VALUE);
		
		System.out.println("CASOS:");
		System.out.println("╔═════════════════════════════════════╗");
		System.out.println("║                 CASOS               ║");
		System.out.println("╠═════════════════════════════════════╣");
		System.out.println("║ 1. Ascendente-Descendente Weidbull  ║");
		System.out.println("║ 2. Ascendente Weidbull              ║");
		System.out.println("║ 3. Descendente Weidbull             ║");
		System.out.println("║ 4. Acendente-Descendente lineal     ║");
		System.out.println("║ 5. Acendente lineal                 ║");
		System.out.println("║ 6. Descendente lineal               ║");
		System.out.println("║ 7. Random Weidbull                  ║");
		System.out.println("║ 8. Valor constante                  ║");
		System.out.println("╚═════════════════════════════════════╝");

		int caso = leer("Introduzca caso",1,8);
		
		c = new Ciudad(avenidas,calles,d1,d2,dias,caso);
		
	}

	private static void mostrarResultado() throws FileNotFoundException 
	{
		if (c == null) 
		{
			System.out.println("Primero hay que cargar los datos");
			return;
		}
		try 
		{
			System.out.println(c.getResultados());
			int opcion = leer("¿Desea guardar los resultados?: \n1. SI\n2. NO", 1,2);
			if(opcion == 1) 
			{
				File file = null;
				PrintWriter pw;
				String name = c.toString();
				file = new File(directorioResultados + File.separator + name + ".txt");
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e) {
					throw new FileNotFoundException(e.getMessage());
				}

				pw.println("@Ciudad");
				pw.println("n="+ c.getAvenidas());
				pw.println("m="+ c.getCalles());
				pw.println("@Datos");
				pw.println("d1="+ c.getD1());
				pw.println("d2="+ c.getD2());
				pw.println("dn="+ c.getNumeroDias());
				pw.println("@Distritos");
				
				for(Distrito d : c.getDistritos()) 
				{
					pw.println(d.stringDistritos());
				}
				pw.println("@Resultados");
				pw.println(c.getResultados());

				pw.close();
				System.out.println("Se ha generado el archivo.");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void elegirAlgoritmo() 
	{	
		if (c == null) 
		{
			System.out.println("Primero hay que cargar los datos");
			return;
		}
		System.out.println("╔═════════════════════════════╗");
		System.out.println("║       ALGORITMOS            ║");
		System.out.println("╠═════════════════════════════╣");
		System.out.println("║ 1. Fuerza Bruta             ║");
		System.out.println("║ 2. Divide y vencerás        ║");
		System.out.println("║ 3. Greedy (A)               ║");
		System.out.println("║ 4. GreedySuavizar (B)       ║");
		System.out.println("║ 5. Volver                   ║");
		System.out.println("╚═════════════════════════════╝");
		
		int opcion = leer("Seleccione el algoritmo que quiere ejecutar:", 1, 3);
		switch (opcion) 
		{
			case 1:
				c.FuerzaBruta(); 
				break;
			case 2: 
				c.DyVMejorado(); 
				break;
			case 3: 
				c.Greedy(); 
				break;
			case 4: 
				c.GreedySuavizar(); 
				break;
			
			default: 
				break;
		}
	}

	private static void cargarCiudad() 
	{
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(directorioPruebas));
		jfc.setDialogTitle("Escoja el archivo que desee ");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = 0;
		try {
			returnValue = jfc.showOpenDialog(null);
		} catch(HeadlessException  e) {
			throw new HeadlessException(e.getMessage());
		}

		if (returnValue == JFileChooser.APPROVE_OPTION) 
		{
			if (jfc.getSelectedFile().isFile()) 
			{
				System.out.println("Has escogido el archivo con la siguiente ruta " + jfc.getSelectedFile());
				c = new Ciudad();
				c.cargarArchivo(jfc.getSelectedFile().toString());
				System.out.println("Se ha cargado correctamente la ciudad. Ahora ya puede elegir el resto de opciones");
			}
		}
	}
}	

