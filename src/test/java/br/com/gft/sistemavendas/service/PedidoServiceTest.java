package br.com.gft.sistemavendas.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.gft.sistemavendas.email.NotificadorEmail;
import br.com.gft.sistemavendas.model.Pedido;
import br.com.gft.sistemavendas.model.builder.PedidoBuilder;
import br.com.gft.sistemavendas.repository.Pedidos;
import br.com.gft.sistemavendas.sms.NotificadorSms;

public class PedidoServiceTest {

	
	private PedidoService pedidoService;
	
	@Mock
	private Pedidos pedidos;
	
	@Mock
	private NotificadorEmail notificadorEmail;
	
	@Mock
	private NotificadorSms notificadorSms;
	
	private Pedido pedido;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		pedidoService = new PedidoService(pedidos, notificadorEmail, notificadorSms);
		pedido = new PedidoBuilder().comValor(100.0).para("Joao", "joao@joao.com", "1234-5678").construir();
	}
	
	@Test
	public void deveCalcularOImposto() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto, 0.0001);
	}

	@Test
	public void deveSalvarPedidoNoBancoDeDados() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(pedidos).guardar(pedido);
		
	}
	
	@Test
	public void deveNotificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorEmail).enviar(pedido);
	}
	
	@Test
	public void deveNotificarPorSms() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorSms).enviar(pedido);
	}
}
