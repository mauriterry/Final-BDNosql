/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Bds;

import redis.clients.jedis.Jedis;


/**
 *
 * @author sala1
 */
public class JedisCon {

    //address of your redis server
    private static final String redisHost = "192.168.56.101";
    private static Jedis ds ;

    public JedisCon() {
        ds = new Jedis(redisHost);
        ds.ping();
        ds.select(0);   
    }
    
    public Jedis getConexionBD(){
        return ds;
    }
    
}
