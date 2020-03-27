package br.com.gft.sistemavendas.repository;

import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.service.AcaoLancamentoPedido;

public class Pedidos implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
		
	}
}
