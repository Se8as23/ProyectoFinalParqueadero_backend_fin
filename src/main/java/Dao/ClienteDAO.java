package Dao;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Cliente;

@Stateless
public class ClienteDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente read(int codigo) {
		Cliente c = em.find(Cliente.class, codigo);
		return c;
	}
	
	public void delete(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		em.remove(c);
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
}
