package Dao;

import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Vehiculo;

@Stateless
public class VehiculoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(int codigo) {
		Vehiculo v = em.find(Vehiculo.class, codigo);
		return v;
	}
	
	public void delete(int codigo) {
		Vehiculo v = em.find(Vehiculo.class, codigo);
		em.remove(v);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT v FROM Vehiculo v";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
