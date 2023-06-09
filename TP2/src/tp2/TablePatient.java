/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tp2;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Naratama
 */
public class TablePatient extends javax.swing.JInternalFrame {

    /**
     * Creates new form TableDataPatient
     */
    Object[][] data = new Object[][] {
            {},
            {},
            {},
            {},
            {}
    };

    public TablePatient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ButtonDelete = new javax.swing.JButton();
        ButtonUpdate = new javax.swing.JButton();

        try {
            String query = "SELECT * FROM patients ORDER BY id;";
            ResultSet rs = JdbcConn.connection.createStatement().executeQuery(query);

            ArrayList<Object[]> rows = new ArrayList<>();
            while (rs.next()) {
                Object[] row = new Object[6]; // create a new row array with 6 columns
                row[0] = rs.getInt("id"); // assuming the first column in the table is 'id'
                row[1] = rs.getString("nama"); // assuming the second column in the table is 'nama'
                row[2] = rs.getString("nik"); // assuming the third column in the table is 'nik'
                row[3] = rs.getString("tanggal_lahir"); // assuming the third column in the table is 'nik'
                row[4] = rs.getString("alamat"); // assuming the fourth column in the table is 'alamat'
                rows.add(row);
            }
            data = new Object[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                data[i] = rows.get(i);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                data,
                new String[] {
                        "No", "Nama", "NIK", "Tanggal Lahir", "Alamat"
                });
        Table.setModel(model);
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table.setAutoscrolls(true);
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.setRowHeight(30);
        Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Table.setShowGrid(true);
        jScrollPane1.setViewportView(Table);
        Table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(0).setPreferredWidth(15);
            Table.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        ButtonDelete.setText("Delete");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonUpdate.setText("Update");
        ButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ButtonDelete)
                                        .addComponent(ButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ButtonDelete)
                                                .addGap(18, 18, 18)
                                                .addComponent(ButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(292, 292, 292)))
                                .addGap(12, 12, 12)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ButtonUpdateActionPerformed
        // TODO add your handling code here:
        int index = Table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data-nya terlebih dahulu");
        } else {
            System.out.println(data[index]);
            for (int i = 0; i < 4; i++) {
                System.out.println(data[index][i]);
            }

            String id = data[index][0].toString();
            String nama = data[index][1].toString();
            String nik = data[index][2].toString();
            String tanggal = data[index][3].toString();
            String alamat = data[index][4].toString();
            String[] input = { id, nama, nik, tanggal, alamat };

            FormUpdatePatient dataForm = new FormUpdatePatient(input);
            dataForm.setVisible(true);
            this.getParent().add(dataForm);
            TP2.page = "FormUpdate";
            this.dispose();
        }
    }// GEN-LAST:event_ButtonUpdateActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showConfirmDialog(this, "Silahkan Konfirmasi?", null, JOptionPane.YES_NO_OPTION);
        if (Table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data-nya terlebih dahulu");
        } else if (JOptionPane.YES_OPTION == jawab) {
            int index = Table.getSelectedRow();
            Object id = data[index][0];
            try {
                String query = "DELETE FROM patients WHERE id = " + id + ";";
                JdbcConn.connection.createStatement().execute(query);
                this.setVisible(false);
                this.dispose();
            } catch (SQLException e) {
                System.out.print(e);
            }
        }

    }// GEN-LAST:event_ButtonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonUpdate;
    private final javax.swing.JTable Table = new javax.swing.JTable();
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
