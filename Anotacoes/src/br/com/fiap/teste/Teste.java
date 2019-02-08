package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotations.Coluna;
import br.com.fiap.annotations.Tabela;
import br.com.fiap.bean.Cliente;

public class Teste {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();

		// API de Reflection p/ recuperar os metodos
		Method[] metodos = cliente.getClass().getDeclaredMethods();
		for (int i = 0; i < metodos.length; i++) {
			System.out.println(metodos[i].getName());
		}

		System.out.println("");

		// Recupera os atributos
		Field[] atributos = cliente.getClass().getDeclaredFields();
		for (Field item : atributos) {
			System.out.println(item.getName());

			// Exibir anotações @Coluna
			Coluna anotacao = item.getAnnotation(Coluna.class);
			System.out.println("Coluna: " + anotacao.nome());
			System.out.println("obrigatório: " + anotacao.obrigatorio());

		}

		System.out.println("");

		// Exibir nome da classe
		System.out.println(cliente.getClass().getName());

		// Recuperar anotacao @Tabela
		Tabela anotacao = cliente.getClass().getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM " + anotacao.nome());

	}

}
