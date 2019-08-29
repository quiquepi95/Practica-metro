package metro;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;



public class Main {
	
	private static Trenes a_trenes[];
	

	public static void main(String[] args) {

		Metodos m = new Metodos(); 	// Clase m�todos
		
		
		/*									*
		 * INICIALIZACI�N DE LAS ESTACIONES	*
		 *									*/
		
		/*do {
			
			try {
				Inicializacion.numEstaciones = Integer.parseInt(JOptionPane.showInputDialog("Introduce n� de estaciones (m�n 12 " + Inicializacion.minNumEstaciones + " y m�x " + Inicializacion.paradasL3 + "): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un n�mero entero.");
			}
			
		} while(Inicializacion.numEstaciones < Inicializacion.minNumEstaciones || Inicializacion.numEstaciones > Inicializacion.paradasL3);
		*/
		Inicializacion.numEstaciones = Inicializacion.paradasL3;
		
		System.out.print("El n�mero de estaciones introducidas es: " + Inicializacion.numEstaciones + "\n\n\n");
		
		Inicializacion.nombreEstaciones = new String[Inicializacion.numEstaciones];
		
		try {
			m.inicializarArrayList(Inicializacion.RutaNombreParadas, Inicializacion.nombreParadas);
			m.mostrarArrayList(Inicializacion.nombreParadas);
			
			System.out.print("\n\n\n");
			m.inicializarArrayNombres();
			m.mostrarArrayNombres();
			
		} catch (IOException e) {
			System.out.println("El archivo no est� disponible.");
		}
		
		/*								*
		 * INICIALIZACI�N DE LOS TRENES	*
		 *								*/
		
		do {
			
			try {
				Inicializacion.numTrenes = Integer.parseInt(JOptionPane.showInputDialog("Introduce n� de trenes (m�n 3 y m�x 10): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un n�mero entero.");
			}
			
		} while(Inicializacion.numTrenes < 3 || Inicializacion.numTrenes > 10);
		
		
		
		System.out.println("El n�mero de trenes es de: " + Inicializacion.numTrenes);
		
		/*														*
		 * INICIALIZACI�N DE LAS VUELTAS QUE DAR�N LOS TRENES	*
		 *														*/
		
		do {
			
			try {
				Inicializacion.vueltas = Integer.parseInt(JOptionPane.showInputDialog("Introduce n� de vueltas(m�n 1 y m�x 10): "));
			} catch (NumberFormatException e) {
				System.err.println("Debes introducir un n�mero entero.");
			}
			
		} while(Inicializacion.vueltas < 1 || Inicializacion.vueltas > 10);
		
		
		System.out.println("El n�mero de vueltas es de: " + Inicializacion.vueltas + "\n\nEmpezando a pasar trenes.\n\n\n");
		
		try {
			Inicializacion.estacionOcupada = new int[Inicializacion.numEstaciones][Inicializacion.columnas];
			m.inicializarMatrizEstacion();
			
		} catch (IOException e) {
			System.out.println("Error en la inicializaci�n de la matriz.");
		}
		
		
		Inicializacion.smfEstaciones = new Semaphore[Inicializacion.numEstaciones];
		
		for(int i = 0; i < (Inicializacion.numEstaciones-1); i++) Inicializacion.smfEstaciones[i] = new Semaphore(1); 
		// Inicializo a 1 todos menos el ultimo que es a cero
		// porque se me va a poner a 1 cuando el primer tren llegue a la primera estacion
		
		Inicializacion.smfEstaciones[Inicializacion.numEstaciones-1] = new Semaphore(0);
		
		System.out.println("Inicializados los sem�foros.");
		
		
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
