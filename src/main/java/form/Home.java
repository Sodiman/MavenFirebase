/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import manager.UserManager;
import model.User;
import model.UserTableModel;

/**
 *
 * @author Ody
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    UserManager userManager;
    private final TableColumnModel tcm;
    private final Map hiddenColumns;

    public Home() {
        initComponents();

        userManager = new UserManager();

        tcm = jTable1.getColumnModel();
        hiddenColumns = new HashMap();
        keylbl.setVisible(false);

        tableModelOnClick();
        configJFrame();
        read();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        read = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        akses = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        keylbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Maven Firebase");

        read.setText("REFRESH");
        read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Email", "Akses", "Key"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Email");

        jLabel5.setText("Akses");

        akses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin", "" }));

        btn_save.setText("SAVE");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        keylbl.setText("key");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username)
                                .addComponent(password)
                                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(akses, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(keylbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(read, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(akses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(read)
                    .addComponent(keylbl))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
        // TODO add your handling code here:
        read();
    }//GEN-LAST:event_readActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            // TODO add your handling code here:
            create();
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> akses;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel keylbl;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton read;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    private void read() {
        List<User> list = userManager.getAll();
        UserTableModel userTableModel = new UserTableModel(list);
        jTable1.setModel(userTableModel);

        btn_save.setEnabled(true);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        selesai();
        hide("Key");
    }

    private void create() throws InterruptedException, ExecutionException, TimeoutException {
        User u = new User();
        u.setUsername(username.getText());
        u.setPassword(password.getText());
        u.setEmail(email.getText());
        u.setAkses(akses.getModel().getSelectedItem().toString());
        u.setKey(UserManager.random());

        if (userManager.save(u)) {
            JOptionPane.showMessageDialog(null, "Save data berhasil");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal..!!!");
        }

        read();
    }

    private void update() {
        String kunci = keylbl.getText();

        User u = new User();
        u.setUsername(username.getText());
        u.setPassword(password.getText());
        u.setEmail(email.getText());
        u.setAkses(akses.getModel().getSelectedItem().toString());
        u.setKey(kunci);

        if (userManager.update(u)) {
            JOptionPane.showMessageDialog(null, "Update data berhasil");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal..!!!");
        }

        read();
    }

    private void delete() {
        String kunci = keylbl.getText();
        if (userManager.deleteBy(kunci)) {
            JOptionPane.showMessageDialog(null, "Hapus data berhasil");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal..!!!");
        }

        read();
    }

    private void tableModelOnClick() {
        jTable1.getSelectionModel().addListSelectionListener((e) -> {
            int rowSelected = jTable1.getSelectedRow();
            if (rowSelected > -1) {
                username.setText(jTable1.getModel().getValueAt(rowSelected, 0).toString());
                password.setText(jTable1.getModel().getValueAt(rowSelected, 1).toString());
                email.setText(jTable1.getModel().getValueAt(rowSelected, 2).toString());
                akses.getModel().setSelectedItem(jTable1.getModel().getValueAt(rowSelected, 3).toString());
                keylbl.setText(jTable1.getModel().getValueAt(rowSelected, 4).toString());
                btn_save.setEnabled(false);
                btn_update.setEnabled(true);
                btn_delete.setEnabled(true);
            }
        });

    }

    private void selesai() {
        username.setText("");
        password.setText("");
        email.setText("");
        akses.getModel().setSelectedItem("user");
    }

    private void hide(String columnName) {

        int index = tcm.getColumnIndex(columnName);
        TableColumn column = tcm.getColumn(index);
        hiddenColumns.put(columnName, column);
        hiddenColumns.put(":" + columnName, index);
        tcm.removeColumn(column);
    }

    public void show(String columnName) {
        Object o = hiddenColumns.remove(columnName);
        if (o == null) {
            return;
        }
        tcm.addColumn((TableColumn) o);
        o = hiddenColumns.remove(":" + columnName);
        if (o == null) {
            return;
        }
        int column = ((Integer) o);
        int lastColumn = tcm.getColumnCount() - 1;
        if (column < lastColumn) {
            tcm.moveColumn(lastColumn, column);
        }
    }

    private void configJFrame() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"   Ya   ", "Tidak"};
                int PromptResult = JOptionPane.showOptionDialog(null, "<html><center>Pastikan koneksi internet terhubung sebelum anda keluar,"
                        + "<br>agar data anda tersimpan di server.<br>Anda yakin keluar ?</center></html>", "Peringatan", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
