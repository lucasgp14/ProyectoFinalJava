/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControladorInicio;

/**
 *
 * @author Lucas
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaInicio() {
        initComponents();
        setLocationRelativeTo(null);
        labelError.setVisible(false);
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
        campoUsuario = new javax.swing.JTextField();
        botonIngreso = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        campoContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Inicio de Sesión");

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoUsuario.setForeground(new java.awt.Color(153, 153, 153));
        campoUsuario.setText("Usuario");
        campoUsuario.setToolTipText("");
        campoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoUsuarioMouseClicked(evt);
            }
        });

        botonIngreso.setBackground(new java.awt.Color(255, 255, 255));
        botonIngreso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        botonIngreso.setText("Ingresar");
        botonIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresoActionPerformed(evt);
            }
        });

        labelError.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        labelError.setForeground(new java.awt.Color(255, 0, 0));
        labelError.setText("Usuario y/o contraseña incorrecto/s");

        campoContraseña.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        campoContraseña.setForeground(new java.awt.Color(153, 153, 153));
        campoContraseña.setText("Contraseña");
        campoContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoContraseñaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoUsuario)
                            .addComponent(campoContraseña)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(botonIngreso))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(labelError)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonIngreso)
                .addGap(18, 18, 18)
                .addComponent(labelError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresoActionPerformed
        ControladorInicio s = new ControladorInicio();
        s.inicioSesion(campoUsuario.getText(), campoContraseña.getText(), labelError);
        campoUsuario.setText("");
        campoContraseña.setText("");
    }//GEN-LAST:event_botonIngresoActionPerformed

    private void campoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoUsuarioMouseClicked
        campoUsuario.setText("");
        campoUsuario.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_campoUsuarioMouseClicked

    private void campoContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoContraseñaMouseClicked
        campoContraseña.setText("");
        campoContraseña.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_campoContraseñaMouseClicked

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngreso;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelError;
    // End of variables declaration//GEN-END:variables
}
