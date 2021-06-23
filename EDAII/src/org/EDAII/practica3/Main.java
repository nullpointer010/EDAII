package org.EDAII.practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
	
	public static void main(String[]args) {
		Ciudad c = new Ciudad("C:\\Users\\skip_\\git\\EDAII\\EDAII\\src\\org\\EDAII\\practica3\\datos.txt");
		c.setP(40);
		c.ProgramacionDinamica();
		System.out.println(c.getResult());
	}

}
