package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTest {

	private static PacoteDAO dao;
	private static TransporteDAO daoT;

	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacoteDAOImpl(em);
		daoT = new TransporteDAOImpl(em);
	}

	@Test
	void pesquisaPorTtransporterTeste() {
		Transporte t = daoT.pesquisar(1);
		List<Pacote> lista = dao.pesquisa(t);
		for (Pacote p : lista) {
			assertEquals(1, p.getTransporte().getId());
		}
	}
	
	@Test
	void pesquisarPorDataTest() {
		Calendar inicio = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);
		List<Pacote> lista = dao.buscarPorDatas(inicio, fim);
		for (Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(inicio) && pacote.getDataSaida().before(fim));
		}
	}

}
