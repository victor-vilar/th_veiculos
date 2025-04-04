package br.com.thveiculos.erp.entities.despesas;

import java.math.BigDecimal;

public interface Despesa {

	
	public CategoriaDespesa getCategoria();
	public String getNomeFornecedor();
	public String getDescricao();
	public boolean isQuitado();
	public BigDecimal getValorTotal();
	public int getQuantidadeParcelas();
}
