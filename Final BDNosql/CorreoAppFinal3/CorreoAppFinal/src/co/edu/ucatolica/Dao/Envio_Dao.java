/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Dao;

import co.edu.ucatolica.Bds.JedisCon;
import co.edu.ucatolica.Dto.Envio_Dto;
import co.edu.ucatolica.Dto.Estado_Dto;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import redis.clients.jedis.Jedis;


/**
 *
 * @author Mauricio Rodriguez
 */
public class Envio_Dao implements Serializable {
    
    private Jedis jedis = new Jedis();
    private JedisCon jed = null;
    

    public Envio_Dao() {
        jed = new JedisCon();
        jedis = jed.getConexionBD();
        /*jedis.rpush("", "","","");
        jedis.lrange("", 0, -1);*/
    }

    public Boolean findEnvio(String envio) {
        try {
            return this.jedis.hexists(envio,"codigoPaquete");
        }finally{
            jedis.close();
        }
    }

    public void create(Envio_Dto envio) {
        try {
            Map<String, String> hash = new HashMap();
            hash.put("codigoPaquete", Integer.toString(envio.getCodigoPaquete()));
            hash.put("NombresRemitente", envio.getNombresRemitente());
            hash.put("cedulaRemitente", envio.getCedula());        
            hash.put("edadRemitente", envio.getEdad());
            hash.put("telefonoRemitente", envio.getTeléfono());
            hash.put("NombreDestinatario", envio.getNombreDestinatario());
            hash.put("cedulaDestinatario", envio.getCedula1());        
            hash.put("edadDestinatario", envio.getEdad1());
            hash.put("telefonoDestinatario", envio.getTeléfono1());
            hash.put("Fechaentrega", envio.getFechaentrega());
            hash.put("peso", envio.getPeso());
            hash.put("costo", envio.getCosto());
            hash.put("origen", Integer.toString(envio.getOrigen()));
            hash.put("destino", Integer.toString(envio.getDestino()));
            hash.put("Fechaestimada", envio.getFechaEstimada());
            jedis.hmset(Integer.toString(envio.getCodigoPaquete()), hash);
        }finally{
            jedis.close();
        }
    }

    public boolean edit(Envio_Dto envio) {
        try {
            Map<String, String> hash = new HashMap();
            hash.put("codigoPaquete", Integer.toString(envio.getCodigoPaquete()));
            hash.put("NombresRemitente", envio.getNombresRemitente());
            hash.put("cedulaRemitente", envio.getCedula());        
            hash.put("edadRemitente", envio.getEdad());
            hash.put("telefonoRemitente", envio.getTeléfono());
            hash.put("NombreDestinatario", envio.getNombreDestinatario());
            hash.put("cedulaDestinatario", envio.getCedula1());        
            hash.put("edadDestinatario", envio.getEdad1());
            hash.put("telefonoDestinatario", envio.getTeléfono1()); 
            hash.put("Fechaentrega", envio.getFechaentrega());
            hash.put("peso", envio.getPeso());
            hash.put("costo", envio.getCosto());
            jedis.hmset(Integer.toString(envio.getCodigoPaquete()), hash);
            return true;
        }finally{
            jedis.close();
        }
    }
    
    public void destroy(String nickName) {
        jedis.del(nickName);
    }

    /*public String[] findDatosEnvio(String key) {
        String[] datos = new String[12];
        Set<String > set = jedis.keys("100*");
        String gg = set.toString();
        System.out.println("llave string"+set);
        System.out.print(jedis.hget(gg,"codigoPaquete"));
        System.out.print(jedis.hget(key,"NombresRemitente"));
        datos[0] =  jedis.hget(key,"codigoPaquete");
        datos[1] =  jedis.hget(key,"NombresRemitente");
        datos[2] =  jedis.hget(key,"cedulaRemitente");
        datos[3] =  jedis.hget(key,"edadRemitente");
        datos[4] =  jedis.hget(key,"telefonoRemitente");
        datos[5] =  jedis.hget(key,"NombreDestinatario");
        datos[6] =  jedis.hget(key,"cedulaDestinatario");
        datos[7] =  jedis.hget(key,"edadDestinatario");
        datos[8] =  jedis.hget(key,"telefonoDestinatario");
        datos[9] =  jedis.hget(key,"Fechaentrega");
        datos[10] =  jedis.hget(key,"peso");
        datos[11] = jedis.hget(key,"costo");
        System.out.println(key);
        System.out.println(Arrays.toString(datos));
        return datos;
    }*/
    
    public Envio_Dto findDatosEnvio(String parseInt) {
        Envio_Dto envio2 = new Envio_Dto();
        envio2.setCodigoPaquete( Integer.parseInt(jedis.hget(parseInt,"codigoPaquete")));
        envio2.setNombresRemitente( jedis.hget(parseInt,"NombresRemitente"));
        envio2.setCedula(jedis.hget(parseInt,"cedulaRemitente"));
        envio2.setEdad(jedis.hget(parseInt,"edadRemitente"));
        envio2.setTeléfono(jedis.hget(parseInt,"telefonoRemitente"));
        envio2.setNombreDestinatario(jedis.hget(parseInt,"NombreDestinatario"));
        envio2.setCedula1(jedis.hget(parseInt,"cedulaDestinatario"));
        envio2.setEdad1(jedis.hget(parseInt,"edadDestinatario"));
        envio2.setTeléfono1(jedis.hget(parseInt,"telefonoDestinatario"));
        envio2.setFechaentrega(jedis.hget(parseInt,"Fechaentrega"));
        envio2.setCosto(jedis.hget(parseInt,"peso"));
        envio2.setPeso(jedis.hget(parseInt,"costo"));
        return envio2;
    }

    public List<String> findEnvioEntities() {
       Set<String> set = jedis.keys("100*");
       List<String> list = set.stream().collect(Collectors.toList());
       return list;
    }

    public void createEstado(Estado_Dto envio2) {
        jedis.rpush("estado:"+envio2.getCodigo()+"",envio2.getEstado(),envio2.getObservación(),envio2.getFecha());
    }

    public Estado_Dto findDatosEstado(String respuesta) {
        Estado_Dto envio2 = new Estado_Dto();
        envio2.setCodigo(Integer.parseInt(jedis.hget(respuesta,"codigoPaquete")));
        envio2.setEstado(jedis.hget(respuesta,"NombresRemitente"));
        envio2.setObservación(jedis.hget(respuesta,"cedulaRemitente"));
        envio2.setFecha(jedis.hget(respuesta,"edadRemitente"));
        return envio2;
    }
    
}
