package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {
	
	private TCPConection tcp;
	private int posx, posy;
	private String color, textoRecordatorio;
	private boolean cualBoton;
	private ArrayList <Recordatorios> miLista;
		

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}
	
	public void settings() {
		size(900, 500);
	}
	
	public void setup() {
		
		tcp = new TCPConection();
		tcp.setMain(this);
		tcp.start();
		
		miLista = new ArrayList <Recordatorios>();
		
		
		
	}
	
	public void draw() {
		
		background(250, 250, 250);
		
		for(int i=0; i< miLista.size(); i++){
			
			int posicionx = Integer.parseInt(miLista.get(i).getPosX());
			int posiciony = Integer.parseInt(miLista.get(i).getPosY());
			
			
			stroke(180);
			fill(255,255,255);
			rect(posicionx,posiciony,100,40);
			
			switch(miLista.get(i).getColor()) {
			
			case "rojo":
				
				fill(255,0,0);
				
				break;
				
            case "amarillo":
				
				fill(255,233,0);
				
				break;
				
            case "verde":
				
				fill(0,255,0);
				
				break;
				
			}
			ellipse (posicionx+30,posiciony,20,20);
			fill(0);
			text(miLista.get(i).getTextoRecordatorio(),posicionx+15,posiciony+20);
			
		}
		
		if(cualBoton==true) {
		
		stroke(180);
		fill(255,255,255);
		rect(posx,posy,100,40);
		
		
		switch(color) {
		
		case "rojo":
			
			fill(255,0,0);
			
			break;
			
        case "amarillo":
			
			fill(255,233,0);
			
			break;
			
        case "verde":
			
			fill(0,255,0);
			
			break;
	
		}
		ellipse (posx+30,posy,20,20);
		fill(0);
		text(textoRecordatorio,posx+15,posy+20);
		
		}
		
	}

	public void Visualizar(Recordatorios recordatorio) {
		// TODO Auto-generated method stub
		
		posx = Integer.parseInt(recordatorio.getPosX());
		posy = Integer.parseInt(recordatorio.getPosY());
		textoRecordatorio = recordatorio.getTextoRecordatorio();
		color = recordatorio.getColor();
		cualBoton = true; 
		
	}

	public void Confirmar(Recordatorios recordatorio) {
		// TODO Auto-generated method stub
		
		String colorEstado = recordatorio.getColor();
		String posix = recordatorio.getPosX();
		String posiy = recordatorio.getPosY();
		String texticoRecordatorio = recordatorio.getTextoRecordatorio();
		
		
		miLista.add(new Recordatorios(colorEstado,posix,posiy,"hola",texticoRecordatorio));
		cualBoton = false;
		
	
		
	}

}
