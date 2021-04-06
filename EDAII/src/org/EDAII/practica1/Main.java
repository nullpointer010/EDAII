package org.EDAII.practica1;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static String directorio = System.getProperty("user.dir")
			+File.separator+ "src"
			+File.separator+ "org"
			+File.separator+ "practica01"
			+File.separator;
			
	private static Scanner sc = new Scanner(System.in);
	private static Ciudad c;
	

	public static void main(String[] args) {
		boolean repetir = true;
		do {
			menu();
			int opcion = leer("Seleccione una opción", 1,6);
			repetir = ejecutar(opcion);
		} while (repetir);
		sc.close();

	}
	
	private static void menu() {
		System.out.println("╔═════════════════════════════╗");
		System.out.println("║            MENU             ║");
		System.out.println("╠═════════════════════════════╣");
		System.out.println("║ 1. Cargar ciudad            ║");
		System.out.println("║ 2. Elegir algoritmo         ║");
		System.out.println("║ 3. Mostrar resultado        ║");
		System.out.println("║ 4. Generar ciudad           ║");
		System.out.println("║ 5. Rendimiento              ║");
		System.out.println("║ 6. Salir                    ║");
		System.out.println("╚═════════════════════════════╝");
		
	}
	
	private static int leer(String mensaje, int min, int max){
		return 0;
		
	}
	
	private static boolean ejecutar(int opcion) {
		switch (opcion) {
		case 1:
			cargarCiudad();
			break;
		case 2:
			elegirAlgoritmo();
			break;
		case 3:
			mostrarResultado();
			break;
		case 4:
			generarCiudad();
			break;
		case 5:
			rendimiento();
			break;
		case 6:
			salir();
			break;
		default: System.out.println("Programa finalizado");
			return false;
		}
		return true;
	}
	

	private static void salir() {
		// TODO Auto-generated method stub
		
	}

	private static void rendimiento() {
		// TODO Auto-generated method stub
		
	}

	private static void generarCiudad() {
		int avenidas = leer("Introduce el número de avenidas:", 2, Integer.MAX_VALUE);
		int calles = leer("Introduce el número de calles:", 2, Integer.MAX_VALUE);
		int d1 = leer("Introduce el número de avenidas correspondientes a un distrito:", 2, Integer.MAX_VALUE);
		int d2 = leer("Introduce el número de calles correspondientes a un distrito:", 2, Integer.MAX_VALUE);
		int dias = leer("Introduce el número de dias sobre los que generar los datos:", 2, Integer.MAX_VALUE);
		
		System.out.println("CASOS:");
		System.out.println("1. Ascendente-Descendente Weidbull");
		System.out.println("2. Ascendente Weidbull");
		System.out.println("3. Descendente Weidbull");
		System.out.println("4. Acendente-Descendente lineal");
		System.out.println("5. Acendente lineal");
		System.out.println("6. Descendente lineal");
		System.out.println("7. Random Weidbull");
		System.out.println("8. Valor constante");
		
		int caso = leer("Introduzca caso",1,8);
		
		Ciudad c = new Ciudad(avenidas,calles,d1,d2,dias,caso);
		
	}

	private static void mostrarResultado() {
		if (c == null) {
			System.out.println("Primero hay que cargar los datos");
			return;
		}
		try {
			System.out.println(c.getResultados());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void elegirAlgoritmo() {
		
		if (c == null) {
			System.out.println("Primero hay que cargar los datos");
			return;
		}

		int opcion = leer("Seleccione el algoritmo que quiere ejecutar: \n1. Fuerza Bruta \2. Divide y Vencerás\n", 1, 2);
		switch (opcion) {
		case 1: c.FuerzaBruta(); break;
		case 2: c.DyV(); break;
		default: break;
		}
	}

	private static void cargarCiudad() {

			File[] files = new File(directorio+"practica1tests"+File.separator).listFiles(new FileFilter() {
				
				public boolean accept(File a) {
					return a.getName().endsWith(".txt");
				}
			});
			for (int i = 0; i < files.length; i++) {
				System.out.println((i+1)+". "+files[i].getName());
			}
			
			int opcion = leer("Seleccione el archivo a cargar", 1, files.length);

			try {
				c = new Ciudad (files[opcion-1].getAbsolutePath()); 
				System.out.println("Archivo \""+files[opcion-1].getName()+"\" cargado correctamente");

			} catch (FileNotFoundException e) { 
				System.out.println("No fue posible cargar el archivo");
			}

    	}
}	

