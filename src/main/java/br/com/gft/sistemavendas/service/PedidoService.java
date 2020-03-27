package br.com.gft.sistemavendas.service;

import java.util.List;

import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.model.StatusPedido;
import br.com.gft.sistemavendas.repository.Pedidos;

public class PedidoService {
	private List<AcaoLancamentoPedido> acoes;
	private Pedidos pedidos;
	
	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
		this.pedidos=pedidos;
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

	public Pedido pagar(Long codigo) {
		Pedido pedido = pedidos.buscarPeloCodigo(codigo);
		
		if (!pedido.getStatus().equals(StatusPedido.PENDENTE))
			throw new StatusPedidoInvalidoException();
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}
}
