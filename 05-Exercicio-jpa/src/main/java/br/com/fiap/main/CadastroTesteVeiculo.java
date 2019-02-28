package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CommitException;

public class CadastroTesteVeiculo {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		Veiculo veiculo = new Veiculo("dao-1234", "preto", 2010);
		
		try {
			dao.cadastrar(veiculo);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao cadastrar");
		}
		
		em.close();
		fabrica.close();

	}

}
