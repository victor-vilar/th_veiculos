/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.thveiculos.erp.views.interfaces;

import br.com.thveiculos.erp.entities.despesas.DespesaAvulsa;
import javax.swing.JTextField;

/**
 *
 * @author victor
 */
public interface DespesaViewRecorrente extends DespesaView {
    
    public JTextField getFieldDiaVencimento();
    public JTextField getFieldMesVencimento();
    public JTextField getFieldDataInicio();
    public JTextField getFieldDataFim();
    
}
