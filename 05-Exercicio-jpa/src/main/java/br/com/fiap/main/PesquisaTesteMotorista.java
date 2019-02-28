package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MototristaDAOImpl;
import br.com.fiap.entity.Motorista;

public class PesquisaTesteMotorista {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MototristaDAOImpl(em);
		
		Motorista motorista = dao.pesquisar(1);
		
		System.out.println(motorista.getNome());
		System.out.println(motorista.getNascimento());
		System.out.println(motorista.getGenero());
		
		em.close();
		fabrica.close();

	}

}
