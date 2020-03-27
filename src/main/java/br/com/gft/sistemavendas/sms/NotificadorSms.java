package br.com.gft.sistemavendas.sms;

import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

	public void executar(Pedido pedido) {
		System.out.println("Enviando o SMS...");
		
	}
}
