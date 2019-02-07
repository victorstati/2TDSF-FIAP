package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Transmissao;

public class Teste {

	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		c1.setCor("Preto");
		c1.setCambio(Transmissao.SEMI_AUTOMATICO);
		
		Calendar data = Calendar.getInstance(); //DATA ATUAL
												//ANO MES DIA
		Calendar data2 = new GregorianCalendar(2000, Calendar.JANUARY,19);	
		c1.setDataLancamento(data);
		
		//FORMATAR A DATA
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(sdf.format(data.getTime()));
		System.out.println(sdf.format(data2.getTime()));
	}

}
