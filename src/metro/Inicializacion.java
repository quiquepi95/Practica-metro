package metro;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

class Inicializacion {
	
	
	public static int numEstaciones;
	public static int numTrenes;
	public static int vueltas;
	public static final int paradasL3 = 18;
	// public static final int minNumEstaciones = 12;
	
	public static Semaphore[] smfEstaciones;
	public static Semaphore smfTren = new Semaphore(0);
	public static Semaphore mutex= new Semaphore (1);
	
	public static final String RutaNombreParadas = "G:"+File.separator+"PROYECTOS"+File.separator+"PSP"+File.separator+"Semaforos-Metro"+File.separator+"src"+File.separator+"L3.txt";		//Ruta del archivo donde se encuentran los nombres de las estaciones
	public static ArrayList<String> nombreParadas = new ArrayList<String>(); // Creo un array con los nombres de las paradas
	public static String[] nombreEstaciones;
	
	
	public static int[][] estacionOcupada; // En la primera columna se indicará el nº de estación que es, en la segunda si está ocupada(poner nº tren) o no (poner 99)
	
	public static final int columnas = 2;
	public static Random aleatorio = new Random();
	
}
