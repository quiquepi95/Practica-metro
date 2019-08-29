package metro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Metodos {

	public void inicializarArrayList(String ruta,ArrayList<String> arrayList) throws IOException {
		
		BufferedReader buffer = new BufferedReader(new FileReader(ruta)); // Creamos un buffer del contenido de los archivos
		
		String linea = buffer.readLine();		// Leo la primera línea y si no es igual a null entro en el bucle
		
		while(linea != null) { 					// mientras estoy en el bucle relleno el arrayList hasta que linea sea igual a null
			arrayList.add(linea);
			linea = buffer.readLine();
		}
		
		buffer.close();							// Cierro el buffer del fichero que hemos accedido para evitar consumir más recursos de los deseados
	}
	
	public void mostrarArrayList(ArrayList<String> arrayList) {
		
		Iterator<String> it = arrayList.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	public void inicializarArrayNombres() throws IOException {
		
		Iterator<String> it = Inicializacion.nombreParadas.iterator();
		
		for(int i = 0; i < Inicializacion.numEstaciones; i++) {
			if(it.hasNext()) {
				String nombre = it.next();
				Inicializacion.nombreEstaciones[i] = nombre;
			}
			
		}
	}
	
	
	public void mostrarArrayNombres() {
		
		for(int i = 0; i < Inicializacion.numEstaciones; i++) {
			System.out.println("Estación: " + Inicializacion.nombreEstaciones[i]);
		}
	}
	
	public void inicializarMatrizEstacion() throws IOException {
		
		for(int i = 0; i < Inicializacion.numEstaciones; i++) {
			Inicializacion.estacionOcupada[i][1] = 99; // Iniciamos a 99 porque no hay ninguna estación ocupada
		}
		
		for(int i = 0; i < Inicializacion.numEstaciones; i++) {
			Inicializacion.estacionOcupada[i][0] = i; // Iniciamos el nº de estación que es
		}
	}
	
	
}
