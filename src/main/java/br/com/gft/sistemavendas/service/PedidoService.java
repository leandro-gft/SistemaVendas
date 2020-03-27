package br.com.gft.sistemavendas.service;

import br.com.gft.sistemavendas.email.NotificadorEmail;
import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.repository.Pedidos;
import br.com.gft.sistemavendas.sms.NotificadorSms;

public class PedidoService {

	
	private Pedidos pedidos; 
	private NotificadorEmail notificadorEmail;
	private NotificadorSms notificadorSms;
	
	public PedidoService(Pedidos pedidos, NotificadorEmail notificadorEmail, NotificadorSms notificadorSms) {
		this.pedidos = pedidos;
		this.notificadorEmail=notificadorEmail;
		this.notificadorSms = notificadorSms;
	}


	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor()*0.1;
		pedidos.guardar(pedido);
		notificadorEmail.enviar(pedido);
		notificadorSms.enviar(pedido);
		return imposto;
	}
	
	

}
