package co.edu.ucatolica.mineriaDatos;


import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lio
 */
public class Lista extends javax.swing.JFrame {

    /**
     * Creates new form Lista
     */
    public Lista() {
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

        comloca = new javax.swing.JComboBox<>();
        Navegar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comloca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usaquen", "Chapinero", "Santa Fe", "San Cristobal", "Usme", "Tunjuelito", "Bosa", "Ciudad Kennedy", "Fontibon ", "Engativa", "Suba", "Barrios Unidos", "Teusaquillo", "Los Martirez", "Antonio Nariño", "Puente Aranda", "Candelaria ", "Rafael Uribe", "Ciudad Bolivar ", "Sumapaz" }));
        comloca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comlocaActionPerformed(evt);
            }
        });

        Navegar.setText("Abrir Navegador");
        Navegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavegarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(comloca, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(Navegar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Navegar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comloca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comlocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comlocaActionPerformed
        
    }//GEN-LAST:event_comlocaActionPerformed

    private void NavegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavegarActionPerformed
        
        Direcciones1 dr = new Direcciones1();
        int f = comloca.getSelectedIndex();
        
        if(f==0){
        String a0 = dr.Usaquen;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(IOException err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==1){
        String a1 = dr.Chapinero;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a1);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==2){
        String a2 = dr.SantaFe;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a2);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==3){
        String a3 = dr.SanCristobal;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a3);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==4){
            String a4 = dr.Usme;
         try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a4);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==5){
        String a5 = dr.Tunjueito;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a5);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==6){
        String a6 = dr.Bosa;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a6);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==7){
        String a0 = dr.CiudadKennedy;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==8){
        String a0 = dr.Fontibon;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==9){
        String a0 = dr.Engativa;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==10){
        String a0 = dr.Suba;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==11){
        String a0 = dr.BarriosUnidos;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==12){
        String a0 = dr.Teusaquillo;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }if(f==13){
        String a0 = dr.LosMartires;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==14){
        String a0 = dr.AntonioNarino;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==15){
        String a0 = dr.PuenteAranda;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==16){
        String a0 = dr.Candelaria;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==17){
        String a0 = dr.RafaelUribe;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==18){
        String a0 = dr.CiudadBolivar;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
        if(f==19){
        String a0 = dr.Sumapaz;
          try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +a0);
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null,"Error: "+err);
                }
        
        }
    }//GEN-LAST:event_NavegarActionPerformed

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
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Navegar;
    private javax.swing.JComboBox<String> comloca;
    // End of variables declaration//GEN-END:variables
}
