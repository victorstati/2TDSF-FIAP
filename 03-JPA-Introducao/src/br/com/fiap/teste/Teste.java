package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//CRIAR UM GERENCIADOR DE ENTIDADES
		//Primeiro criar a fabrica:
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Depois a fabrica cria os Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		
		
		em.close();
		fabrica.close();
	}

}
