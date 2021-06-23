package org.EDAII.practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ciudad {

	private ArrayList<Distrito> L1;
	private ArrayList<Distrito> L2;
	private ArrayList<Distrito> L3;
	private ArrayList<Distrito> result;
	private int P;
	
	public Ciudad(String archivo) {
		L1 = new ArrayList<Distrito>();
		L2 = new ArrayList<Distrito>();
		L3 = new ArrayList<Distrito>();
		loadFile(archivo);
	}

	private void loadFile(String archivo) {
//		L1.add(new Distrito(1,1,5,600));
//		L1.add(new Distrito(1,2,10,2000));
//		L1.add(new Distrito(1,3,7,500));
//		L1.add(new Distrito(1,3,8,1000));
//		L2.add(new Distrito(2,1,1,200));
//		L2.add(new Distrito(2,2,2,100));
//		L2.add(new Distrito(2,3,1,500));
//		L2.add(new Distrito(2,3,8,1000));
//		L3.add(new Distrito(3,3,8,500));
//		L3.add(new Distrito(3,2,5,1000));
//		L3.add(new Distrito(3,4,6,10000));
//		L3.add(new Distrito(3,7,3,300));
		File f=new File(archivo);
		if(!f.exists()) throw new RuntimeException("No existe el archivo");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String[] tokens = sc.nextLine().trim().split(" # ");
				String[] tokens2 = tokens[0].trim().split(",");
				
				int avenida = Integer.parseInt(tokens2[0]);
				int calle = Integer.parseInt(tokens2[1]);
				int poblacion = Integer.parseInt(tokens[1]);
				
				tokens2 = tokens[2].split(",");
				
				double cont14 = 0;
				for (int i = 0; i < 14; i++) {
					cont14 += Integer.parseInt(tokens2[i]);
				}
				
				double cont7=0;
				for (int i = 14; i < 21; i++) {
					cont7 += Integer.parseInt(tokens2[i]);
				}
				
				double cont21=0;
				for (int i = 21; i < tokens2.length; i++) {
					cont21 += Integer.parseInt(tokens2[i]);
				}
				
				double r14 = (cont7+cont21)/cont14;
				double r7= cont7/cont21;
				
				double contagios = (2/r7+r14) * poblacion;
				int sanitarios = 5 + (poblacion > 5000 ? (int) (Math.ceil((poblacion-5000)/1000.0)) : 0);
				
				Distrito d = new Distrito(avenida, calle, sanitarios, contagios);
				
				if(r7 > 1 && r14 > 1){
					L1.add(d);
				}
				else if (r7 > 1){
					L2.add(d);
				}
				else if(r14 > 1){
					L3.add(d);
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {

		}
		

	}

	public void ProgramacionDinamica() {
		this.result = new ArrayList<Distrito>();
		int libres = mochila(L1, P, result);
		libres = mochila(L2, libres, result);
		libres = mochila(L3, libres, result);
		
		
	}

	private int mochila(ArrayList<Distrito> L, int P, ArrayList<Distrito> result) {
		if(P==0) {
			return 0;
		}
		double[][] B = new double[L.size()+1][P+1];
		for (int i = 1; i < B.length; i++) {
			for (int j = 0; j < L.get(i-1).getSanitarios(); j++) {
				B[i][j] = B[i-1][j];
			}
			for (int j = L.get(i-1).getSanitarios(); j < B[0].length; j++) {
				B[i][j] = Math.max(B[i-1][j], B[i-1][j-L.get(i-1).getSanitarios()] + L.get(i-1).getContagios());
			}
		}
		int pesoLibre = P;
		int j = B[0].length-1;
		for (int i = B.length-1; i > 0; i--) {
			if(B[i][j] != B[i-1][j]) {
				result.add(L.get(i-1));
				j -= L.get(i-1).getSanitarios();
				pesoLibre=L.get(i-1).getSanitarios();
			}
		
		}
		return pesoLibre;
	}

	public ArrayList<Distrito> getResult() {
		return result;
	}

	public void setP(int p) {
		P = p;
	}
}

