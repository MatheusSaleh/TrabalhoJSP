package fema3bccJsp;

import java.util.ArrayList;
import java.util.List;

public class PaisDao {
	
	private static List<Pais> paises = new ArrayList<Pais>();
	
	public void add(Pais p) {
		paises.add(p);
	}
	
	public List<Pais> getPaises(){
		return paises;
	}
	
	public void excluir(Integer id) {
		Pais paisRecuperado = null;
		for (Pais p : paises) {
			if (p.getCodigo().equals(id)) {
				paisRecuperado = p;
				break;
			}
		}
		if (paisRecuperado != null) {
			paises.remove(paisRecuperado);
		}
	}

}
