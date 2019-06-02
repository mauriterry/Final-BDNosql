/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.mineriaDatos;

import java.util.Scanner;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 *
 * @author MaRu
 */
public class Lolo {

    Jedis jedis = new Jedis("192.168.56.101"); 
    Scanner sc = new Scanner(System.in);
    
    /*public void conection()
    {
    //Connecting to Redis server on localhost 
      Jedis jedis = new Jedis("localhost"); 
      System.out.println("Connection to server sucessfully"); 
      //check whether server is running or not 
      System.out.println("Server is running: "+jedis.ping()); 
    }*/
    public void analitica(){
        
        String  [] nombreloca  = {"Usaquen","Chapinero","Santa fe","San Cristobal","Usme","Tunjuelito","Bosa","Ciudad Kennedy","Fontibon,","Engativa","Suba","Barrios Unidos","Teusaquillo","Los martires","Antonio Nariño","Puente Aranda","Candelaria","Candelaria","Rafael Uribe","Ciudad Bolivar","Sumapaz"};
        System.out.println(""+nombreloca[0]);
        System.out.println(""+jedis.select(2));
        int f,g=0;
        Set<String> com = jedis.keys("*");
        Object [] com2 = com.toArray();
        int []  Origen =  new int [20];
        int [] Destino =  new int [20];
        
        for (Object com21 : com2) {
            System.out.println("------------------------------------");
            System.out.println("Llave:" + com21);
            f = Integer.parseInt(jedis.hget(com21.toString(), "origen"));
            System.out.println("Origen: "+f);
            Origen[f-1]=Origen[f-1] +1;
            f = Integer.parseInt(jedis.hget(com21.toString(), "destino"));
            System.out.println("Destino: "+f);
            Destino[f-1]=Destino[f-1] +1;
            System.out.println("------------------------------------");
        }
       int locadestino =1;
       int locaorigen = 1;
       int posicion2=0;
       int posicion1= 0 ;
       
       
    for(int d=0;d<20;d++){
           if(Destino[d]>0){
               if (Destino[d]>locadestino){
               locadestino=Destino[d];
               posicion1 = d;
               }
           System.out.println("Origen en la posicion " +(d+1)+ " "+Destino[d]);
           //System.out.println("Destno en la posicion " +(d+1)+ " "+Destino[d]);
           }           
    }       System.out.println("Numero localidad: "+(posicion1+1));
        System.out.println(" La localidad en la que mas se entregan paquetes ");
            System.out.println("Numero de paguetes : "+locadestino+" Localidad :"+nombreloca[posicion1]);
        System.out.println("_______________________________________________");
        
   for(int d=0;d<20;d++){
           if(Origen[d]>0){
               if (Origen[d]>locaorigen){
               locaorigen=Origen[d];
               posicion2 = d;
               }
           System.out.println("Origen en la posicion " +(d+1)+ " "+Origen[d]);
           //System.out.println("Destno en la posicion " +(d+1)+ " "+Destino[d]);
           }           
    }       System.out.println("Numero localidad: "+(posicion2+1));
            System.out.println("La localidad en la que mas dejan pedidos para entregar");
            System.out.println("Numero de paguetes : "+locaorigen+" Localidad :"+nombreloca[posicion2]);  
   
}
       
    public static void main(String[] args) {
        Lolo lo = new Lolo();
        lo.analitica();
        
        
    }

    
    
}
