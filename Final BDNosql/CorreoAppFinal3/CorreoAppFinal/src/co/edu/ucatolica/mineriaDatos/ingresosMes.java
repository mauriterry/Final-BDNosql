/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.mineriaDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 *
 * @author MaRu
 */
public class ingresosMes {
    public static void main(String[] args){
        System.out.println("\n");
        System.out.println("Meses con mas ingresos");
        try {
            Jedis jedis = new Jedis("192.168.56.101");
            jedis.select(0);
            Set<String> llaves=jedis.keys("1*");
           
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
          System.out.println("El mes  " + (mes+1) + " tiene la mayor cantidad de ingresos con " + mayor + " pesos ");
           
        } catch (NumberFormatException | ParseException e) {
            System.out.println(e);
        }
    }
}
