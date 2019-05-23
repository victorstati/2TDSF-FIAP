package br.com.fiap.bo.impl;

import javax.ejb.Stateless;

import br.com.fiap.bo.DisciplinaBO;

@Stateless
public class DisciplinaBOImpl implements DisciplinaBO{

	@Override
	public double calcularMedia(double nac, double am, double ps) {
		return nac * 0.2 + am * 0.3 + ps * 0.5;
	}

	@Override
	public boolean retidoPorFaltas(int aulas, int faltas) {
		return faltas > aulas * 0.25;
	}
}
