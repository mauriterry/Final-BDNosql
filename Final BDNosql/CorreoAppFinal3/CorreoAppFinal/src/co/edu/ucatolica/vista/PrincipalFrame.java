/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.vista;

import co.edu.ucatolica.Controlador.GestionEnvios;
import co.edu.ucatolica.Controlador.GestionUsuarios;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Mauricio Rodriguez
 */
public final class PrincipalFrame extends JFrame{
    
    //relaciones
    private HomePanelAdministrador homePanel;
    private InicioDeSesionPanel inicioDeSesionPanel;
    private RegistroPanel registroPanel;
    private RegistroEnvioPanel registroEnvioPanel;
    private GestionEstadoPanel gestionEstadoPanel;
    private MineriaDatosPanel mineriaDatosPanel;
    private MineriaDatos2Panel mineriaDatos2Panel;
    private MineriaDatos3Panel mineriaDatos3Panel;
    private RegistroEstadoPanel registroEstadoPanel;
    private HomePanelRegistrador homePanelRegistrador;
    private GestionEnviosPanel gestionEnviosPanel;
    private VentanaDialog ventanaDialog;
    
    private final GestionUsuarios gestionUsuarios;
    private final GestionEnvios gestionEnvios;
    //componentes
    //menubar
    private JMenuBar jMenuBarMenuPrincipal;
    //menu archivo
    private JMenu jMenuArchivo;
    //menu items de archivo
    private JMenuItem jMenuItemPerfil;
    private JMenuItem jMenuItemCerrarSesion;
    private JMenuItem jMenuItemSalir;
    private JMenuItem jMenuItemHome;
    private JMenuItem jMenuItemHome1;
    //menu Ayuda
    private JMenu jMenuAyuda;
    //menu items de Ayuda
    private JMenuItem jMenuItemVersion;
    private JMenuItem jMenuItemSoporte;
    
    /**
     * metodo main
     *
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        PrincipalFrame principal = new PrincipalFrame();
    }
    
     /**
     * Metodo Constructor
     */
    public PrincipalFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sistema de Gestion de Mensajeria ");
        this.setIconImage(new ImageIcon("src/recursos/imagenes/iconos/sgm.png").getImage());
        this.setResizable(false);
        this.setVisible(false);
        //iniciar ralacion con la logica
        this.gestionUsuarios = new GestionUsuarios();
        this.gestionEnvios = new GestionEnvios();
        //inicia caracteristicas del Frame
        this.irAInicioDeSesion();
    }
    
    /**
     * inicia los componentes del frame, en este caso el menu bar y sus botones
     * y sus eventos.
     */
    private void iniciarComponentesDePrincipal() {
        this.setJMenuBar(null);
        this.jMenuBarMenuPrincipal = new JMenuBar();
        this.jMenuArchivo = new JMenu();
        this.jMenuItemPerfil = new JMenuItem();
        this.jMenuItemCerrarSesion = new JMenuItem();
        this.jMenuItemSalir = new JMenuItem();
        this.jMenuItemHome = new JMenuItem();
        this.jMenuAyuda = new JMenu();
        this.jMenuItemVersion = new JMenuItem();
        this.jMenuItemSoporte = new JMenuItem();
        //this.jMenuArchivo.setText("Archivo");
        this.jMenuArchivo.setIcon(new ImageIcon("src/recursos/imagenes/iconos/archivo.png"));
        this.jMenuItemHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        this.jMenuItemHome.setText("Home");
        this.jMenuItemHome.setIcon(new ImageIcon("src/recursos/imagenes/iconos/home.png"));
        this.jMenuItemHome.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemHomeActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemHome);
        this.jMenuItemCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        this.jMenuItemCerrarSesion.setText("Cerrar Sesion");
        this.jMenuItemCerrarSesion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/cerrarSesion.png"));
        this.jMenuItemCerrarSesion.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemCerrarSesionActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemCerrarSesion);
        this.jMenuItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        this.jMenuItemSalir.setText("Salir");
        this.jMenuItemSalir.setIcon(new ImageIcon("src/recursos/imagenes/iconos/salir.png"));
        this.jMenuItemSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemSalirActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemSalir);
        this.jMenuBarMenuPrincipal.add(jMenuArchivo);
        //this.jMenuAyuda.setText("Ayuda");
        this.jMenuAyuda.setIcon(new ImageIcon("src/recursos/imagenes/iconos/ayuda.png"));
        this.jMenuItemVersion.setText("Version");
        this.jMenuItemVersion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/version.png"));
        this.jMenuItemVersion.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemVersionActionPerformed(evt);
        });
        this.jMenuAyuda.add(jMenuItemVersion);
        this.jMenuItemSoporte.setText("Soporte");
        this.jMenuItemSoporte.setIcon(new ImageIcon("src/recursos/imagenes/iconos/soporte.png"));
        this.jMenuItemSoporte.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemSoporteActionPerformed(evt);
        });
        this.jMenuAyuda.add(jMenuItemSoporte);
        this.jMenuBarMenuPrincipal.add(jMenuAyuda);
        this.setJMenuBar(jMenuBarMenuPrincipal);
    }
    
    //metodos de eventos del menu bar    
    private void jMenuItemHomeActionPerformed(ActionEvent evt) {
        irAHome();
    }
    
    private void jMenuItemHomeRegistroActionPerformed(ActionEvent evt) {
        irAHomePanelRegistrador();
    }

    private void jMenuItemSalirActionPerformed(ActionEvent evt) {
        salir();
    }

    private void jMenuItemVersionActionPerformed(ActionEvent evt) {
        mostrarVersion();
    }

    private void jMenuItemSoporteActionPerformed(ActionEvent evt) {
        mostrarSoporte();
    }
    
    private void jMenuItemCerrarSesionActionPerformed(ActionEvent evt) {
        irAInicioDeSesion();
    }
    
    //metodos de navegacion
    protected void salir() {
        System.exit(0);
    }

    private void quitarPanelesDelMarco() {
        setVisible(false);
        if (homePanel != null) {
            remove(homePanel);
            homePanel = null;
        }
        if (registroEnvioPanel != null) {
            remove(registroEnvioPanel);
            registroEnvioPanel = null;
        }
        if (gestionEnviosPanel != null) {
            remove(gestionEnviosPanel);
            gestionEnviosPanel = null;
        }
        if (homePanelRegistrador != null) {
            remove(homePanelRegistrador);
            homePanelRegistrador = null;
        }
        if (registroEstadoPanel != null) {
            remove(registroEstadoPanel);
            registroEstadoPanel = null;
        }
        if (mineriaDatosPanel != null) {
            remove(mineriaDatosPanel);
            mineriaDatosPanel = null;
        }
        if (mineriaDatos2Panel != null) {
            remove(mineriaDatos2Panel);
            mineriaDatos2Panel = null;
        }
        if (mineriaDatos3Panel != null) {
            remove(mineriaDatos3Panel);
            mineriaDatos3Panel = null;
        }
        if (gestionEstadoPanel != null) {
            remove(gestionEstadoPanel);
            gestionEstadoPanel = null;
        }
        
        
    }

    private void iniciarMarco() {
        //inicia los componentes del frame
        this.quitarPanelesDelMarco();
        this.iniciarComponentesDePrincipal();
        this.setVisible(true);
    }
    
    private void iniciarMarco2() {
        //inicia los componentes del frame
        this.quitarPanelesDelMarco();
        this.iniciarComponentesDePrincipal2();
        this.setVisible(true);
    }

    protected void cerrarVentana() {
        ventanaDialog.dispose();
        ventanaDialog = null;
    }

    private void iniciarVentana() {
        if (ventanaDialog != null) {
            cerrarVentana();
        }
        setVisible(false);
    }

    private void mostrarVersion() {
        JOptionPane.showMessageDialog(this, "Version: 1.0@beta", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarSoporte() {
        JOptionPane.showMessageDialog(this, "Soporte: cmrodriguez67@ucatolica.edu.co", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void irAInicioDeSesion() {
        iniciarVentana();
        inicioDeSesionPanel = new InicioDeSesionPanel(this);
        Image imagen = new ImageIcon("src/recursos/imagenes/iconos/inicioDeSesion.png").getImage();
        ventanaDialog = new VentanaDialog(this, inicioDeSesionPanel, "Ventana", false, false, imagen, DO_NOTHING_ON_CLOSE);
    }
    
    protected void irARegistro() {
        iniciarVentana();
        registroPanel = new RegistroPanel(this);
        Image imagen = new ImageIcon("src/recursos/imagenes/iconos/registro.png").getImage();
        ventanaDialog = new VentanaDialog(this, registroPanel, "Registro", false, false, imagen, DO_NOTHING_ON_CLOSE);
    }
    
    protected void irARegistroEnvioPanel() {
        iniciarMarco();
        //agrega el panelinicial
        registroEnvioPanel = new RegistroEnvioPanel(this);
        registroEnvioPanel.setVisible(true);
        add(registroEnvioPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAGestionEnvioPanel() {
        iniciarMarco();
        //agrega el panelinicial
        gestionEnviosPanel = new GestionEnviosPanel(this);
        gestionEnviosPanel.setVisible(true);
        add(gestionEnviosPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irARegistroEstadoPanel() {
        iniciarMarco2();
        //agrega el panelinicial
        registroEstadoPanel = new RegistroEstadoPanel(this);
        registroEstadoPanel.setVisible(true);
        add(registroEstadoPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAMineriaDatosPanel() {
        iniciarMarco();
        //agrega el panelinicial
        mineriaDatosPanel = new MineriaDatosPanel(this);
        mineriaDatosPanel.setVisible(true);
        add(mineriaDatosPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAMineriaDatos2Panel() {
        iniciarMarco();
        //agrega el panelinicial
        mineriaDatos2Panel = new MineriaDatos2Panel(this);
        mineriaDatos2Panel.setVisible(true);
        add(mineriaDatos2Panel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAMineriaDatos3Panel() {
        iniciarMarco();
        //agrega el panelinicial
        mineriaDatos3Panel = new MineriaDatos3Panel(this);
        mineriaDatos3Panel.setVisible(true);
        add(mineriaDatos3Panel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAHomePanelRegistrador() {
        iniciarMarco2();
        //agrega el panelinicial
        homePanelRegistrador = new HomePanelRegistrador(this);
        homePanelRegistrador.setVisible(true);
        add(homePanelRegistrador);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    protected void irAGestionEstadoPanel() {
        iniciarMarco2();
        //agrega el panelinicial
        gestionEstadoPanel = new GestionEstadoPanel(this);
        gestionEstadoPanel.setVisible(true);
        add(gestionEstadoPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
       
    protected void irAHome() {
        iniciarMarco();
        //agrega el panelinicial
        homePanel = new HomePanelAdministrador(this);
        homePanel.setVisible(true);
        add(homePanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }
    
    //GestionUsuario    
    protected boolean existeUsuario(String usuario) {
        return gestionUsuarios.existeUsuario(usuario);
    }

    protected boolean verificarClaveUsuario(String usuario, String password) {
        return gestionUsuarios.validarInicioDeSesion(usuario, password);
    }
    
    protected boolean registrarUsuario(String nombre, String apellido, String nickname, String email, String contrasenia, int tipo) {
        return gestionUsuarios.registrarUsuario(nombre, apellido, nickname, email, contrasenia,tipo);
    }

    protected String[] obtenerDatosUsuario() {
        return gestionUsuarios.obtenerDatosDelUsuario();
    }
    
    protected String obtenerNickName() {
        return gestionUsuarios.obtenerDatosDelUsuario()[0];
    }

    protected void modificarCambiosUsuario(String nombre, String apellido, String nickname, String email) {
        gestionUsuarios.modificarUsuario(nombre, apellido, nickname, email);
    }
    
    //GestionEnvios    
    protected boolean existeEnvio(String usuario) {
        return gestionEnvios.existeEnvio(usuario);
    }

    protected boolean registrarEnvio(int codigoPaquete,String NombresRemitente,String cedula,String edad,String teléfono,String NombreDestinatario,String cedula1,String edad1,String teléfono1, String Fechaentrega,String peso, int origen, int destino) {
        return gestionEnvios.registrarEnvio(codigoPaquete, NombresRemitente, cedula, edad, teléfono, NombreDestinatario, cedula1, edad1, teléfono1,  Fechaentrega, peso,origen,destino);
    }

    protected String[] obtenerDatosDelEnvio(String respuesta) {
        return gestionEnvios.obtenerDatosDelEnvio(respuesta);
    }
   
    protected boolean modificarEnvio(String codigoPaquete,String NombresRemitente,String cedula,String edad,String teléfono,String NombreDestinatario,String cedula1,String edad1,String teléfono1,String Fechaentrega,String peso, int origen, int destino) {        System.err.println("---"+codigoPaquete+"----");
        return gestionEnvios.modificarEnvio(codigoPaquete, NombresRemitente, cedula, edad, teléfono, NombreDestinatario, cedula1, edad1, teléfono1, Fechaentrega, peso,origen,destino);
    }

    protected boolean EliminarEnvio(String respuesta) {
        return gestionEnvios.eliminarEnvio(respuesta);
    }

    protected String obtenerEnviosToString() {
        return gestionEnvios.EnvioToString();
    }

    protected int cantidadDeEnvios() {
        return gestionEnvios.cantidadDeUsuarios();
    }

    protected String[] obtenerEnviosToStringArray() {
        return gestionEnvios.obtenerUsuariosToStringArray();
    }

    protected int tipoUsuario(String text) {
        return gestionUsuarios.tipoUsuario(text);
    }

    protected boolean añadirEstado(String id, String EstadoActual, String Observaciones,String Fechaentrega) {
        return gestionEnvios.añadirEstado(id,EstadoActual,Observaciones,Fechaentrega);
    }

    private void iniciarComponentesDePrincipal2() {
        this.setJMenuBar(null);
        this.jMenuBarMenuPrincipal = new JMenuBar();
        this.jMenuArchivo = new JMenu();
        this.jMenuItemPerfil = new JMenuItem();
        this.jMenuItemCerrarSesion = new JMenuItem();
        this.jMenuItemSalir = new JMenuItem();
        this.jMenuItemHome1 = new JMenuItem();
        this.jMenuAyuda = new JMenu();
        this.jMenuItemVersion = new JMenuItem();
        this.jMenuItemSoporte = new JMenuItem();
        //this.jMenuArchivo.setText("Archivo");
        this.jMenuArchivo.setIcon(new ImageIcon("src/recursos/imagenes/iconos/archivo.png"));
        this.jMenuItemHome1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        this.jMenuItemHome1.setText("Home");
        this.jMenuItemHome1.setIcon(new ImageIcon("src/recursos/imagenes/iconos/home.png"));
        this.jMenuItemHome1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemHomeRegistroActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemHome1);
        this.jMenuItemCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        this.jMenuItemCerrarSesion.setText("Cerrar Sesion");
        this.jMenuItemCerrarSesion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/cerrarSesion.png"));
        this.jMenuItemCerrarSesion.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemCerrarSesionActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemCerrarSesion);
        this.jMenuItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        this.jMenuItemSalir.setText("Salir");
        this.jMenuItemSalir.setIcon(new ImageIcon("src/recursos/imagenes/iconos/salir.png"));
        this.jMenuItemSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemSalirActionPerformed(evt);
        });
        this.jMenuArchivo.add(jMenuItemSalir);
        this.jMenuBarMenuPrincipal.add(jMenuArchivo);
        //this.jMenuAyuda.setText("Ayuda");
        this.jMenuAyuda.setIcon(new ImageIcon("src/recursos/imagenes/iconos/ayuda.png"));
        this.jMenuItemVersion.setText("Version");
        this.jMenuItemVersion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/version.png"));
        this.jMenuItemVersion.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemVersionActionPerformed(evt);
        });
        this.jMenuAyuda.add(jMenuItemVersion);
        this.jMenuItemSoporte.setText("Soporte");
        this.jMenuItemSoporte.setIcon(new ImageIcon("src/recursos/imagenes/iconos/soporte.png"));
        this.jMenuItemSoporte.addActionListener((java.awt.event.ActionEvent evt) -> {
            jMenuItemSoporteActionPerformed(evt);
        });
        this.jMenuAyuda.add(jMenuItemSoporte);
        this.jMenuBarMenuPrincipal.add(jMenuAyuda);
        this.setJMenuBar(jMenuBarMenuPrincipal);
    }

    protected String[] obtenerDatosDelEstado(String respuesta) {
        return gestionEnvios.obtenerDatosDelEstado(respuesta);
    }

}
