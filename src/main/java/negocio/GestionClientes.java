package negocio;


import java.util.List;

import Dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import modelo.Cliente;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;
	
	public void guardarClientes(Cliente cliente) throws Exception {
		if(!this.isCedulaValida(cliente.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoCliente.read(cliente.getCodigo()) == null) {
			try {
				daoCliente.insert(cliente);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoCliente.update(cliente);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length()==10;
	}
	 public void guardarClientes(String cedula, String nombre, String apellido, String direccion, String telefono) {
	        // Implementa la lógica para guardar un cliente utilizando los parámetros proporcionados
	    }

	    public List<Cliente> listarClientes() {
	        return daoCliente.getAll();
	    }
	    
	    public void delete(String cedula) {
	    	daoCliente.delete(cedula);;
	    }
}
