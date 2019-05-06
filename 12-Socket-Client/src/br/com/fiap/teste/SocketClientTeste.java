package br.com.fiap.teste;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.entity.Vingador;

public class SocketClientTeste {

	public static void main(String[] args) throws Exception {
		//Enviar um objeto para o server
		Socket socket = new Socket("localhost", 8080);
		
		Vingador vingador = new Vingador("Lebre", "Rocket", "Roubar");
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject(vingador);
		
		System.out.println("Objeto enviado!");
		
		output.close();
		socket.close();
	}

}
