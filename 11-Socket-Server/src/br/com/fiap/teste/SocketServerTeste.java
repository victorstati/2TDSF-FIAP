package br.com.fiap.teste;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.entity.Vingador;

public class SocketServerTeste {

	public static void main(String[] args) throws Exception {
		//Receber um objeto via rede
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Aguardando conexão...");
		
		//Aguardar uma conexão
		Socket socket = server.accept();
		
		//Ler e exibir os valores do objeto vingador
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Vingador vingador = (Vingador) input.readObject();
		
		System.out.println(vingador.getNome());
		System.out.println(vingador.getNomeReal());
		System.out.println(vingador.getPoder());
		
		socket.close();
		server.close();

	}

}
