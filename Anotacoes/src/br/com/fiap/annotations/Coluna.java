package br.com.fiap.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//mant�m a anota��o at� a execu��o
@Target({ElementType.FIELD})//somente para os atributos 
public @interface Coluna {

	String nome();
	
	boolean obrigatorio();
	
	
}
