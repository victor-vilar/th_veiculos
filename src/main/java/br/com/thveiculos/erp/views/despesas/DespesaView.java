/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.thveiculos.erp.views.despesas;

import br.com.thveiculos.erp.controllers.DespesaViewController;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author victor
 */
@Component
public class DespesaView extends javax.swing.JFrame {

    MaskFormatter dateFormat;
    DespesaViewController controller;

    public DespesaView() {
        setFormatoData();
        initComponents();
        configureComponentes();
        
        
    }
    
    @Autowired
    public DespesaView(DespesaViewController controller){
        this.controller = controller;
        setFormatoData();
        initComponents();
        configureComponentes();
    }
    
    
    
    
    public void setFormatoData(){
        
        try{
            dateFormat = new MaskFormatter("##/##/####");      
        }catch(ParseException e){
            System.out.println(e);
        }
    }
    
    public void configureComponentes(){
    
        configureTable();
    }
    
    public void configureTable(){
        
        
        tableParcelas.setEnabled(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldNota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldDescricao = new javax.swing.JTextField();
        fieldCodFornecedor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        fieldNotaEmissao = new javax.swing.JFormattedTextField(dateFormat);
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboParcelamento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboFormaPagamento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        fieldValorTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableParcelas = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTable = new javax.swing.JButton();
        fieldVencimentoParcela = new javax.swing.JFormattedTextField(dateFormat);
        jButton5 = new javax.swing.JButton();
        toolBar = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Despesa");

        panelMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("Despesa/Fornecedor");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-binoculos.png"))); // NOI18N
        jButton1.setToolTipText("Buscar Fornecedor");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategoria.setSelectedIndex(-1);

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setText("Cod. Fornecedor");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Nota Fiscal");

        fieldId.setBackground(new java.awt.Color(255, 255, 204));
        fieldId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Descrição");

        areaDescricao.setColumns(20);
        areaDescricao.setRows(5);
        jScrollPane1.setViewportView(areaDescricao);

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Data Emissão");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-binoculos.png"))); // NOI18N
        jButton4.setToolTipText("Buscar Fornecedor");

        fieldNotaEmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNotaEmissaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(fieldNotaEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(fieldCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNotaEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Parcelamento");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Forma de Pamento");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Valor Total/ Parcela");

        tableParcelas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "fef", "feffe", "fef"},
                {null, null, "123123", "1123", "12123"},
                {null, null, "13", "3424", null}
            },
            new String [] {
                "Código", "Nº Parcela", "Data Vencimento", "Valor R$", "Data Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableParcelas.setColumnSelectionAllowed(true);
        tableParcelas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableParcelas);
        tableParcelas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tableParcelas.getColumnModel().getColumnCount() > 0) {
            tableParcelas.getColumnModel().getColumn(0).setResizable(false);
            tableParcelas.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableParcelas.getColumnModel().getColumn(1).setResizable(false);
            tableParcelas.getColumnModel().getColumn(1).setPreferredWidth(10);
            tableParcelas.getColumnModel().getColumn(2).setResizable(false);
            tableParcelas.getColumnModel().getColumn(3).setResizable(false);
            tableParcelas.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Nº Parcelas");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Data Vencimento");

        btnTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        btnTable.setToolTipText("Destravar Tabela");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        fieldVencimentoParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldVencimentoParcelaActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-binoculos.png"))); // NOI18N
        jButton5.setToolTipText("Buscar Fornecedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldVencimentoParcela)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldValorTotal))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(6, 6, 6)
                            .addComponent(comboParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldVencimentoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        toolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDeletar.setBackground(new java.awt.Color(242, 242, 242));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png"))); // NOI18N
        btnDeletar.setToolTipText("Deletar");
        btnDeletar.setBorder(null);

        btnNovo.setBackground(new java.awt.Color(242, 242, 242));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png"))); // NOI18N
        btnNovo.setToolTipText("Novo");
        btnNovo.setBorder(null);

        btnEditar.setBackground(new java.awt.Color(242, 242, 242));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(null);

        btnSalvar.setBackground(new java.awt.Color(242, 242, 242));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-save.png"))); // NOI18N
        btnSalvar.setToolTipText("Deletar");
        btnSalvar.setBorder(null);

        javax.swing.GroupLayout toolBarLayout = new javax.swing.GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(toolBarLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(529, Short.MAX_VALUE)))
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(toolBarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNotaEmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNotaEmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNotaEmissaoActionPerformed

    private void fieldVencimentoParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldVencimentoParcelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldVencimentoParcelaActionPerformed

    private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableActionPerformed
        
        if(!tableParcelas.isEnabled()){
            System.out.println("Destravei");
            tableParcelas.setEnabled(true);
            btnTable.setIcon(new ImageIcon(getClass().getResource("/img/icon-unlock.png")));
            
        }else{
            System.out.println("Travei");
            tableParcelas.setEnabled(false);
            btnTable.setIcon(new ImageIcon(getClass().getResource("/img/icon-lock.png")));
        }
    }//GEN-LAST:event_btnTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DespesaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTable;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboFormaPagamento;
    private javax.swing.JComboBox<String> comboParcelamento;
    private javax.swing.JTextField fieldCodFornecedor;
    private javax.swing.JTextField fieldDescricao;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldNota;
    private javax.swing.JFormattedTextField fieldNotaEmissao;
    private javax.swing.JTextField fieldValorTotal;
    private javax.swing.JFormattedTextField fieldVencimentoParcela;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tableParcelas;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
}
