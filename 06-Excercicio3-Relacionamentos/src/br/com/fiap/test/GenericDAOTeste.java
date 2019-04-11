package br.com.fiap.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class GenericDAOTeste {
	
	private static VeiculoDAO dao;
	private Veiculo veiculo;
	
	@BeforeAll
	public static void iniciar() {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		dao = new VeiculoDAOImpl(em);
	}
	
	@BeforeEach
	public void cadastro() {
		veiculo = new Veiculo("ABC-7989", "Preto", 2019);
		
		try {
			dao.cadastrar(veiculo);
			dao.commit();
		}catch(CommitException e){
			e.printStackTrace();
			fail("Falha no cadastro");
		}
	}

	@Test
	@DisplayName("Teste de remoção de sucesso")
	void remover() {
		try {
			dao.remover(veiculo.getCodigo());
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
		assertThrows(CodigoInexistenteException.class, ()-> dao.buscar(veiculo.getCodigo()));
	}
	
	@Test
	@DisplayName("Teste de atualização com sucesso")
	public void atualizar() {
		Veiculo atualizacao = new Veiculo(veiculo.getCodigo(), "AAA-0000", "Branco", 2011);
		
		try{
			dao.atualizar(atualizacao);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail();
		}
		
		Veiculo busca;
		
		try {
			busca = dao.buscar(atualizacao.getCodigo());
			assertEquals("AAA-0000", busca.getPlaca());
			assertEquals(2011, busca.getAno());
		}catch(CodigoInexistenteException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@DisplayName("Teste de busca com sucesso")
	public void buscar() {
		Veiculo busca;
		try {
			busca = dao.buscar(veiculo.getCodigo());
			assertNotNull(busca);
			assertEquals("ABC-7989", busca.getPlaca());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	@DisplayName("Teste de cadastro com sucesso")
	public void cadastrar() {
		assertEquals(0, veiculo.getCodigo());
	}
}
