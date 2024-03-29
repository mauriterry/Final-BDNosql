/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.vista;

import static co.edu.ucatolica.mineriaDatos.CorreoApp.validarFecha;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class GestionEstadoPanel extends javax.swing.JPanel {
    
    private final PrincipalFrame principalFrame;

    /**
     * Creates new form PrincipalPanel
     *
     * @param principalFrame
     */
    public GestionEstadoPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        initComponents();
        //Todo
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
        jSeparator2 = new javax.swing.JSeparator();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelEstadoActual = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        jTextFieldObservaciones = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        comlocaOrigen = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Gestion de Estado");
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 380, 10));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Codigo Paquete:");
        add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });
        add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 150, -1));

        jLabelEstadoActual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEstadoActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstadoActual.setText("Estado Actual Del Paquete");
        add(jLabelEstadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabelObservaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelObservaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabelObservaciones.setText("Observaciones del Paquete");
        add(jLabelObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, -1));
        add(jTextFieldObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 150, -1));

        jButtonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCrear.setText("Añadir Estado");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        comlocaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usaquen", "Chapinero", "Santa Fe", "San Cristobal", "Usme", "Tunjuelito", "Bosa", "Ciudad Kennedy", "Fontibon ", "Engativa", "Suba", "Barrios Unidos", "Teusaquillo", "Los Martirez", "Antonio Nariño", "Puente Aranda", "Candelaria ", "Rafael Uribe", "Ciudad Bolivar ", "Sumapaz" }));
        comlocaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comlocaOrigenActionPerformed(evt);
            }
        });
        add(comlocaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        crearAudios();
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void comlocaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comlocaOrigenActionPerformed

    }//GEN-LAST:event_comlocaOrigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comlocaOrigen;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEstadoActual;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldObservaciones;
    // End of variables declaration//GEN-END:variables

    private void crearAudios() {
        if (validar()) {
            String id = jTextFieldId.getText();
            String Fechaentrega ="";
            if (principalFrame.existeEnvio(id)) {
                boolean valido =false;
                while(valido==false){
                    Fechaentrega=JOptionPane.showInputDialog("Ingrese fecha de entrega dd/MM/yyyy hh:mm");
                    valido=validarFecha(Fechaentrega);
                }
                String EstadoActual = Integer.toString(comlocaOrigen.getSelectedIndex());
                String Observaciones = jTextFieldObservaciones.getText();                    
                if (principalFrame.añadirEstado(id, EstadoActual, Observaciones,Fechaentrega)) {
                    limpiar();
                    JOptionPane.showMessageDialog(this, "El Estado se creo correctamente", "Crear Estado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El Estado no se pudo crear", "Crear Estado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Paquete no existe", "Crear Estado", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Faltan Datos necesarios para la creacion del Estado", "Crear Estado", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpiar() {
        jTextFieldId.setText("");
        jTextFieldId.setEnabled(true);
        jTextFieldObservaciones.setText("");
    }

    
    private boolean validar() {
        if (jTextFieldId.getText().equals("")) {
            return false;
        } else if (jTextFieldObservaciones.getText().equals("")) {
            return false;
        } else {
            try {
                Integer.parseInt(jTextFieldId.getText());
                return true;
            } catch (NumberFormatException | NullPointerException e) {
                return false;
            }
        }
    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
}
