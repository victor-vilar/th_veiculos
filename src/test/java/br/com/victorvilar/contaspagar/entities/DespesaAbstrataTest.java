package br.com.victorvilar.contaspagar.entities;

import br.com.victorvilar.contaspagar.entities.MovimentoPagamento;
import br.com.victorvilar.contaspagar.entities.DespesaAvulsa;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class DespesaAbstrataTest {
	
	public List<MovimentoPagamento> parcelas = new ArrayList<>();
	MovimentoPagamento p1;
	MovimentoPagamento p2;
	MovimentoPagamento p3;
	
	@BeforeEach
	public void setUp() {
		p1 = new MovimentoPagamento();
		p2 = new MovimentoPagamento();
		p3 = new MovimentoPagamento();
		p1.setValorPagamento(new BigDecimal("1000"));
		p2.setValorPagamento(new BigDecimal("1000"));
		p3.setValorPagamento(new BigDecimal("1000"));
		p1.setId(1L);
		p2.setId(2L);
		p2.setId(3L);
		parcelas.add(p1);
		parcelas.add(p2);
		parcelas.add(p3);
	}
	
	@Test
	@DisplayName("O metodo não deve permitir que duas instancias iguais de uma parcela seja inserida na lista")
	public void naoPodeAdicionarMesmaInstancia() {
		DespesaAvulsa da = new DespesaAvulsa();
		da.addParcela(p1);

		assertTrue(da.getQuantidadeParcelas() == 1);
		
		da.addParcela(p2);
		assertTrue(da.getQuantidadeParcelas() == 2);
		
		da.addParcela(p2);
		assertTrue(da.getQuantidadeParcelas() != 3);
		
		da.addParcela(p3);
		assertTrue(da.getQuantidadeParcelas() == 3);
	}

}
