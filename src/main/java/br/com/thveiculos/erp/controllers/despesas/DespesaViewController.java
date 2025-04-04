/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.thveiculos.erp.controllers.despesas;

import br.com.thveiculos.erp.controllers.AppViewController;
import br.com.thveiculos.erp.controllers.util.ControllerHelper;
import br.com.thveiculos.erp.entities.despesas.Despesa;
import br.com.thveiculos.erp.entities.despesas.DespesaAbstrata;
import br.com.thveiculos.erp.entities.despesas.DespesaAvulsa;
import br.com.thveiculos.erp.entities.despesas.DespesaRecorrente;
import br.com.thveiculos.erp.entities.despesas.MovimentoPagamento;
import br.com.thveiculos.erp.entities.despesas.NotaFiscal;
import br.com.thveiculos.erp.enums.despesas.Periodo;
import br.com.thveiculos.erp.util.ConversorMoeda;
import br.com.thveiculos.erp.services.despesas.interfaces.CategoriaDespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.DespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.FormaPagamentoService;
import br.com.thveiculos.erp.util.ConversorData;
import br.com.thveiculos.erp.views.despesas.DespesaView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author victor
 */
@Controller
public class DespesaViewController implements AppViewController<DespesaView> {

    private final DespesaService service;
    private DespesaView view;
    private final CategoriaDespesaService categoriaDespesaService;
    private final FormaPagamentoService formaPagamentoService;
    private static final String DESPESA_AVULA = "AVULSA";
    private static final String DESPESA_RECORRENTE = "RECORRENTE";
    private final List<String> exludeComponents = List.of("btnNovo", "btnEditar",
            "btnSalvar", "btnDeletar", "fieldId");

    private List<MovimentoPagamento> movimentos;
    

    @Autowired
    public DespesaViewController(
            DespesaService service,
            CategoriaDespesaService categoriaDespesaService,
            FormaPagamentoService formaPagamentoService) {
        this.service = service;
        this.categoriaDespesaService = categoriaDespesaService;
        this.formaPagamentoService = formaPagamentoService;
        movimentos = new ArrayList<>();

    }

    @Override
    public void setView(DespesaView view) {
        this.view = view;

    }

    @Override
    public void novo() {
        enableDisableComponents(true);
        limparCampos();

    }

    @Override
    public void salvar() {
        
        DespesaAvulsa despesa = new DespesaAvulsa();

        if(!view.getFieldId().getText().equals("")){
            despesa.setId(Long.valueOf(view.getFieldId().getText()));
        }
        
        despesa.setNotaFiscal(buildNota());
        despesa.setParcelas(movimentos);
        
        
        despesa.setNomeFornecedor(view.getFieldDescricao().getText());
        despesa.setDescricao(view.getAreaDescricao().getText());
        service.save(despesa);
        
        
        
        
        enableDisableComponents(false);
        limparCampos();

    }

    private NotaFiscal buildNota(){
        
        NotaFiscal nota = new NotaFiscal();
        nota.setDataEmissao(ConversorData.paraData(view.getFieldNotaEmissao().getText()));
        nota.setNumero(view.getFieldNota().getText());
        return nota;
    }
    
    @Override
    public void editar() {
        if (view.getFieldId().getText().equals("")) {
            return;
        }

        enableDisableComponents(true);
    }

    @Override
    public void deletar() {
        service.deleteById(Long.valueOf(view.getFieldId().getText()));
        limparCampos();
    }

    @Override
    public void limparCampos() {
        view.getTextFields().stream().forEach(f -> f.setText(""));
        view.getComboCategoria().setSelectedIndex(-1);
        view.getSpinnerQuantidadeParcelas().getModel().setValue(1);
        movimentos.clear();
        limparCamposParcelamento();
        limparTabela();
    }

    /**
     * Constroi o objeto que será salvo no banco de dados.
     */
    private Despesa getInstance(String type) {

        if (type.equals(DESPESA_AVULA)) {
            return new DespesaAvulsa();

        } else {
            DespesaRecorrente dr = new DespesaRecorrente();
            
            return new DespesaRecorrente();
        }

    }
    
    private Despesa build(Despesa despesa){
        return null;
    }

    /**
     * Atualiza os combobox da view com os valores vindos do banco de dados.
     */
    public void inicializarComboBox() {
        inicializarComboCategoria();
        inicializarComboFormaPagamento();
        inicializarComboParcelamento();

    }

    /**
     * Adiciona as categorias na combobox de categorias da view.
     */
    void inicializarComboCategoria() {
        
        view.getComboCategoria().removeAllItems();
        
        this.categoriaDespesaService.getTodos().stream().forEach(c -> {
            view.getComboCategoria().addItem(c.getName());
        });

        view.getComboCategoria().setSelectedIndex(-1);
    }

    /**
     * Adiciona as formas de pagamento nas combox da view.
     */
    private void inicializarComboFormaPagamento() {

        view.getComboFormaPagamento().removeAllItems();
        view.getComboFormaPagamentoTabela().removeAllItems();
        
        this.formaPagamentoService.getTodos().stream().forEach(f -> {
            view.getComboFormaPagamento().addItem(f.getName());
            view.getComboFormaPagamentoTabela().addItem(f.getName());
        });

        view.getComboFormaPagamento().setSelectedIndex(-1);
    }

    /**
     * Adiciona os valores das formas de parcelamneto na combo da view.
     */
    private void inicializarComboParcelamento() {

        view.getComboParcelamento().removeAllItems();
        
        Arrays.asList(Periodo.values()).stream().forEach(p
                -> view.getComboParcelamento().addItem(p.name()));
        view.getComboParcelamento().setSelectedIndex(-1);
    }

    /**
     * Ativa ou desativa os componentes da view.
     *
     * @param con boolean 'true' para ativar 'false' para desativar
     */
    public void enableDisableComponents(boolean con) {

        view.listaDeComponentes().stream().forEach(c -> {
            if ((c.getName() != null) && !exludeComponents.contains(c.getName())) {
                c.setEnabled(con);
            }
        });

    }

    public void gerarParcelas() {
        criarMovimentos();
        preencherTabela(movimentos);
        limparCamposParcelamento();
    }
    

   
    /**
     * Cria os movimentos/parcelas de acordo com os valores adicionados nos
     * campos referentes as parcelas na view.
     */
    private void criarMovimentos() {

        
        movimentos = service.gerarMovimentos(
                (String) view.getComboParcelamento().getSelectedItem(),
                (int) view.getSpinnerQuantidadeParcelas().getValue(),
                view.getFieldVencimentoParcela().getText(),
                view.getFieldValorTotal().getText(),
                formaPagamentoService.getByForma((String)view.getComboFormaPagamento().getSelectedItem()));

    }

    /**
     * Atualiza a lista de movimentos de acordo com as alterações realizadas na
     * tabela da view.
     */
    private void atualizarMovimento(int linha) {
        service.atualizarMovimentos(movimentos, linha, (DefaultTableModel) view.getTableParcelas().getModel());
    }



    /**
     * Atualiza os valores da tabela a partir de uma lista de
     * movimentos/parcelas que forem passadas.
     *
     * @param movimentos Lista de movimentos que estão salvo ou não no banco de
     * dados que irão preencher a tabela.
     */
    private void preencherTabela(List<MovimentoPagamento> movimentos) {

        DefaultTableModel model = (DefaultTableModel) view.getTableParcelas().getModel();
        ControllerHelper.limparTabela(model);

        movimentos.stream().forEach(m -> {
            model.addRow(new Object[]{m.getId(),
                m.getReferenteParcela(),
                ConversorData.paraString(m.getDataVencimento()),
                ConversorMoeda.paraString(m.getValorPagamento()),
                ConversorData.paraString(m.getDataPagamento()),
                m.getFormaPagamento().getName(),
                m.getObservacao()});
        });

    }

    /**
     * Limpa todos os valores que estão dentro da tabela.
     */
    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) view.getTableParcelas().getModel();
        ControllerHelper.limparTabela(model);

    }
    
    
    /**
     * Limpar somente os campos referente as parcelas no formulário.
     */
    private void limparCamposParcelamento(){
        view.getComboParcelamento().setSelectedIndex(-1);
        view.getSpinnerQuantidadeParcelas().getModel().setValue(1);
        view.getFieldVencimentoParcela().setText("");
        view.getFieldValorTotal().setText("");
        view.getComboFormaPagamento().setSelectedIndex(-1);
    }

    /**
     * Adiciona as linhas que foram selecionadas na tabela e que podem ter
     * sofrido alguma alteração nos seus valores, para que esses novos valores
     * alterados possam ser atualizados na lista salva em memoria.
     *
     * @param indexLinha
     */
    public void atualizarLinhaAlterada(int indexLinha) {
        atualizarMovimento(indexLinha);
        preencherTabela(movimentos);
    }

    /**
     * Remove da lista de movimentos, os movimentos que foram deletados na
     * tabela.
     *
     * @param linhas
     */
    public void deletarMovimentos(int[] linhas) {

        //utilizado o serviço para remover os movimentos que estão na tabela.
        //O serviço armazena os movimentos em uma lista para serem deletadas
        //do banco, caso já tenham sido salvas.
        service.deletarMovimentos(movimentos, linhas);

        //atualiza a view com a nova tabela.
        preencherTabela(movimentos);

    }
}
