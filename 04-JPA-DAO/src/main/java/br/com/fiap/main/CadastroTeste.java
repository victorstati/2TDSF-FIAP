package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitException;

public class CadastroTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		//Cadastrar um EMPRESA
		Empresa empresa = new Empresa("FIAP", 
				new GregorianCalendar(1990, Calendar.JANUARY, 1), 
				Status.ATIVO, 
				"23.654.321/0001-89");
		
		
		try {
			dao.cadastrar(empresa);
			dao.commit();
			System.out.println("Cadastrado com sucesso");
		} catch (CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao cadastrar");
		}
		
		em.close();
		fabrica.close();
	}

}
