package session;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ProdutoBeanRemote<Classe> {

	
	public void create(Classe p);
	public void delete(Integer cod);
	public void update(Classe p);
	public List<Classe> findAll();
	public Classe findByCode(Integer cod);
	
	
}
