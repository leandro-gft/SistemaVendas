package br.com.gft.sistemavendas.email;

import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {

	public void executar(Pedido pedido) {
		System.out.println("Enviando o e-mail...");
		
	}
}
