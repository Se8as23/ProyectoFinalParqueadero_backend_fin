package negocio;

import java.util.Date;
import java.util.List;

import Dao.ClienteDAO;
import Dao.FacturaDAO;
import Dao.SitioDAO;
import Dao.TarifaDAO;
import Dao.TicketDAO;
import Dao.VehiculoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.Factura;
import modelo.Sitio;
import modelo.Tarifa;
import modelo.Ticket;
import modelo.Vehiculo;

@Singleton
@Startup
public class DatosProyecto {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private TarifaDAO daoTarifa;
	
	@Inject
	private SitioDAO daoSitio;
	
	@Inject
	private TicketDAO daoTicket;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@PostConstruct
	public void init() {
		
		Cliente c = new Cliente();
		c.setCedula("0302448642");
		c.setNombre("Anna");
		c.setApellido("Andrade");
		c.setDireccion("Union Alta");
		c.setTelefono("0979229076");
		
		
		Vehiculo v = new Vehiculo();
		v.setPlaca("ABC-6562");
		v.setModelo("GTR-R35");
		v.setMarca("Nissan Skyline");
		
		daoVehiculo.insert(v);
		
		Vehiculo v1 = new Vehiculo();
		v1.setPlaca("CCY-6992");
		v1.setModelo("Mazda");
		daoVehiculo.insert(v1);
		
		c.addVehiculo(v);
		c.addVehiculo(v1);
		
		daoCliente.insert(c);
		
		Sitio s = new Sitio();
		s.setLugar("P2-7");
		s.setUbicacion("Planta 2");
		daoSitio.insert(s);
		
		Ticket ti = new Ticket();
		ti.setHoraEntrada(new Date());
		ti.setHoraSalida(new Date());
		ti.setCliente(c);
		
		daoTicket.insert(ti);
		
		Tarifa ta = new Tarifa();
		ta.setPrecio(1);
		ta.setTarifa("publica");
		
		daoTarifa.insert(ta);
	
		Factura f = new Factura();
		f.setFechaFactura(new Date());
		f.setNumeroFactura("AVVV-1234321");
		f.setCliente(c);
		f.setTarifa(ta);
		f.setTicket(ti);
		f.setTotal(1);
		
		daoFactura.insert(f);
		
		
		List<Cliente> clientes = daoCliente.getAll();
		for(Cliente cli: clientes){
			System.out.println(cli);
		}

		List<Vehiculo> vehiculos = daoVehiculo.getAll();
		for(Vehiculo veh: vehiculos){
			System.out.println(veh);
		}
		
		List<Sitio> sitio = daoSitio.getAll();
		for(Sitio sit: sitio){
			System.out.println(sit);
		}
		
		List<Ticket> tickets= daoTicket.getAll();
		for(Ticket tic: tickets){
			System.out.println(tic);
		}
		
		List<Tarifa> tarifa = daoTarifa.getAll();
		for(Tarifa tar: tarifa){
			System.out.println(tar);
		}
		
		List<Factura> factura = daoFactura.getAll();
		for(Factura fac: factura){
			System.out.println(fac);
		}
	}
}
