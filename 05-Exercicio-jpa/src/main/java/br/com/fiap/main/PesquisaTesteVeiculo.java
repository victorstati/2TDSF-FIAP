package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;

public class PesquisaTesteVeiculo {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		Veiculo veiculo = dao.pesquisar(1);
		
		System.out.println(veiculo.getPlaca());
		System.out.println(veiculo.getCor());
		System.out.println(veiculo.getAno());
		
		em.close();
		fabrica.close();

	}

}
