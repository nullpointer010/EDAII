package org.EDAII.practica3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


//import practica34.Sanitario;


public class Distrito {
	private int avenida;
	private int calle;
	private int sanitarios; //peso
	private double contagios; //valor
	public Distrito(int avenida, int calle, int sanitarios, double contagios) {
		this.avenida=avenida;
		this.calle=calle;
		this.sanitarios=sanitarios;
		this.contagios=contagios;//(2*)
	}


	
	@Override
	public String toString() {
		return "D(" + avenida + ","+ calle + ") => San: "+ sanitarios+ ", Contgs="+ contagios;		
	}



	public int getSanitarios() {
		return sanitarios;
	}



	public double getContagios() {
		return contagios;
	}


}
