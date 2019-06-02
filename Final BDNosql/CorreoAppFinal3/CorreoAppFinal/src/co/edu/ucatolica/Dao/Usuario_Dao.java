/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Dao;

import co.edu.ucatolica.Bds.JedisCon;
import co.edu.ucatolica.Dto.Usuario_Dto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Mauricio Rodriguez
 */
public class Usuario_Dao implements Serializable { 
            
    private Jedis jedis = new Jedis();
    private JedisCon jed = null;
    

    public Usuario_Dao() {
        jed = new JedisCon();
        jedis = jed.getConexionBD();
        /*jedis.rpush("", "","","");
        jedis.lrange("", 0, -1);*/
    }

    
    public Boolean findUsuario(String usuario) {
        System.out.println(jedis.hexists(usuario,"NombreCompleto"));
        return this.jedis.hexists(usuario,"NombreCompleto");   
    }

    public void create(Usuario_Dto usuario) {
        Map<String, String> hash = new HashMap();
        hash.put("NombreCompleto", usuario.getNombres()+ " " + usuario.getApellidos());
        hash.put("correo", usuario.getEmail());
        hash.put("password", usuario.getContraseña());     
        hash.put("tipo",Integer.toString(usuario.getTipo()));
        jedis.hmset(usuario.getNickname(), hash);
    }

    public void destroy(String nickName) {
        jedis.del(nickName);
    }

    public void edit(Usuario_Dto usuario) {
        jedis.del(usuario.getNickname());
        Map<String, String> hash = new HashMap();
        hash.put("NombreCompleto", usuario.getNombres()+ " " + usuario.getApellidos());
        hash.put("correo", usuario.getEmail());
        hash.put("password", usuario.getContraseña());        
        jedis.hmset(usuario.getNickname(), hash);
    }

    public String findContra(String usuario) {
        return jedis.hget(usuario, "password");
    }

    public int findTipo(String text) {
        return Integer.parseInt(jedis.hget(text, "tipo"));
    }
    
}
