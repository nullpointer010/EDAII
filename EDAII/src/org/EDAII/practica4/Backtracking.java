package org.EDAII.practica4;

import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {
	
	private static ArrayList<Distrito> L1;
	private static int P;

	public static void main(String[] args) {
		L1 = new ArrayList<Distrito>();
		L1.add(new Distrito(76, 138000));
		L1.add(new Distrito(44, 142000));
		L1.add(new Distrito(32, 106000));
		L1.add(new Distrito(9, 84500));
		P = 120;
		L1.sort(null);
		Resultado s = backtracking();
		System.out.println("=============================");
		System.out.println(s);

	}

	//array enteros
	//int[] a {nivel, voa, pact, bact}
	//           0     1     2     3
	private static Resultado backtracking() {
		int[] a = {0, Integer.MAX_VALUE, 0, 0};
		int[] s = new int[L1.size()];
		Arrays.fill(s, -1);
		Resultado soa = new Resultado();
		while (a[0] > -1) {
			Generar(a, s);
			if(Solucion(a, s)) {
				a[1] = a[3];
				soa.clear();
				for (int i = 0; i < s.length; i++) {
					if(s[i]==1) {
						soa.add(L1.get(i));
					}
				}
			}
			if(Criterio(a,s)) {
				a[0]++;
			}else {
				while(a[0]>-1 && !MasHermanos(a,s)) {
					Retroceder(a,s);
				}
			}
		}
		
		return soa;
	}

	private static void Generar(int[] a, int[] s) {
		s[a[0]]++;
		if(s[a[0]] == 1) {
			a[2] += L1.get(a[0]).peso;
			a[3] += L1.get(a[0]).valor;
		}
	}

	private static boolean Solucion(int[] a, int[] s) {
		if(a[0] == L1.size()-1) {
			imprimirRama(s);
			if(a[2] >= P && a[3] < a[1]) {
				System.out.println(" => NUEVA");
			}else {
				System.out.println(" => X");
			}
		}
		return a[0] == L1.size()-1 && a[2] >= P && a[3] < a[1];
	}

	private static boolean Criterio(int[] a, int[] s) {
		if(a[0] < L1.size()-1 && a[3] > a[1]) {
			imprimirRama(s);
			System.out.println();
		}
		return a[0] < L1.size()-1 && a[3] <= a[1];
	}

	private static boolean MasHermanos(int[] a, int[] s) {
		return s[a[0]] < 1;
	}

	private static void Retroceder(int[] a, int[] s) {
		if(s[a[0]] == 1) {
			a[2] -= L1.get(a[0]).peso;
			a[3] -= L1.get(a[0]).valor;
		}
		s[a[0]] = -1;
		a[0]--;
	}

	private static void imprimirRama(int[] s) {
		int peso = 0;
		int valor = 0;
		for (int i = 0; i < s.length; i++) {
			if(s[i]==1) {
				peso+=L1.get(i).peso;
				valor+=L1.get(i).valor;
			}else if(s[i]==-1) {
				System.out.print("-> (PODA)");
				break;
			}
			System.out.print((i==0?"":"->")+L1.get(i).id+": "+"(P: "+peso+", B:  "+valor+")");
		}
		
	}
	
	

}
