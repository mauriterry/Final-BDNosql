/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Controlador;

import co.edu.ucatolica.Dao.Envio_Dao;
import co.edu.ucatolica.Dto.Envio_Dto;
import co.edu.ucatolica.Dto.Estado_Dto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MaRu
 */
public class GestionEnvios {
    private final Envio_Dao envioJpaController;
    private Boolean usuario;
    private Envio_Dto envio;

    public GestionEnvios() {
        this.envioJpaController = new Envio_Dao();
        this.usuario = null;
    }

    public boolean existeEnvio(String Envio) {
        this.usuario = envioJpaController.findEnvio(Envio);
        return this.usuario == true;
    }

    public boolean registrarEnvio(int codigoPaquete,String NombresRemitente,String cedula,String edad,String teléfono,String NombreDestinatario,String cedula1,String edad1,String teléfono1, String Fechaentrega,String peso, int origen, int destino) {
        try {
            envio = new Envio_Dto(codigoPaquete, NombresRemitente, cedula, edad, teléfono, NombreDestinatario, cedula1, edad1, teléfono1,  Fechaentrega, peso,origen,destino);
            envioJpaController.create(envio);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarEnvio(String codigoPaquete,String NombresRemitente,String cedula,String edad,String teléfono,String NombreDestinatario,String cedula1,String edad1,String teléfono1,String Fechaentrega,String peso, int origen, int destino) {
        try {
            envio = new Envio_Dto(Integer.parseInt(codigoPaquete), NombresRemitente, cedula, edad, teléfono, NombreDestinatario, cedula1, edad1, teléfono1,  Fechaentrega, peso,origen,destino);
            return envioJpaController.edit(envio);
        } catch (NumberFormatException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminarEnvio(String respuesta) {
        try {
            envioJpaController.destroy(respuesta);
            return this.usuario == true;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /*public String[] obtenerDatosDelEnvio(String respuesta) {
        try {
            System.out.println("obtener datos 2");
            System.out.print(respuesta);
            String[] envio1 = envioJpaController.findDatosEnvio(respuesta);
            System.err.println(Arrays.toString(envio1));
            return envio1;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }*/
    
    public String[] obtenerDatosDelEnvio(String respuesta) {
        try {
            Envio_Dto envio1 = envioJpaController.findDatosEnvio(respuesta);
            String[] datosenvio2 = new String[12];
            datosenvio2[0] = Integer.toString(envio1.getCodigoPaquete());
            datosenvio2[1] = envio1.getNombresRemitente();
            datosenvio2[2] = envio1.getCedula();
            datosenvio2[3] = envio1.getEdad();
            datosenvio2[4] = envio1.getTeléfono();
            datosenvio2[5] = envio1.getNombreDestinatario();
            datosenvio2[6] = envio1.getCedula1();
            datosenvio2[7] = envio1.getEdad1();
            datosenvio2[8] = envio1.getTeléfono1();
            datosenvio2[9] = envio1.getFechaentrega();
            datosenvio2[10] = envio1.getPeso();
            datosenvio2[11] = envio1.getCosto();
            return datosenvio2;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String EnvioToString() {
        String envios = "";
        List<String> listaDeEnvios = envioJpaController.findEnvioEntities();
        for (int i = 0; i < listaDeEnvios.size(); i++) {
            envios += listaDeEnvios.get(i);
        }
        return envios;
    }

    public int cantidadDeUsuarios() {
        return envioJpaController.findEnvioEntities().size();
    }

    public String[] obtenerUsuariosToStringArray() {
        String enviosToString[] = new String[cantidadDeUsuarios()];
        List<String> listaDeEnvios = envioJpaController.findEnvioEntities();
        for (int i = 0; i < listaDeEnvios.size(); i++) {
            enviosToString[i] = listaDeEnvios.get(i);
        }
        return enviosToString;
    }

    public boolean añadirEstado(String id, String EstadoActual, String Observaciones,String Fechaentrega) {
        Estado_Dto envio2 = new Estado_Dto(id, EstadoActual, Observaciones,Fechaentrega);
        envioJpaController.createEstado(envio2);
        return true;
    }

    public String[] obtenerDatosDelEstado(String respuesta) {
        try {
            Estado_Dto envio1 = envioJpaController.findDatosEstado(respuesta);
            String[] datosenvio2 = new String[4];
            datosenvio2[0] = Integer.toString(envio1.getCodigo());
            datosenvio2[1] = envio1.getEstado();
            datosenvio2[2] = envio1.getObservación();
            datosenvio2[3] = envio1.getFecha();
            return datosenvio2;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
