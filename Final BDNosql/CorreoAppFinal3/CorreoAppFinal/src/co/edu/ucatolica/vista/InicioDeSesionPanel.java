/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.vista;

import javax.swing.JOptionPane;

/**
 *
 * @author sala3
 */
public class InicioDeSesionPanel extends javax.swing.JPanel {

    private final PrincipalFrame principalFrame;

    /**
     * Creates new form InicioDeSesionPanel
     *
     * @param principalFrame 
     */
    public InicioDeSesionPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
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

        jLabelTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelClave = new javax.swing.JLabel();
        jPasswordFieldClave = new javax.swing.JPasswordField();
        jButtonIngresar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAyuda = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Bienvenidos a Correo APP");
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 11, -1, -1));

        jLabelUsuario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");
        add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, 10));

        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 46, 334, -1));

        jLabelClave.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabelClave.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClave.setText("Clave:");
        add(jLabelClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 40, 10));

        jPasswordFieldClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldClaveActionPerformed(evt);
            }
        });
        add(jPasswordFieldClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 72, 334, -1));

        jButtonIngresar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, -1));

        jButtonCancelar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 110, 90, -1));

        jButtonAyuda.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });
        add(jButtonAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 110, 90, -1));

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 110, 90, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        pasarAClave();
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jPasswordFieldClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldClaveActionPerformed
        ingresar();
    }//GEN-LAST:event_jPasswordFieldClaveActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        ingresar();
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        salir();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed
        ayuda();
    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registrar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldClave;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        jPasswordFieldClave.setText("");
        jTextFieldUsuario.setText("");
        jTextFieldUsuario.requestFocus();
    }

    private boolean validar() {
        if (jTextFieldUsuario.getText().equals("")) {
            return false;
        } else if (jPasswordFieldClave.getPassword().length == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void ingresar() {
        if (validar()) {
            if (principalFrame.existeUsuario(jTextFieldUsuario.getText())) {
                String password = new String(jPasswordFieldClave.getPassword());
                int a = principalFrame.tipoUsuario(jTextFieldUsuario.getText());
                if (principalFrame.verificarClaveUsuario(jTextFieldUsuario.getText(), password)) {
                    limpiar();
                    principalFrame.cerrarVentana();
                    if(a==1){
                        principalFrame.irAHome();
                    }else{
                        principalFrame.irAHomePanelRegistrador();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Inicio de sesion", JOptionPane.WARNING_MESSAGE);
                    limpiar();
                }
            } else {
                    JOptionPane.showConfirmDialog(this, "El usuario no existe", "Inicio de sesión", JOptionPane.WARNING_MESSAGE);
                    limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Falta algun valor", "Ayuda", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void salir() {
        int cerrar = JOptionPane.showConfirmDialog(this, "Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cerrar == 0) {
            JOptionPane.showMessageDialog(this, "Gracias!\nVuelva pronto", "Salir", JOptionPane.INFORMATION_MESSAGE);
            principalFrame.salir();
        } else {
            limpiar();
        }
    }

    private void pasarAClave() {
        jPasswordFieldClave.requestFocus();
    }

    private void ayuda() {
        String mensaje = "Debe contar con una cuenta en el sistema.\n"
                + "Si no la tiene, digite los valores y elija la opcion ingresar,\n"
                + "ahi lo llevara a la creacion de la cuenta.\n"
                + "En el caso de que tenga cuenta y haya olvidado sus datos,\n"
                + "pongase en contacto con: admin@sgm.com";
        JOptionPane.showMessageDialog(this, mensaje, "Ayuda", JOptionPane.QUESTION_MESSAGE);
    }

    private void registrar() {
        principalFrame.irARegistro();
    }

}
