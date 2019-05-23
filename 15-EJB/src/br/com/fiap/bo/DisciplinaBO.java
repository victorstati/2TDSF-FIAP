package br.com.fiap.bo;

import javax.ejb.Remote;

//@Local
@Remote
public interface DisciplinaBO {

	double calcularMedia(double nac, double am, double ps);
	
	boolean retidoPorFaltas(int aulas, int faltas);
}
