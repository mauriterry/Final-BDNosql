/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mauricio Rodriguez
 */
public class Usuario_Dto implements Serializable{
    
    private String nombres = null;;
    private String apellidos = null;
    private String nickname = null;
    private String email = null; 
    private String contraseña = null;
    private int tipo = 0;

    public Usuario_Dto(String nombre, String apellido, String nickname, String email, String contrasenia,int tipo) {
        this.nombres = nombre;
        this.apellidos = apellido;
        this.nickname = nickname;
        this.email = email;
        this.contraseña = contrasenia;
        this.tipo =tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
