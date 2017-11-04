package generadorDeSolidesDeMapas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Generador {

	public static void main(String[] args) {
		
		
		String path = "Aubenor.txt";
		int alto;
		int ancho;
		int matMapa[][];
        boolean[][] solidezMat = {
                {
                    true, true, false, true, false, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, false, false, false, false, false, false, false, true, true },
                {
                    false, false, false, false, false, false, false, false, true, true },
                {
                    false, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true },
                {
                    true, true, true, true, true, true, true, true, true, true } };
		
        int num;
        int jmenos1;
        int xmas1;
		
        try {
        	Scanner sc = new Scanner(new File(path));
            //String linea;
            
            PrintWriter salida = new PrintWriter(new FileWriter("mapaSolides.txt")); 
/*
            while ((linea = br.readLine()) != null) {
                builder.append(linea + System.lineSeparator());
            }
*/
            alto = sc.nextInt();
            ancho = sc.nextInt();
            
            matMapa = new int[alto][ancho];
            
            System.out.println((int) 15 /10);
            System.out.println(15%10);
            System.out.println( solidezMat[4][1] == true ? 1 : 0  );
            
            sc.nextInt();
            sc.nextInt();
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                	matMapa[i][j] = sc.nextInt();
    			}
			}
            
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                	
                	if( i != 0 && i != 0 ){
                    	num = matMapa[i][j] - 1;
                    	//jmenos1 = (int) (matMapa[i][j-1]/10) - 1;
                    	//xmas1 = (int) (matMapa[i-1][j]/10) - 1;
                		
	    				salida.print(  solidezMat[(int) num /10 ][num%10] == true  
	    							|| solidezMat[ (int) ( (matMapa[i - 1][j    ] - 1) /10 )][  (matMapa[i - 1][j    ] - 1) % 10    ] == true
	    							|| solidezMat[ (int) ( (matMapa[i - 1][j - 1] - 1) /10 )][  (matMapa[i - 1][j - 1] - 1) % 10    ] == true
	    							|| solidezMat[ (int) ( (matMapa[i    ][j    ] - 1) /10 )][  (matMapa[i    ][j - 1] - 1) % 10    ] == true ? 1 : 0  );
                	}
                	else
                	{
                		salida.print(1);
                	}
    				salida.print(" ");
    			}
                salida.println(" ");
			}
            
            
            sc.close();
            salida.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fallo al intentar cargar el mapa " + path);
        }
		
		
		
		

	}

}
