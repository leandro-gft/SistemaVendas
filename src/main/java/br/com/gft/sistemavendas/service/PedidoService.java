package br.com.gft.sistemavendas.service;

import java.util.List;

import br.com.gft.sistemavendas.model.Pedido;

public class PedidoService {
	private List<AcaoLancamentoPedido> acoes;
	
	public PedidoService(List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor()*0.1;
		
		acoes.forEach(a -> a.executar(pedido));
//		for (AcaoLancamentoPedido acao:acoes) {
//			acao.executar(pedido);
//			
//		}
		
		return imposto;
	}
}
