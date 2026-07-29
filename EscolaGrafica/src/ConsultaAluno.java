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
        
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
    
    private void ativarCampos(){
        txtNome.setEnabled(true);
        txtTurma.setEnabled(true);
        txtEmail.setEnabled(true);
        
        btnEditar.setEnabled(true);
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
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTurma = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        txtTurma.setBorder(javax.swing.BorderFactory.createTitledBorder("Turma"));

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        btnLocalizar.setText("🔎 Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnEditar.setText("🖊️ Editar");

        btnExcluir.setText("🗑️ Excluir");

        btnAtualizar.setText("🔄️ Atualizar");

        btnLimpar.setText("❌ Limpar");

        btnFechar.setText("🚪 Fechar");

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
        jScrollPane1.setViewportView(tabelaAlunos);

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
                            .addComponent(txtEmail))
                        .addGap(431, 431, 431))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLocalizar))
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFechar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
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
       if(txtId.getText().trim().isEmpty()){
          JOptionPane.showMessageDialog(this,"Digite o ID do Aluno");
          return;
       }
       
       try{
         
           int id = Integer.parseInt(txtId.getText().trim());
           Aluno aluno = new Aluno();
           
           Aluno encontrado = aluno.buscarPorId(id);
           
           if (encontrado != null){
               txtNome.setText(encontrado.getNome());
               txtTurma.setText(encontrado.getTurma());
               txtEmail.setText(encontrado.getEmail());
               ativarCampos();
               JOptionPane.showMessageDialog(this, "Aluno localizado com sucuesso");
           } else{
               JOptionPane.showMessageDialog(this, "Aluno não Encontrado");
               limparCampos();
           }
            
       } catch (NumberFormatException erro){
           JOptionPane.showMessageDialog(this,"Digite um ID númerico Válido.");
       }
    }//GEN-LAST:event_btnLocalizarActionPerformed


    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new ConsultaAluno().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTurma;
    // End of variables declaration//GEN-END:variables
}
