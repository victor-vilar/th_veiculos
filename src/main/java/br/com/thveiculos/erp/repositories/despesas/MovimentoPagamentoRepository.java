package br.com.thveiculos.erp.repositories.despesas;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thveiculos.erp.entities.despesas.MovimentoPagamento;

public interface MovimentoPagamentoRepository extends JpaRepository<MovimentoPagamento, Long> {

}
