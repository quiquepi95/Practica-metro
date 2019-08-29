package metro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Ventana extends JPanel{
	private JFrame ventana = new JFrame();
	
	private JTextField via1;
	private Container container;
	JLabel[] imagenesEstaciones;
	JLabel[] imagenesVerde;
	JLabel[] imagenesRojo;
	JLabel[] nombres;
	
	
	JLabel[] labelImg;
	ImageIcon[] imgTrenes;
	Icon[] iconoTrenes;
	
	
	
	
	private final String imgMetro = "metro5.png";
	private final String imgVerde = "verde5.gif";
	private final String imgRojo = "rojo5.gif";
	
	// Valores del eje Y
	private final int ySemArriba = 170;
	private final int yEstArriba = 60;
	
	// Valores del ancho y el alto de las imágenes
	private final int AnchoEstArriba = 55;
	private final int AltoEstArriba = 31;
	
	private final int AnchoSemArriba = 25;
	private final int AltoSemArriba = 25;
	
	int x = 0;
	int y = 145;
	
	
	
	public Ventana(String nombre) {
		ventana.setName(nombre);
		ventana.setTitle(nombre);
		ventana.setSize(1250, 600);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		 
		ventana.setLayout(null);
		container=ventana.getContentPane();
		container.setBackground(Color.decode("#f8f9f9"));
		
		
		/*				*
		 * 	NOMBRES		*
		 *				*/
		
	
		nombres = new JLabel[Inicializacion.numEstaciones];
		
		
		for(int i = 0; i < Inicializacion.numEstaciones; i++) {
			nombres[i] = new JLabel();
			nombres[i].setText(Inicializacion.nombreEstaciones[i]);
			nombres[i].setFont(new Font("Calibre", Font.PLAIN,9));
//			System.out.println(nombres[i].getText());
		}
		
		
		
		
		/*				*
		 * 	IMAGENES	*
		 *				*/
		
		imgTrenes = new ImageIcon[]{
			new ImageIcon(this.getClass().getResource("tren1_peque.png")),
			new ImageIcon(this.getClass().getResource("tren2_peque.png")),
			new ImageIcon(this.getClass().getResource("tren3_peque.png")),
			new ImageIcon(this.getClass().getResource("tren4_peque.png")),
			new ImageIcon(this.getClass().getResource("tren5_peque.png")),
			new ImageIcon(this.getClass().getResource("tren6_peque.png")),
			new ImageIcon(this.getClass().getResource("tren7_peque.png")),
			new ImageIcon(this.getClass().getResource("tren8_peque.png")),
			new ImageIcon(this.getClass().getResource("tren9_peque.png")),
			new ImageIcon(this.getClass().getResource("tren10_peque.png")) // 10
		};
		
		labelImg = new JLabel[Inicializacion.numTrenes];
		iconoTrenes = new Icon[Inicializacion.numTrenes];
		
		
		for(int i = 0; i < Inicializacion.numTrenes; i++) {
			labelImg[i] = new JLabel();
			labelImg[i].setVisible(false);
			labelImg[i].setBounds(x, y, 50, 30);
			iconoTrenes[i] = new ImageIcon(imgTrenes[i].getImage().getScaledInstance(labelImg[i].getWidth(),labelImg[i].getHeight(), Image.SCALE_DEFAULT));
			labelImg[i].setIcon(iconoTrenes[i]);
			container.add(labelImg[i]);
		}
		
		
		
		imagenesEstaciones = new JLabel[]{
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgMetro))), // 18
				};
		
		imagenesVerde = new JLabel[]{
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgVerde))), // 18
				};
		
		imagenesRojo = new JLabel[]{
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))),
				new JLabel(new ImageIcon(this.getClass().getResource(imgRojo))), // 18
				};
		
		for(int i = 0; i < imagenesVerde.length; i++) {
			imagenesVerde[i].setVisible(true);
			imagenesRojo[i].setVisible(false);
		}
	
				
		
		
		/*			*
		 * 	VIAS	*
		 *			*/
        	
		
		via1 = new JTextField();
		via1.setBounds(0, 150, 1250, 20);
		for(int i = 0; i < 600; i++) via1.setText(via1.getText() + "|");
		via1.setEnabled(false);
		via1.setDisabledTextColor(Color.WHITE);
		via1.setBackground(Color.GRAY);
		container.add(via1);
		
		
		/*				*
		 * 	ESTACIONES	*
		 *				*/
		
		
		// Estaciones de arriba, x+60
		
		nombres[0].setBounds(50, 110, 150, 50);
		container.add(nombres[0]);
		imagenesEstaciones[0].setBounds(60, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[0]);
		imagenesVerde[0].setBounds(75, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[0]);
		imagenesRojo[0].setBounds(75, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[0]);
		

		nombres[1].setBounds(110, 90, 150, 50);
		container.add(nombres[1]);
		imagenesEstaciones[1].setBounds(120, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[1]);
		imagenesVerde[1].setBounds(135, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[1]);
		imagenesRojo[1].setBounds(135, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[1]);
		

		nombres[2].setBounds(160, 110, 150, 50);
		container.add(nombres[2]);
		imagenesEstaciones[2].setBounds(180, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[2]);
		imagenesVerde[2].setBounds(190, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[2]);
		imagenesRojo[2].setBounds(190, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[2]);
		
		
		nombres[3].setBounds(220, 90, 150, 50);
		container.add(nombres[3]);
		imagenesEstaciones[3].setBounds(240, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[3]);
		imagenesVerde[3].setBounds(250, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[3]);
		imagenesRojo[3].setBounds(250, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[3]);
		
		
		nombres[4].setBounds(280, 110, 150, 50);
		container.add(nombres[4]);
		imagenesEstaciones[4].setBounds(300, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[4]);
		imagenesVerde[4].setBounds(310, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[4]);
		imagenesRojo[4].setBounds(310, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[4]);
		
		
		nombres[5].setBounds(340, 90, 150, 50);
		container.add(nombres[5]);
		imagenesEstaciones[5].setBounds(360, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[5]);
		imagenesVerde[5].setBounds(370, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[5]);
		imagenesRojo[5].setBounds(370, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[5]);
        	
		
		nombres[6].setBounds(420, 110, 150, 50);
		container.add(nombres[6]);
		imagenesEstaciones[6].setBounds(420, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[6]);
		imagenesVerde[6].setBounds(430, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[6]);
		imagenesRojo[6].setBounds(430, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[6]);
		
		
		nombres[7].setBounds(490, 90, 150, 50);
		container.add(nombres[7]);
		imagenesEstaciones[7].setBounds(480, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[7]);
		imagenesVerde[7].setBounds(490, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[7]);
		imagenesRojo[7].setBounds(490, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[7]);
		
		
		nombres[8].setBounds(550, 110, 150, 50);
		container.add(nombres[8]);
		imagenesEstaciones[8].setBounds(540, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[8]);
		imagenesVerde[8].setBounds(550, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[8]);
		imagenesRojo[8].setBounds(550, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[8]);
		
		
		nombres[9].setBounds(580, 90, 150, 50);
		container.add(nombres[9]);
		imagenesEstaciones[9].setBounds(600, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[9]);
		imagenesVerde[9].setBounds(610, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[9]);
		imagenesRojo[9].setBounds(610, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[9]);
		
		
		nombres[10].setBounds(660, 110, 150, 50);
		container.add(nombres[10]);
		imagenesEstaciones[10].setBounds(660, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[10]);
		imagenesVerde[10].setBounds(670, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[10]);
		imagenesRojo[10].setBounds(670, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[10]);
		
		
		nombres[11].setBounds(730, 90, 150, 50);
		container.add(nombres[11]);
		imagenesEstaciones[11].setBounds(720, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[11]);
		imagenesVerde[11].setBounds(730, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[11]);
		imagenesRojo[11].setBounds(730, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[11]);
		
		nombres[12].setBounds(800, 110, 150, 50);
		container.add(nombres[12]);
		imagenesEstaciones[12].setBounds(780, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[12]);
		imagenesVerde[12].setBounds(790, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[12]);
		imagenesRojo[12].setBounds(790, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[12]);
		
		nombres[13].setBounds(855, 90, 150, 50);
		container.add(nombres[13]);
		imagenesEstaciones[13].setBounds(840, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[13]);
		imagenesVerde[13].setBounds(850, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[13]);
		imagenesRojo[13].setBounds(850, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[13]);
		
		nombres[14].setBounds(895, 110, 150, 50);
		container.add(nombres[14]);
		imagenesEstaciones[14].setBounds(900, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[14]);
		imagenesVerde[14].setBounds(910, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[14]);
		imagenesRojo[14].setBounds(910, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[14]);
		
		nombres[15].setBounds(950, 90, 150, 50);
		container.add(nombres[15]);
		imagenesEstaciones[15].setBounds(960, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[15]);
		imagenesVerde[15].setBounds(970, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[15]);
		imagenesRojo[15].setBounds(970, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[15]);
		
		nombres[16].setBounds(1030, 110, 150, 50);
		container.add(nombres[16]);
		imagenesEstaciones[16].setBounds(1020, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[16]);
		imagenesVerde[16].setBounds(1030, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[16]);
		imagenesRojo[16].setBounds(1030, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[16]);
		
		nombres[17].setBounds(1090, 90, 150, 50);
		container.add(nombres[17]);
		imagenesEstaciones[17].setBounds(1080, yEstArriba, AnchoEstArriba, AltoEstArriba);
		container.add(imagenesEstaciones[17]);
		imagenesVerde[17].setBounds(1090, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesVerde[17]);
		imagenesRojo[17].setBounds(1090, ySemArriba, AnchoSemArriba, AltoSemArriba);
		container.add(imagenesRojo[17]);
		
		ventana.setVisible(true);
		ventana.toFront();
	}



	public static void main(String[] args) {
		new Ventana("Red de metro");
	}
	
}
