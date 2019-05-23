package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.DisciplinaBO;

@ManagedBean
public class DisciplinaBean {

	private double nac;
	private double am;
	private double ps;
	private double media;
	private int aulas;
	private int faltas;
	private boolean aprovado;
	
	@EJB
	private DisciplinaBO bo;
	
	public void verificar() {
		aprovado = bo.retidoPorFaltas(aulas, faltas);
	}
	
	// clique do botão
	public void calcular() {
		media = bo.calcularMedia(nac, am, ps);
	}
	
	public double getNac() {
		return nac;
	}
	public void setNac(double nac) {
		this.nac = nac;
	}
	public double getAm() {
		return am;
	}
	public void setAm(double am) {
		this.am = am;
	}
	public double getPs() {
		return ps;
	}
	public void setPs(double ps) {
		this.ps = ps;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}

	public int getAulas() {
		return aulas;
	}

	public void setAulas(int aulas) {
		this.aulas = aulas;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	
	
	
}
