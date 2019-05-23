package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.LocacaoDAO;
import br.com.fiap.dao.impl.LocacaoDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Imovel;
import br.com.fiap.entity.Locacao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {
	
	private static LocacaoDAO dao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new LocacaoDAOImpl(em);
	}

	@Test
	void cadastrarTest() {
		Cliente cliente = new Cliente("Teste", Genero.MASCULINO, Calendar.getInstance());
		
		Imovel imovel = new Imovel(null, "2 quartos", "Av.Paulusta", 1234567);
		
		Locacao locacao = new Locacao(cliente, imovel, Calendar.getInstance(), 10000);
		
		try {
			dao.cadastrar(locacao);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha");
		}
	}
	
	@Test
	void pesquisaPorData() {
		Calendar inicio = new GregorianCalendar(2018, Calendar.DECEMBER, 1);
		Calendar fim = new GregorianCalendar(2019, Calendar.DECEMBER, 1);
		
		List<Locacao> locacoes = dao.buscarPorData(inicio, fim);
		
		assertNotEquals(0, locacoes.size());
		
		for (Locacao locacao : locacoes) {
			assertTrue(locacao.getData().before(inicio) && locacao.getData().after(fim));
		}
		
	}

	@Test
	void pesquisaPorCliente() {
		Cliente cliente = new Cliente();
		long qtd = dao.contarPorCliente(cliente.getCodigo());
		
		assertEquals(1, qtd);
	}
}
