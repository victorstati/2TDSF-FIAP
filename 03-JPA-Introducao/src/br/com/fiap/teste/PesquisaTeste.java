package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class PesquisaTeste {
	public static void main(String[]args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar cliente com c�digo 2
		Cliente cliente = em.find(Cliente.class, 2);
		
		
		System.out.println(cliente.getNome());
	
		
		//Modificar o nome no banco de dados
		cliente.setNome("Francisco");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
