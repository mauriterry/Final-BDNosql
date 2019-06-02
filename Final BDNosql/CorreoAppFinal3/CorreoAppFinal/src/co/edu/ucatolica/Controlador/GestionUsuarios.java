/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Controlador;

import co.edu.ucatolica.Dao.Usuario_Dao;
import co.edu.ucatolica.Dto.Usuario_Dto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Rodriguez
 */
public class GestionUsuarios {
    
    private final Usuario_Dao usuarioJpaController;
    private Boolean usuario;
    private String contrasenia;
    private Usuario_Dto Usuario;

    public GestionUsuarios() {
        this.usuarioJpaController = new Usuario_Dao();
        this.usuario = null;

    }

    public boolean existeUsuario(String usuario) {
        this.usuario = usuarioJpaController.findUsuario(usuario);
        return this.usuario == true;
    }

    public boolean validarInicioDeSesion(String usuario, String password) {
        this.usuario = usuarioJpaController.findUsuario(usuario);
        this.contrasenia = usuarioJpaController.findContra(usuario);
        if (this.usuario != null) {
            return this.contrasenia.equals(password);
        } else {
            return false;
        }
    }


    public String[] obtenerDatosDelUsuario() {
        String[] datosUsuario = new String[4];
        if (Usuario != null) {
            datosUsuario[0] = Usuario.getNickname();
            datosUsuario[1] = Usuario.getNombres();
            datosUsuario[2] = Usuario.getApellidos();
            datosUsuario[3] = Usuario.getEmail();
        } else {
            datosUsuario[0] = "";
            datosUsuario[1] = "";
            datosUsuario[2] = "";
            datosUsuario[3] = "";
        }
        return datosUsuario;
    }

    public boolean registrarUsuario(String nombre, String apellido, String nickname, String email, String contrasenia,int tipo) {
        try {
            Usuario = new Usuario_Dto(nombre, apellido, nickname, email, contrasenia,tipo);
            usuarioJpaController.create(Usuario);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarUsuario(String nickName) {
        usuarioJpaController.destroy(nickName);
        return true;
    }

    public void modificarUsuario(String nombre, String apellido, String nickname, String email) {
        Usuario.setNombres(nombre);
        Usuario.setApellidos(apellido);
        Usuario.setNickname(nickname);
        Usuario.setEmail(email);
        usuarioJpaController.edit(Usuario);
        
        
    }

    public int tipoUsuario(String text) {
        return usuarioJpaController.findTipo(text);
    }
}
