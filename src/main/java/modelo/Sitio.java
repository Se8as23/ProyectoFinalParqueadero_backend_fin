package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sitio {

	@Id
	@GeneratedValue
	@Column(name="sit_codigo")
	private int codigo;
	
	@Column(name="sit_ubicacion")
	private String ubicacion;
	
	@Column(name="sit_lugar")
	private String lugar;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
	return "Sitio [codigo=" + codigo + ", ubicacion=" + ubicacion + ", lugar=" + lugar + "]";
	}	
}

