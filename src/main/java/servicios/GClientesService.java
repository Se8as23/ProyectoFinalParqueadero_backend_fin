package servicios;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import modelo.Cliente;
import negocio.GestionClientes;

@Path("clientes")
public class GClientesService {
	

	@Inject
	private GestionClientes gclientes;
	
	private List<Cliente> clientes = new ArrayList<>();
	
	
	@GET
	@Path("ingresarClientes")
	@Produces("application/json")
	public String ingresarClientes(@QueryParam("cedula") String cedula, @QueryParam("nombre") 
	String nombre, @QueryParam("nombre") String apellido) {
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombre(nombre);
		clientes.add(cliente);
		
		return "Persona ingresada correctamente.";
	}
	
	@GET
    @Path("listarClientes")
    @Produces("application/json")
    public List<Cliente> listarClientes() {
        return gclientes.listarClientes();
    }
	
	
	@POST
    @Path("registrarClientes")
    @Produces("application/json")
    public Response guardarClientes(Cliente cliente) {
        try {
            gclientes.guardarClientes(cliente);
            return Response.status(Response.Status.OK).entity(cliente).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCodigo(99);
            error.setMensaje("Error al guardar: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(error).build();
        }
    }
	
	
	@DELETE
    @Path("eliminarClientes")
    @Consumes("application/json")
    @Produces("application/json")
    public Response eliminarClientes(Cliente cliente) {
        try {
            gclientes.delete(cliente.getCedula());
            Error respuesta = new Error();
            respuesta.setCodigo(1);
            respuesta.setMensaje("Persona eliminada correctamente.");
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error respuesta = new Error();
            respuesta.setCodigo(99);
            respuesta.setMensaje("Error al eliminar: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }
	
	@GET
    @Path("all")
    @Produces("application/json")
    public Response getClientes() {
        List<Cliente> listado = gclientes.listarClientes();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
	
	
}

	