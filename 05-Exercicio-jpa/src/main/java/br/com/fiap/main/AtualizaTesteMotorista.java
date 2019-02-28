package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MototristaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.exception.CommitException;

public class AtualizaTesteMotorista {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MototristaDAOImpl(em);
		
		Motorista motorista = new Motorista(1, 
				"Ana Silva",
				new GregorianCalendar(1990, Calendar.APRIL, 1),
				null,
				Genero.FEMININO);
		
		try {
			dao.atualizar(motorista);
			dao.commit();
			System.out.println("Atualizado com sucesso");
		}catch(CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao atualizar");
		}
		
		em.close();
		fabrica.close();

	}

}
