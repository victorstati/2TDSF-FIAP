package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

public class Exercicio {

	public static void main(String[] args) {
		//REALIZAR O CRUD PARA O PRODUTO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar
		Produto produto = new Produto("Notebook", 2, Estado.NOVO,
				new GregorianCalendar(2019, Calendar.MARCH, 2), 
				new GregorianCalendar(2018, Calendar.APRIL, 19), 2000, null);
		
		em.persist(produto);
		
		//Pesquisar
		produto = em.find(Produto.class, 1);
		System.out.println("Nome do Produto: "+produto.getNome());
		
		//Atualizar
		produto = new Produto(1,"Celular", 2, Estado.NOVO,
				new GregorianCalendar(2019, Calendar.MARCH, 2), 
				new GregorianCalendar(2018, Calendar.APRIL, 19), 2000, null);
		produto = em.merge(produto);
		
		//Remover
		produto = em.find(Produto.class, 1);
		em.remove(produto);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
