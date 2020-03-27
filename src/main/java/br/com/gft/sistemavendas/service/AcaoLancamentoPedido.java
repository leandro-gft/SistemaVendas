package br.com.gft.sistemavendas.service;

import br.com.gft.sistemavendas.model.Pedido;

public interface AcaoLancamentoPedido {

	public void executar(Pedido pedido);
}
