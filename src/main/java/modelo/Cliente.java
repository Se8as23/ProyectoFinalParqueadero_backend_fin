package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@Column(name="cli_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="cli_cedula")
	private String cedula;
	
	@Column(name="cli_nombre")
	private String nombre;
	
	@Column(name="cli_apellido")
	private String apellido;
	
	@Column(name="cli_direccion")
	private String direccion;
	
	@Column(name="cli_telefono")
	private String telefono;
		
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="cli_codigo")
	private List<Vehiculo> vehiculos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
			this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vehiculo> getVehiculo() {
		return vehiculos;
	}

	public void setVehiculo(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void addVehiculo(Vehiculo vehiculo) {
		if(vehiculos==null) {
			vehiculos = new ArrayList<Vehiculo>();
		}
		vehiculos.add(vehiculo);
	}
	
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", vehiculo=" + vehiculos + "]";
	}
}
