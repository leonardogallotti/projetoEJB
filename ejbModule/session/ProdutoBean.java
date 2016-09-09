package session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Produto;



@Stateless
@LocalBean
public class ProdutoBean implements ProdutoBeanRemote<Produto> {

	
	@PersistenceContext(unitName="ejbTeste")
	private EntityManager  em;

	@Override
	public void create(Produto p) {
		em.persist(p);
		
	}

	@Override
	public void delete(Integer cod) {
		em.remove(em.getReference(Produto.class, cod));
		
	}

	@Override
	public void update(Produto p) {
		em.merge(p);
		
	}

	@Override
	public List<Produto> findAll() {
		return em.createQuery("from Produto").getResultList();
	}

	@Override
	public Produto findByCode(Integer cod) {
		return em.find(Produto.class, cod);
	}

    
}
