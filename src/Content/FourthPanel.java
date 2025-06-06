/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Content;

import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author RadityaaR
 */
public class FourthPanel extends javax.swing.JPanel {

    /**
     * Creates new form FourthPanel
     */
    public FourthPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RiwayatTransaksi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTampilRiwayat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textRiwayat = new javax.swing.JTextArea();
        btnHapusRiwayat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        RiwayatTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Riwayat Transaksi");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout RiwayatTransaksiLayout = new javax.swing.GroupLayout(RiwayatTransaksi);
        RiwayatTransaksi.setLayout(RiwayatTransaksiLayout);
        RiwayatTransaksiLayout.setHorizontalGroup(
            RiwayatTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RiwayatTransaksiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        RiwayatTransaksiLayout.setVerticalGroup(
            RiwayatTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RiwayatTransaksiLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btnTampilRiwayat.setText("Refresh");
        btnTampilRiwayat.setAlignmentY(0.0F);
        btnTampilRiwayat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTampilRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilRiwayatActionPerformed(evt);
            }
        });

        textRiwayat.setColumns(20);
        textRiwayat.setRows(5);
        jScrollPane2.setViewportView(textRiwayat);

        btnHapusRiwayat.setText("Hapus");
        btnHapusRiwayat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapusRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusRiwayatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RiwayatTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnTampilRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btnHapusRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(RiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTampilRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilRiwayatActionPerformed
        try {
            StringBuilder isi;
            try (java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.FileReader("riwayat_transaksi.txt")
            )) {
                isi = new StringBuilder();
                String baris;
                while ((baris = reader.readLine()) != null) {
                    isi.append(baris).append("\n");
                }       }

    textRiwayat.setText(isi.toString());
} catch (IOException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Gagal membaca file: " + e.getMessage());
}

    }//GEN-LAST:event_btnTampilRiwayatActionPerformed

    private void btnHapusRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusRiwayatActionPerformed
        try {
            try (java.io.FileWriter fw = new java.io.FileWriter("riwayat_transaksi.txt")) {
                fw.write(""); // kosongkan isi file
            } // kosongkan isi file
    textRiwayat.setText(""); // kosongkan tampilan area teks
    JOptionPane.showMessageDialog(this, "Riwayat transaksi berhasil dihapus.");
} catch (HeadlessException | IOException e) {
    JOptionPane.showMessageDialog(this, "Gagal menghapus riwayat: " + e.getMessage());
}

    }//GEN-LAST:event_btnHapusRiwayatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RiwayatTransaksi;
    private javax.swing.JButton btnHapusRiwayat;
    private javax.swing.JButton btnTampilRiwayat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textRiwayat;
    // End of variables declaration//GEN-END:variables
}
