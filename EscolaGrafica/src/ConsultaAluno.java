import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaAluno extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsultaAluno.class.getName());

    private void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Turma");
        modelo.addColumn("Email");
        
        Aluno aluno = new Aluno();
        
        ArrayList<Aluno> lista = aluno.listar();
        
        for (Aluno item: lista){
            modelo.addRow(new Object[]{
              item.getId(),
              item.getNome(),
              item.getTurma(),
              item.getEmail()
            });
        }
        
        tabelaAlunos.setModel(modelo);
    }

    
    
    
    
    private void desativarCampos(){
        txtNome.setEnabled(false);
        txtTurma.setEnabled(false);
        txtEmail.setEnabled(false);
        
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
    
    private void ativarCampos(){
        txtNome.setEnabled(true);
        txtTurma.setEnabled(true);
        txtEmail.setEnabled(true);
        
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }
    
    private void limparCampos(){
        txtId.setText("");
        txtNome.setText("");
        txtTurma.setText("");
        txtEmail.setText("");
        
        txtId.requestFocus();
    }
    
    public ConsultaAluno() {
        initComponents();
        carregarTabela();
        desativarCampos();
        txtId.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTurma = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        cbTipoConsulta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        txtTurma.setBorder(javax.swing.BorderFactory.createTitledBorder("Turma"));

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        btnLocalizar.setText("🔎 Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnAlterar.setText("🖊️ Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnExcluir.setText("🗑️ Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnAtualizar.setText("🔄️ Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        btnLimpar.setText("❌ Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);

        btnFechar.setText("🚪 Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlunos);

        cbTipoConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Turma", "Email" }));
        cbTipoConsulta.setSelectedIndex(-1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                        .addContainerGap(392, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLocalizar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId)
                        .addComponent(btnLocalizar))
                    .addComponent(cbTipoConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar)
                    .addComponent(btnLimpar)
                    .addComponent(btnFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
       String tipo = cbTipoConsulta.getSelectedItem().toString();
             
       String valor = txtId.getText().trim();
       
           
       if (valor.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Informe um valor para a Pesquisa.",
                                      "Campo Obrigatório",JOptionPane.WARNING_MESSAGE);
           txtId.requestFocus();
           return;
       }
       
       if (tipo.equals("ID")) {
           try{
              Integer.parseInt(valor);  
       } catch (NumberFormatException erro){
           JOptionPane.showMessageDialog(this,"Para Pesquisar por ID, digite apenas nuemros",
                   "ID Inválido", JOptionPane.WARNING_MESSAGE);
           txtId.requestFocus();
           return ;
       }
       }
       
       Aluno aluno = new Aluno();
       
       ArrayList<Aluno> lista = aluno.localizar(tipo, valor);
       
       if (lista.isEmpty()){
           JOptionPane.showMessageDialog(this,"Nenhum aluno foi encontrado.",
                    "Resultado da Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
           txtId.requestFocus();
           return;
       }
       
       if (lista.size() == 1){
           tabelaAlunos.setRowSelectionInterval(0,0);
       }
       
       JOptionPane.showMessageDialog(this,lista.size() + " aluno(s) encontrado(s)",
                                      "Consulta Concluida",
                                      JOptionPane.INFORMATION_MESSAGE);
       
       preencherTabela(lista);
       
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         if (txtId.getText().trim().isEmpty()
              || txtNome.getText().trim().isEmpty()
              || txtTurma.getText().trim().isEmpty()
              || txtEmail.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Preecha todos os campos");
            return;
         }
         
         int resposta = JOptionPane.showConfirmDialog(
                         this,
                         "Deseja alterar os dados deste aluno?",
                         "Confirmação",
                         JOptionPane.YES_NO_OPTION
                         );
         if (resposta != JOptionPane.YES_OPTION){
            return;
         }
         
         int id = Integer.parseInt(txtId.getText().trim());
         String nome = txtNome.getText().trim();
         String turma = txtTurma.getText().trim();
         String email = txtEmail.getText().trim();
         
         Aluno aluno = new Aluno();
         
         boolean alterado = aluno.alterar(id, nome, turma, email);
         
         if (alterado){
            JOptionPane.showMessageDialog(this, "Aluno Alterado com Sucesso!");
            carregarTabela();
            limparCampos();
         } else {
             JOptionPane.showMessageDialog(this,"Não foi possivel alterar o Aluno");
         }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
            if (txtId.getText().trim().isEmpty()){
               JOptionPane.showMessageDialog(this,"Prrencha o Campo ID");
               return;
            }
            int resposta = JOptionPane.showConfirmDialog(
                                       this,
                                       "Deseja realmente excluir este Aluno?",
                                       "Confirmação",
                                       JOptionPane.YES_NO_OPTION);
            
            if (resposta != JOptionPane.YES_OPTION){
                return;
            }
            int id = Integer.parseInt(txtId.getText().trim());
            
            Aluno aluno = new Aluno();
            
            boolean excluido = aluno.excluir(id);
            
            if (excluido){
                JOptionPane.showMessageDialog(this,"Aluno Excluido com Sucesso!");
                carregarTabela();
                limparCampos();
                desativarCampos();
            } else{
              JOptionPane.showMessageDialog(this,"Não foi possivel excluir este Aluno");
            }
            

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void preencherTabela(ArrayList<Aluno> lista){
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaAlunos.getModel();
        modelo.setRowCount(0);
        
        for (Aluno aluno : lista){
             modelo.addRow(new Object[]{
                  aluno.getId(),
                  aluno.getNome(),
                  aluno.getTurma(),
                  aluno.getEmail()}
             );
        }
    }
    
    
    
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarTabela();
        limparCampos();
        desativarCampos();
        
    JOptionPane.showMessageDialog(
            this,
            "Tabela atualizada."
    );
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        desativarCampos();
       
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked
        int linha = tabelaAlunos.getSelectedRow();
        
        if ( linha>= 0){
            txtId.setText(tabelaAlunos.getValueAt(linha,0).toString());
            txtNome.setText(tabelaAlunos.getValueAt(linha,1).toString());
            txtTurma.setText(tabelaAlunos.getValueAt(linha,2).toString());
            txtEmail.setText(tabelaAlunos.getValueAt(linha,3).toString());
            
            ativarCampos();
        }
    }//GEN-LAST:event_tabelaAlunosMouseClicked


    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new ConsultaAluno().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cbTipoConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTurma;
    // End of variables declaration//GEN-END:variables
}
