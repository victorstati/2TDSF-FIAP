package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import java.util.List;
import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.dao.impl.CasoTesteDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {
	
	@Test
	void test() {
		EntityManager em  = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		CasoTesteDAO dao = new CasoTesteDAOImpl(em);
		
		Sistema sistema = new Sistema();
		sistema.setNome("Padaria do Zé");
		
		CasoTeste caso = new CasoTeste();
		caso.setNome("Teste de Performance");
		caso.setSistema(sistema);
		
		ItemTeste item1 = new ItemTeste();
		item1.setDescricao("Item de teste 1");
		
		ItemTeste item2 = new ItemTeste();
		item2.setDescricao("Item de teste 2");
		
		Usuario user = new Usuario();
		user.setNome("Thiago");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(user);
		
		item1.setUsuarios(usuarios);
		
		caso.addItem(item1);
		caso.addItem(item2);
		
		try{
			dao.cadastrar(caso);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	

}
