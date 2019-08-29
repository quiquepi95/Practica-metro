package metro;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Trenes extends Thread {
	int trenes;
	private Ventana objVentana;
	int vueltas;
	final int distancia = 60;
	ImageIcon icon;
	

	
	
	Trenes(int tren, Ventana ventana, int vueltas){
		this.trenes = tren;
		this.objVentana = ventana;
		this.vueltas = vueltas;
		this.setName("Tren " + tren);		
	} // fin Trenes
	
	
	void move(int estacion){		
		objVentana.labelImg[trenes].setVisible(true);
		Rectangle r = objVentana.labelImg[trenes].getBounds();
		Dimension dimensionR = r.getSize();
		int x = objVentana.labelImg[trenes].getX();
		
		
		while (x < objVentana.imagenesVerde[estacion].getX()-20) {
			objVentana.labelImg[trenes].setBounds(x, objVentana.y, dimensionR.width, dimensionR.height);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			x++;
		}
		
	}
	
	void moveFinal() {
		objVentana.labelImg[trenes].setVisible(true);
		Rectangle r = objVentana.labelImg[trenes].getBounds();
		Dimension dimensionR = r.getSize();
		int x = objVentana.labelImg[trenes].getX();
		
		while (x < objVentana.imagenesVerde[Inicializacion.numEstaciones-1].getX()+200) {
			objVentana.labelImg[trenes].setBounds(x, objVentana.y, dimensionR.width, dimensionR.height);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			x++;
		}
	}
	
	
	
	
	
	
	public void run() {
		
		
		try {
			
			
			System.out.println("soy el " + this.getName() +" entrando");
				
			do { // while vueltas
				
				// evitamos que dos procesos comprueben si la estación está vacía a la vez, ya que podría darse una falsa lectura
				Inicializacion.mutex.acquire(); // Disminuye 1 mutex
					
				System.out.println("Soy el " + this.getName() + " paso mutex");
				
				int empezar = 0;
				objVentana.labelImg[trenes].setVisible(false);
				Rectangle r = objVentana.labelImg[trenes].getBounds();
				Dimension dimensionR = r.getSize();
				objVentana.labelImg[trenes].setBounds(empezar, objVentana.y, dimensionR.width, dimensionR.height);
				
				
				for(int estacion = 0; estacion < Inicializacion.numEstaciones; estacion++) {
					boolean continuar = false;
						
					while(!continuar) {
						
						if(Inicializacion.estacionOcupada[estacion][1] == 99) {
							
							Thread.sleep(Inicializacion.aleatorio.nextInt(1800)+500);
							
							objVentana.imagenesRojo[estacion].setVisible(true);
							objVentana.imagenesVerde[estacion].setVisible(false);
								
							Inicializacion.smfEstaciones[estacion].acquire();
								
							Inicializacion.smfTren.release(); // +1. Activa mov tren
								
							System.out.println(this.getName() + " moviendose");
							
							
														
							if(estacion == 0) {
								move(estacion);
								Inicializacion.estacionOcupada[estacion][1] = trenes; // Pongo el valor a la estación con el nº de tren
								Inicializacion.estacionOcupada[Inicializacion.numEstaciones-1][1] = 99; // La estación anterior la vacío con 99
								Inicializacion.smfEstaciones[Inicializacion.numEstaciones-1].release(); // Activo el semáforo de la estación anterior
								objVentana.imagenesVerde[Inicializacion.numEstaciones-1].setVisible(true);
								objVentana.imagenesRojo[Inicializacion.numEstaciones-1].setVisible(false);
							} else {
								move(estacion);
								Inicializacion.estacionOcupada[estacion][1] = trenes; // Pongo el valor a la estación con el nº de tren
								Inicializacion.estacionOcupada[estacion-1][1] = 99; // La estación anterior la vacío con 99
								Inicializacion.smfEstaciones[estacion-1].release(); // Activo el semáforo de la estación anterior
								objVentana.imagenesVerde[estacion-1].setVisible(true);
								objVentana.imagenesRojo[estacion-1].setVisible(false);
							} // fin del if ver estaciones
								
								
							System.out.println("Soy " + this.getName() + " en la vuelta " + vueltas + " y estoy en la estación " + Inicializacion.nombreEstaciones[estacion]);
							
							Inicializacion.smfTren.acquire(); // -1. Desactiva mov tren
							System.out.println(this.getName() + " parado");
							
								
							Inicializacion.mutex.release(); // Aumenta 1 mutex
								
							continuar = true;
								
						} else {
							objVentana.imagenesRojo[estacion].setVisible(true);
							objVentana.imagenesVerde[estacion].setVisible(false);
							System.out.println("Esperando a que " + this.getName() + " tenga libre la estación: " + Inicializacion.nombreEstaciones[estacion]);
							continuar = false;
							
							Thread.sleep(Inicializacion.aleatorio.nextInt(1500)+1000);
						} // fin del if
						
					} // fin while
						
				} // fin for estaciones
				
				Thread.sleep(Inicializacion.aleatorio.nextInt(1800)+500);
				moveFinal();
				
				System.out.println("Soy " + this.getName() + " en la vuelta " + vueltas);
				
				vueltas--;
			} while(vueltas > 0);
			
			
			Thread.sleep(1000);
			objVentana.labelImg[trenes].setVisible(false);
			Inicializacion.estacionOcupada[Inicializacion.numEstaciones-1][1] = 99;
			objVentana.imagenesVerde[Inicializacion.numEstaciones-1].setVisible(true);
			objVentana.imagenesRojo[Inicializacion.numEstaciones-1].setVisible(false);
			System.out.println("\n\nSoy " + this.getName() + " en la vuelta " + vueltas + ". He acabado el recorrido");
			
			JOptionPane.showMessageDialog(null, "El " + this.getName() + " ha terminado de pasar","El programa ha terminado", JOptionPane.WARNING_MESSAGE);
			
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
