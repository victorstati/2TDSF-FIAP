package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {

	private static ProfessorDAO dao;

	private static Professor prof;

	// Método que será executado antes de cada teste
	@BeforeEach
	public void arrange() {
		// cadastrar
		prof = new Professor("Parducci", null, "77889911223");

		try {
			dao.cadastar(prof);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	// método que será executado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfessorDAOImpl(em);
	}

	@Test
	@DisplayName("Teste de cadastro de professor com sucesso")
	void cadastroTest() {
		// Assert - validar o resultado
		// valida se foi gerado um código pela sequence
		assertNotEquals(0, prof.getId());
	}

	// Teste atualizar
	@Test
	@DisplayName("Teste de atualização de professor com sucesso")
	void atualizaTest() {
		// Atualizar o professor
		Professor prof2 = new Professor(prof.getId(), "Rafael", null, "44553322551");
		try {
			dao.atualizar(prof2);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro no teste");
		}

		// Assert
		// Pesquisa e valida se o valor foi alterado no banco
		try {
			Professor prof3 = dao.pesquisar(prof.getId());
			assertEquals("Rafael", prof3.getNome());
			assertEquals("44553322551", prof3.getCpf());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	// Teste Pesquisar
	@Test
	@DisplayName("Teste de pesquisa de professor com sucesso")
	void pesquisaTest() {
		// pesquisar professor
		try {
			Professor busca = dao.pesquisar(prof.getId());
			// Assert - validar
			assertNotNull(busca); // encontrou alguem
			assertEquals(busca.getNome(), prof.getNome());// encontrou o professor correto
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}

	// Teste Excluir
	@Test
	@DisplayName("Teste de exclusão de professor com sucesso")
	void excluirTest() {
		// Remove
		try {
			dao.excluir(prof.getId());
			dao.commit();
		} catch (CodigoInexistenteException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		
		// pesquisa e valida se foi excluido
		assertThrows(CodigoInexistenteException.class, ()->dao.pesquisar(prof.getId()));
		
//		try {
//			Professor pesquisa = dao.pesquisar(prof.getId());
//			fail("Falha no teste");
//		} catch (CodigoInexistenteException e) {
//			e.printStackTrace();
//			//Sucesso
//			
//		}
	}
}
