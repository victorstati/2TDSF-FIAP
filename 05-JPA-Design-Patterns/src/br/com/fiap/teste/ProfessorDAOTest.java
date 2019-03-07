package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {
	
	private static ProfessorDAO dao;
	
	//m�todo que ser� executado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfessorDAOImpl(em);
	}

	@Test
	void cadastroTest() {
		//Arrange - instanciar os objetos
		Professor prof = new Professor("Parducci", null, "12365545555");
		
		//Act - realizar a a��o (chamar o m�todo para teste)
		try {
			dao.cadastar(prof);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		
		//Assert - validar o resultado
		//valida se foi gerado um c�digo pela sequence
		assertNotEquals(0, prof.getId());
	}
	
	//Teste atualizar
	@Test
	void atualizaTest() {
		//Arrange
		Professor prof = new Professor(1, "Parducci", null, "12345678912");
		
		//Act
		//Cadastrar um professor
		//Atualiza o professor
		try {
			dao.atualizar(prof);
			dao.commit();
		}catch(CommitException e){
			e.printStackTrace();
			fail("Falha no teste");
		}
		
		//Assert
		//Pesquisa e valida se o valor foi alterado no banco
		assertEquals(1, prof.getId());
	}
	
	//Teste Excluir
	@Test
	void excluirTest() {
		try {
			Professor prof = dao.pesquisar(1);
			dao.excluir(1);
			dao.commit();
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("falha");
		}
	}
	
	//Teste Pesquisar
	@Test
	void pesquisaTest() {
		try {
			Professor prof = dao.pesquisar(1);
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

}
