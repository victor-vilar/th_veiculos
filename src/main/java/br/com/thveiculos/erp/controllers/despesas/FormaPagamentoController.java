package br.com.thveiculos.erp.controllers.despesas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.thveiculos.erp.controllers.SimpleViewController;
import br.com.thveiculos.erp.entities.despesas.FormaPagamento;
import br.com.thveiculos.erp.entities.interfaces.SimpleEntity;
import br.com.thveiculos.erp.services.despesas.interfaces.FormaPagamentoService;

@Component
public class FormaPagamentoController extends SimpleViewController {
	
	@Autowired
	public FormaPagamentoController(FormaPagamentoService service) {
		super();
		this.service = service;
	}

	@Override
	public SimpleEntity construirObjeto() {
		
		FormaPagamento obj = new FormaPagamento();
		obj.setForma(view.getFieldNome().getText().toUpperCase());
		
		if(!view.getFieldId().getText().equals("")) {
			obj.setId(Long.valueOf(view.getFieldId().getText()));
		}
		
		return obj;
	}



	

	



		
}
