/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.thveiculos.erp.controllers.despesas;

import br.com.thveiculos.erp.entities.despesas.DespesaRecorrente;
import br.com.thveiculos.erp.enums.despesas.Periodo;
import br.com.thveiculos.erp.services.despesas.interfaces.CategoriaDespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.DespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.FormaPagamentoService;
import br.com.thveiculos.erp.util.ConversorData;
import br.com.thveiculos.erp.util.ConversorMoeda;
import br.com.thveiculos.erp.views.despesas.DespesaRecorrenteViewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

/**
 *
 * @author victor
 */
@Controller
public class DespesaRecorrenteController extends DespesaAbstractController<DespesaRecorrenteViewImpl>{

    @Autowired
    public DespesaRecorrenteController(DespesaService service, CategoriaDespesaService categoriaDespesaService, FormaPagamentoService formaPagamentoService) {
        super(service, categoriaDespesaService, formaPagamentoService);
    }
    
    @Override
    public void salvar() {
        DespesaRecorrente despesa = new DespesaRecorrente();

        String id = view.getFieldId().getText();

        if (!id.equals("")) {
            despesa.setId(Long.valueOf(id));
        }

        String nome = view.getFieldDescricao().getText().toUpperCase();
        String descricao = view.getAreaDescricao().getText().toUpperCase();
        String categoria = (String) view.getComboCategoria().getSelectedItem();
        String formaPagamento = (String) view.getComboFormaPagamento().getSelectedItem();
        String dataInicio = view.getFieldDataInicio().getText();
        String dataFim = view.getFieldDataFim().getText();
        Periodo periodo = Periodo.valueOf((String)view.getComboParcelamento().getSelectedItem());
        String valor = view.getFieldValor().getText();
        Integer dia = Integer.valueOf(view.getFieldDiaVencimento().getText());
        Integer mes = Integer.valueOf(view.getFieldMesVencimento().getText());
        
        
        despesa.setNomeFornecedor(nome);
        despesa.setDescricao(descricao);
        despesa.setCategoria(this.categoriaDespesaService.getByCategoria(categoria));
        despesa.setFormaPagamentoPadrao(this.formaPagamentoService.getByForma(formaPagamento));
        despesa.setDataInicio(ConversorData.paraData(dataInicio));
        despesa.setDataFim(ConversorData.paraData(dataFim));
        despesa.setPeriocidade(periodo);
        despesa.setValorTotal(ConversorMoeda.paraBigDecimal(valor));
        despesa.setDiaPagamento(dia);
        despesa.setMesPagamento(mes);
        
        service.save(despesa);
        limparCampos();
        
        
        
    }


    
}
