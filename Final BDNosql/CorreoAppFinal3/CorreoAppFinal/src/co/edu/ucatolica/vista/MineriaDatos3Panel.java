/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 *
 * @author sala1
 */
public class MineriaDatos3Panel extends javax.swing.JPanel {

    private final PrincipalFrame principalFrame;

    /**
     * Creates new form RegistroPanel
     *
     * @param principalFrame
     */
    public MineriaDatos3Panel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        initComponents();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelMatrizInicial = new javax.swing.JLabel();
        jScrollPaneUsuario1 = new javax.swing.JScrollPane();
        jTextAreaCuidad1 = new javax.swing.JTextArea();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setForeground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Se concluye que en el mes con mas ingresos se convierta en un incentivo para los trabajadores de tal manera que cree un ambiente mas competitivo y amable");
        jLabelTitulo.setEnabled(false);
        jLabelTitulo.setPreferredSize(new java.awt.Dimension(103, 22));
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 590, 160));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 650, 10));

        jLabelMatrizInicial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMatrizInicial.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMatrizInicial.setText("Ingresos por Mes");
        add(jLabelMatrizInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextAreaCuidad1.setEditable(false);
        jTextAreaCuidad1.setColumns(20);
        jTextAreaCuidad1.setRows(5);
        jScrollPaneUsuario1.setViewportView(jTextAreaCuidad1);

        add(jScrollPaneUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 600, 80));

        jLabelTitulo1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("Bienvenidos a la Mineria de Datos");
        jLabelTitulo1.setPreferredSize(new java.awt.Dimension(103, 22));
        add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 290, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelMatrizInicial;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JScrollPane jScrollPaneUsuario1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaCuidad1;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        System.out.println("\n");
        System.out.println("Meses con mas ingresos");
        try {
            Jedis jedis = new Jedis("192.168.56.101");
            jedis.select(0);
            Set<String> llaves=jedis.keys("100*");
           
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            int meses[]= new int[12];
            for (String llave : llaves) {
                System.out.println(llave);
                String entrega=jedis.hget(llave, "Fechaentrega");
                System.out.println(entrega);
                Date entreg = formatoDelTexto.parse(entrega);
                int mes= entreg.getMonth();
                meses[mes]= Integer.parseInt(jedis.hget(llave,"costo"));
                System.out.println(meses[mes]);
            }
                int mayor=0;
                int mes=0;
            for(int i=0;i<12;i++){
                System.out.println("Mes " + (i+1) + "  " + meses[i]);
                    if(mayor< meses[i]){
                        mayor= meses[i];
                        mes=i;
                    }
            }
          jTextAreaCuidad1.append("El mes  " + (mes+1) + " tiene la mayor cantidad de ingresos con " + mayor + " pesos ");
           
        } catch (NumberFormatException | ParseException e) {
            System.out.println(e);
        }
    }

}