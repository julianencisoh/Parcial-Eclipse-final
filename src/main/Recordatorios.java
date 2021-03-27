package main;

public class Recordatorios {
	
	private String color;
    private String posx;
    private String posy;
    private String estado;
    private String textorecordatorio;
    
    public Recordatorios(String color, String posx, String posy, String estado, String textorecordatorio){

        this.color = color;
        this.posx = posx;
        this.posy = posy;
        this.estado = estado;
        this.textorecordatorio = textorecordatorio;

    }
    
    
    public String getPosX() {
		return posx;
	}

	public void setPosX(String posx) {
		this.posx = posx;
	}

	public String getPosY() {
		return posy;
	}

	public void setPosY(String posy) {
		this.posy = posy;
	}
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public String getTextoRecordatorio() {
		return textorecordatorio;
	}


	public void setTextoRecordatorio(String textorecordatorio) {
		this.textorecordatorio = textorecordatorio;
	}


}
