package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class ExcluirTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		//Excluir uma empresa 
		try {
			dao.excluir(1);
			dao.commit();
			System.out.println("Excluido com sucesso");
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			System.err.println("Empresa n�o encontrada");
		}catch(CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao excluir"); //ordem: mais espec�fico para mais gen�rico
		}
		

		
		em.close();
		fabrica.close();

	}

}
