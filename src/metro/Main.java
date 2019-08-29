package metro;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;



public class Main {
	
	private static Trenes a_trenes[];
	

	public static void main(String[] args) {

		Metodos m = new Metodos(); 	// Clase métodos
		
		
		/*									*
		 * INICIALIZACIÓN DE LAS ESTACIONES	*
		 *									*/
		
		/*do {
			
			try {
				Inicializacion.numEstaciones = Integer.parseInt(JOptionPane.showInputDialog("Introduce nº de estaciones (mín 12 " + Inicializacion.minNumEstaciones + " y máx " + Inicializacion.paradasL3 + "): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un número entero.");
			}
			
		} while(Inicializacion.numEstaciones < Inicializacion.minNumEstaciones || Inicializacion.numEstaciones > Inicializacion.paradasL3);
		*/
		Inicializacion.numEstaciones = Inicializacion.paradasL3;
		
		System.out.print("El número de estaciones introducidas es: " + Inicializacion.numEstaciones + "\n\n\n");
		
		Inicializacion.nombreEstaciones = new String[Inicializacion.numEstaciones];
		
		try {
			m.inicializarArrayList(Inicializacion.RutaNombreParadas, Inicializacion.nombreParadas);
			m.mostrarArrayList(Inicializacion.nombreParadas);
			
			System.out.print("\n\n\n");
			m.inicializarArrayNombres();
			m.mostrarArrayNombres();
			
		} catch (IOException e) {
			System.out.println("El archivo no está disponible.");
		}
		
		/*								*
		 * INICIALIZACIÓN DE LOS TRENES	*
		 *								*/
		
		do {
			
			try {
				Inicializacion.numTrenes = Integer.parseInt(JOptionPane.showInputDialog("Introduce nº de trenes (mín 3 y máx 10): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un número entero.");
			}
			
		} while(Inicializacion.numTrenes < 3 || Inicializacion.numTrenes > 10);
		
		
		
		System.out.println("El número de trenes es de: " + Inicializacion.numTrenes);
		
		/*														*
		 * INICIALIZACIÓN DE LAS VUELTAS QUE DARÁN LOS TRENES	*
		 *														*/
		
		do {
			
			try {
				Inicializacion.vueltas = Integer.parseInt(JOptionPane.showInputDialog("Introduce nº de vueltas(mín 1 y máx 10): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un número entero.");
			}
			
		} while(Inicializacion.vueltas < 1 || Inicializacion.vueltas > 10);
		
		
		System.out.println("El número de vueltas es de: " + Inicializacion.vueltas + "\n\nEmpezando a pasar trenes.\n\n\n");
		
		try {
			Inicializacion.estacionOcupada = new int[Inicializacion.numEstaciones][Inicializacion.columnas];
			m.inicializarMatrizEstacion();
			
		} catch (IOException e) {
			System.out.println("Error en la inicialización de la matriz.");
		}
		
		
		Inicializacion.smfEstaciones = new Semaphore[Inicializacion.numEstaciones];
		
		for(int i = 0; i < (Inicializacion.numEstaciones-1); i++) Inicializacion.smfEstaciones[i] = new Semaphore(1); 
		// Inicializo a 1 todos menos el ultimo que es a cero
		// porque se me va a poner a 1 cuando el primer tren llegue a la primera estacion
		
		Inicializacion.smfEstaciones[Inicializacion.numEstaciones-1] = new Semaphore(0);
		
		System.out.println("Inicializados los semáforos.");
		
		
		a_trenes = new Trenes[Inicializacion.numTrenes];
			
		
		/*							*
		 * INICIANDO RED DE METRO	*
		 *							*/
		

		Ventana v = new Ventana("Red de metro"); // Clase ventana
		
		
		for (int j = 0; j < Inicializacion.numTrenes; j++) {
			a_trenes[j] = new Trenes(j,v,Inicializacion.vueltas);
			a_trenes[j].start();
			try {
				Thread.sleep(Inicializacion.aleatorio.nextInt(3000)+2500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
