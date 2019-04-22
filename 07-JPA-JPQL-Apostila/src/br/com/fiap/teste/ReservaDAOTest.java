package br.com.fiap.teste;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;

class ReservaDAOTest {
	
	private static ReservaDAO dao;
	
	@BeforeAll
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		dao = new ReservaDAOImpl(em);
	}

	@Test
	void listar() {
		List<Reserva> lista = dao.listar();
		assertNotEquals(0, lista.size());
		
	}
	
	@Test
	void buscarPorDias() {
		List<Reserva> lista = dao.buscarPorNumeroDias(10);
		assertEquals(2, lista.size());
		
	}

}
