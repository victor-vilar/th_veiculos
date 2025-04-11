/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.thveiculos.erp.controllers.despesas;

import br.com.thveiculos.erp.controllers.util.ControllerHelper;
import br.com.thveiculos.erp.entities.despesas.CategoriaDespesa;
import br.com.thveiculos.erp.entities.despesas.DespesaAvulsa;
import br.com.thveiculos.erp.entities.despesas.FormaPagamento;
import br.com.thveiculos.erp.entities.despesas.MovimentoPagamento;
import br.com.thveiculos.erp.entities.despesas.NotaFiscal;
import br.com.thveiculos.erp.exceptions.despesas.FieldsEmBrancoException;
import br.com.thveiculos.erp.exceptions.despesas.MesVencimentoInvalidoException;
import br.com.thveiculos.erp.services.despesas.interfaces.CategoriaDespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.DespesaService;
import br.com.thveiculos.erp.services.despesas.interfaces.FormaPagamentoService;
import br.com.thveiculos.erp.util.ConversorData;
import br.com.thveiculos.erp.util.ConversorMoeda;
import br.com.thveiculos.erp.views.despesas.DespesaAvulsaViewImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author victor
 */
@ExtendWith(MockitoExtension.class)
public class DespesaAvulsaControllerTest {

    @Spy
    @InjectMocks
    private DespesaAvulsaController controller;

    @Mock
    private CategoriaDespesaService categoriaDespesaService;

    @Mock
    private FormaPagamentoService formaPagamentoService;

    @Mock
    private DespesaService despesaService;

    private DespesaAvulsaViewImpl view;
    
    CategoriaDespesa cd1;
    CategoriaDespesa cd2;

    FormaPagamento fp1;
    FormaPagamento fp2;

    @BeforeEach
    public void setUp() {
        cd1 = new CategoriaDespesa();
        cd1.setId(1L);
        cd1.setCategoria("MANUTENÇÃO");

        cd2 = new CategoriaDespesa();
        cd2.setId(2L);
        cd2.setCategoria("LUZ");

        fp1 = new FormaPagamento();
        fp1.setId(1L);
        fp1.setForma("PIX");

        fp2 = new FormaPagamento();
        fp2.setId(2L);
        fp2.setForma("BOLETO");

        when(this.categoriaDespesaService.getTodos()).thenReturn(List.of(cd1, cd2));
        when(this.formaPagamentoService.getTodos()).thenReturn(List.of(fp1, fp2));

        view = new DespesaAvulsaViewImpl(controller, null);
        view.configurarComponent();
        controller.inicializarComboBox();

    }
    


    @Test
    @DisplayName("Metodo novo, deve destravar e limpar os campos da view")
    public void metodoNovoDeveChamarOsMetodosDeLimparEDestravarComponentes() {

        controller.novo();

        verify(controller, times(1)).enableDisableComponents(true);
        verify(controller, times(1)).limparCampos();

    }

    @Test
    public void metodoEditarNaoDeveAtivarComponentesSeFieldIdForNull() {
        controller.editar();
        verify(controller, times(0)).enableDisableComponents(true);
    }

    @Test
    public void metodoEditarDeveAtivarComponentesSeFieldIdForDiferenteDeNull() {

        view.getFieldId().setText("1");
        controller.editar();
        verify(controller, times(1)).enableDisableComponents(true);

    }

    @Test
    public void metodoDeletarDeveChamaODeleteDoServiço() {

        view.getFieldId().setText("1");
        controller.deletar();
        verify(despesaService, times(1)).deleteById(1l);
        verify(controller, times(1)).limparCampos();
    }
    
    @Test
    public void metodoLimparCamposDeveDeletarTextosDosComponentes(){
        
        view.getFieldId().setText("2");
        view.getFieldDescricao().setText("Teste");
        view.getFieldNota().setText("teste");
        view.getFieldNotaEmissao().setText("0102");
        view.getFieldCodFornecedor().setText("22");
        view.getAreaDescricao().setText("teste");
        view.getComboCategoria().setSelectedIndex(0);
        
        controller.limparCampos();
        
        assertEquals(view.getFieldId().getText(),"");
        assertEquals(view.getFieldDescricao().getText(),"");
        assertEquals(view.getFieldNota().getText(),"");
        assertEquals(view.getFieldNotaEmissao().getText(),"");
        assertEquals(view.getFieldCodFornecedor().getText(),"");
        assertEquals(view.getAreaDescricao().getText(),"");
        assertEquals(view.getComboCategoria().getSelectedIndex(),-1);
                
    
        
    }
    
    @Test
    public void metodoLimparCamposDeveChamarMetodoLimparTabela(){
        controller.limparCampos();
        verify(controller,times(1)).limparTabela();
    }
    
    @Test
    public void metodoLimparCamposDeveLimparListaDeMovimentos(){
        List<MovimentoPagamento> movimentos = controller.getMovimentos();
        movimentos.add(new MovimentoPagamento());
        movimentos.add(new MovimentoPagamento());
        
        assertFalse(controller.getMovimentos().isEmpty());
        assertEquals(controller.getMovimentos().size(),2);
        
        controller.limparCampos();
       assertTrue(controller.getMovimentos().isEmpty());
    }
    
    @Test
    public void metodoInicializarComboBoxDeveChamarOutrosMetodosComSucesso(){
    
        verify(controller,times(1)).resetarCombos();
        verify(controller,times(1)).inicializarComboCategoria();
        verify(controller,times(1)).inicializarComboFormaPagamento();
        verify(controller,times(1)).inicializarComboParcelamento();
    }
    
    @Test
    public void metodoResetarCombosDeveLimparComboBoxes(){
    
        view.getComboCategoria().addItem("categoria 1");
        view.getComboCategoria().addItem("categoria 2");
        view.getComboFormaPagamento().addItem("forma 1");
        view.getComboFormaPagamento().addItem("forma 2");
        view.getComboFormaPagamentoTabela().addItem("forma 1");
        view.getComboFormaPagamentoTabela().addItem("forma 2");
        view.getComboParcelamento().addItem("mensal");
        
        controller.resetarCombos();
        
        
        assertEquals(view.getComboCategoria().getModel().getSize(),0);
        assertEquals(view.getComboFormaPagamento().getModel().getSize(),0);
        assertEquals(view.getComboFormaPagamentoTabela().getModel().getSize(),0);
        assertEquals(view.getComboParcelamento().getModel().getSize(),0);
        
    }
    
    
    @Test
    public void metodoInicializarComboCategoriaDeveInicializarComboBox(){
        when(categoriaDespesaService.getTodos()).thenReturn(List.of(cd1,cd2));
        controller.resetarCombos();
        controller.inicializarComboCategoria();
        assertEquals(view.getComboCategoria().getModel().getSize(),2);
        assertEquals((String)view.getComboCategoria().getModel().getSelectedItem(),null);
    }
    
    @Test
    public void metodoInicializarComboFormaPagamentoDeveInicializarComboBox(){
        when(formaPagamentoService.getTodos()).thenReturn(List.of(fp1,fp2));
        controller.resetarCombos();
        controller.inicializarComboFormaPagamento();
        assertEquals(view.getComboFormaPagamento().getModel().getSize(),2);
        assertEquals(view.getComboFormaPagamentoTabela().getModel().getSize(),2);
        assertEquals((String)view.getComboFormaPagamento().getModel().getSelectedItem(),null);
    }
    
        @Test
    public void metodoInicializarComboParcelamentoDeveInicializarComboBox(){
        controller.resetarCombos();
        controller.inicializarComboParcelamento();
        assertFalse(view.getComboParcelamento().getModel().getSize() == 0);
        assertEquals((String)view.getComboParcelamento().getModel().getSelectedItem(),null);
    }
    
    
    @Test
    public void metodoEnableComponentesDeveAtivarTodosOsComponentesQueNaoEstaoNaListaDeExclusao() {
        List<String> exludeComponents = List.of("btnNovo", "btnEditar",
                "btnSalvar", "btnDeletar", "fieldId");

        view.getAllComponentes().stream().forEach(c -> {

            if ((c.getName() != null) && !exludeComponents.contains(c.getName())) {
                c.setEnabled(false);
            }
        });

        controller.enableDisableComponents(true);

        view.getAllComponentes().stream().forEach(c -> {
            if ((c.getName() != null) && !exludeComponents.contains(c.getName())) {
                assertEquals(true, c.isEnabled());
            }

        });

    }

    @Test
    public void metodoEnableComponentesDeveDesativarTodosOsComponentesQueNaoEstaoNaListaDeExclusao() {
        List<String> exludeComponents = List.of("btnNovo", "btnEditar",
                "btnSalvar", "btnDeletar", "fieldId");

        view.getAllComponentes().stream().forEach(c -> {

            if ((c.getName() != null) && !exludeComponents.contains(c.getName())) {
                c.setEnabled(true);
            }
        });

        controller.enableDisableComponents(false);

        view.getAllComponentes().stream().forEach(c -> {
            if ((c.getName() != null) && !exludeComponents.contains(c.getName())) {
                assertEquals(false, c.isEnabled());
            }

        });

    }


    @Test
    public void metodoEditarDevePassarMovimentosParaEdicao(){
        controller.editarMovimento(1);
        verify(controller.service,times(1)).atualizarMovimentos(anyList(),eq(1) , any(DefaultTableModel.class));
    }
    
    @Test
    public void metodoPreencherTabelaDeveAdicionarDadosVindoDoMovimento(){
        List<MovimentoPagamento> movimentos = new ArrayList<>();
        MovimentoPagamento m1 = new MovimentoPagamento();
        m1.setId(1L);
        m1.setReferenteParcela("1/2");
        m1.setDataVencimento(LocalDate.of(2025, Month.MARCH, 1));
        m1.setValorPagamento(new BigDecimal("1000"));
        m1.setFormaPagamento(fp1);
        
        MovimentoPagamento m2 = new MovimentoPagamento();
        m2.setId(2L);
        m2.setReferenteParcela("2/2");
        m2.setDataVencimento(LocalDate.of(2025, Month.APRIL, 1));
        m2.setValorPagamento(new BigDecimal("1000"));
        m2.setFormaPagamento(fp1);
        
        movimentos.add(m1);
        movimentos.add(m2);
        
        controller.preencherTabela(movimentos);
        
        assertEquals(view.getTableParcelas().getValueAt(0, 0), m1.getId());
        assertEquals(view.getTableParcelas().getValueAt(0, 1), m1.getReferenteParcela());
        assertEquals(view.getTableParcelas().getValueAt(0, 2), ConversorData.paraString(m1.getDataVencimento()));
        assertEquals(view.getTableParcelas().getValueAt(0, 3), ConversorMoeda.paraString(m1.getValorPagamento()));
        assertEquals(view.getTableParcelas().getValueAt(0, 4), ConversorData.paraString(m1.getDataPagamento()));
        assertEquals(view.getTableParcelas().getValueAt(0, 5), m1.getFormaPagamento().getName());
        
        assertEquals(view.getTableParcelas().getValueAt(1, 0), m2.getId());
        assertEquals(view.getTableParcelas().getValueAt(1, 1), m2.getReferenteParcela());
        assertEquals(view.getTableParcelas().getValueAt(1, 2), ConversorData.paraString(m2.getDataVencimento()));
        assertEquals(view.getTableParcelas().getValueAt(1, 3), ConversorMoeda.paraString(m2.getValorPagamento()));
        assertEquals(view.getTableParcelas().getValueAt(1, 4), ConversorData.paraString(m2.getDataPagamento()));
        assertEquals(view.getTableParcelas().getValueAt(1, 5), m2.getFormaPagamento().getName());
        
    }
    
    @Test
    public void metodoAtualizarLinhaAlteradaDeveChamarMetodos(){
    
           controller.atualizarLinhaAlterada(1);
           verify(controller,times(1)).editarMovimento(eq(1));
           verify(controller,times(1)).preencherTabela(anyList());
    }
    
    @Test
    public void metodoDeletarMovimentosDeveChamarServicoParaEliminarMovimentos(){
        
        int[] linhas = {2,3,10};
        controller.deletarMovimentos(linhas);
        verify(controller.service,times(1)).deletarMovimentos(anyList(), eq(linhas));
        verify(controller,times(1)).preencherTabela(anyList());
    }
    
    
    @Test
    public void metodoAoSubscreverDeveChamarMetodoSubscriptionCategoriaDespesa(){
    
        controller.aoSusbscrever("teste", "Categoria Despesas");
        verify(controller,times(1)).subscriptionCategoriaDespesa("teste");
        
    }
    
    @Test
    public void metodoAoSubscreverDeveChamarMetodoSubscriptionFormaPagamento(){
    
        controller.aoSusbscrever("teste", "Formas Pagamento");
        verify(controller,times(1)).subscriptionFormaPagamento("teste");  
    }
    
    @Test
    public void metodoSubscriptionCategoriaDespesaDeveAtualizarNovosValoresESelecionarOValorInserido(){
        controller.subscriptionCategoriaDespesa("Teste");
        verify(controller,times(2)).inicializarComboCategoria();
        assertEquals((String)view.getComboCategoria().getSelectedItem(),"Teste");
    }
    
    @Test
    public void metodoSubscriptionFormaPagamentoDeveAtualizarNovosValoresESelecionarOValorInserido(){
        controller.subscriptionFormaPagamento("Teste");
        verify(controller,times(2)).inicializarComboFormaPagamento();
        assertEquals((String)view.getComboFormaPagamento().getSelectedItem(),"Teste");
    }

    
    @Test
    public void metodoSalvarDeveCriarObjetoComOsValoresDaViewUtilizarMetodoSave() {

        controller.salvar();
        verify(controller.service, times(1)).save(any(DespesaAvulsa.class));

    }
    
    @Test
    public void metodoBuilNotaDeveRettonarNovaNotaFiscalComDadosPassados(){
        
        NotaFiscal nota = controller.buildNota("123456", "01022025");
        
        assertEquals(nota.getNumero(),"123456");
        assertEquals(nota.getDataEmissao(), LocalDate.of(2025,02,01)); 
        
    
    }
    
    @Test
    public void metodoGerarParcelasChamaOutrosMetodos(){
        
        controller.gerarParcelas();
        verify(controller,times(1)).criarMovimentos();
        verify(controller,times(1)).preencherTabela(anyList());
        verify(controller,times(1)).limparCamposParcelamento();
    }
    
    @Test
    public void metodoCriarMovimentosChamaServicoERecebeListaDeMovimento(){
    
        view.getComboParcelamento().setSelectedIndex(0);
        view.getSpinnerQuantidadeParcelas().getModel().setValue(2);
        view.getFieldVencimento().setText("01/03/2025");
        view.getFieldValor().setText("R$1000,00");
        view.getComboFormaPagamento().setSelectedIndex(0);
        
        MovimentoPagamento m1 = new MovimentoPagamento();
        m1.setId(1L);
        m1.setReferenteParcela("1/2");
        m1.setDataVencimento(LocalDate.of(2025, Month.MARCH, 1));
        m1.setValorPagamento(new BigDecimal("1000"));
        m1.setFormaPagamento(fp1);
        
        MovimentoPagamento m2 = new MovimentoPagamento();
        m2.setId(2L);
        m2.setReferenteParcela("2/2");
        m2.setDataVencimento(LocalDate.of(2025, Month.APRIL, 1));
        m2.setValorPagamento(new BigDecimal("1000"));
        m2.setFormaPagamento(fp1);
        
        
        
        when(formaPagamentoService.getByForma("PIX")).thenReturn(fp1);
        when(despesaService.gerarMovimentos(
                "ANUAL",
                2,
                "01/03/2025",
                "R$1000,00",
                fp1))
                .thenReturn(List.of(m1,m2));
        
        controller.criarMovimentos();
        List<MovimentoPagamento> movimentos = controller.getMovimentos();
        
        assertEquals(movimentos.isEmpty(),false);
        assertEquals(movimentos.size(),2);
        
    }
    
    @Test
    public void metodoLimparCamposParcelamentoLimpaCamposReferenteAoParcelamento(){
        
        view.getComboParcelamento().setSelectedIndex(0);
        view.getSpinnerQuantidadeParcelas().getModel().setValue(2);
        view.getFieldVencimento().setText("01/03/2025");
        view.getFieldValor().setText("R$1000,00");
        view.getComboFormaPagamento().setSelectedIndex(0);
        
        controller.limparCamposParcelamento();
        
        assertEquals(view.getComboParcelamento().getSelectedIndex(),-1);
        assertEquals(view.getSpinnerQuantidadeParcelas().getModel().getValue(),1);
        assertEquals(view.getFieldVencimento().getText(),"");
        assertEquals(view.getFieldValor().getText(),"");
        assertEquals(view.getComboFormaPagamento().getSelectedIndex(),-1);
    }


    @Test
    public void metodoChecarErrosDeveVerificarSeCamposNaoEstaVazios(){
        view.getFieldId().setText("");
        view.getFieldDescricao().setText("Teste");
        view.getAreaDescricao().setText("teste");
        view.getComboCategoria().setSelectedIndex(0);
        view.getComboFormaPagamento().setSelectedIndex(0);
        view.getFieldNotaEmissao().setText("01/02/2025");
        view.getFieldNota().setText("1421");
        view.getComboParcelamento().setSelectedIndex(1);
        view.getFieldValor().setText("120");

        controller.checarErrosAoSalvar();
        
     
    }
    
        @Test
    public void metodoChecarErrosDeveLançarExceptionSeAlgumCampoImportanteTiverVazio(){
        
                view.getFieldId().setText("");
        view.getFieldDescricao().setText("");
        view.getAreaDescricao().setText("teste");
        view.getComboCategoria().setSelectedIndex(0);
        view.getComboFormaPagamento().setSelectedIndex(0);
        view.getFieldNotaEmissao().setText("01/02/2025");
        view.getFieldNota().setText("1421");
        view.getComboParcelamento().setSelectedIndex(1);
        view.getFieldValor().setText("120");

        
        Assertions.assertThrows(FieldsEmBrancoException.class, ()
                -> controller.checarErrosAoSalvar());
    }

    
}
