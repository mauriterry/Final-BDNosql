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
import javax.swing.JOptionPane;
import redis.clients.jedis.Jedis;

/**
 *
 * @author nosqllorena
 */
public class CorreoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        try {
            Jedis jedis = new Jedis("192.168.56.101");
            jedis.select(2);
            System.out.println("Connection successful");
            //System.out.println("Server Info" + jedis.info());
            //System.out.println("Datos" + jedis.lrange("probando:10001", 0, -1));
            //System.out.println("Datos" + jedis.hvals("10001"));
            String [] localidades={"Usaquén","Chapinero","Santa Fe", "San Critóbal", "Usme",
            "Tunjuelito","Bosa","Ciudad Kennedy","Frontibón","Engativa","Suba","Barrios Unidos",
            "Teusaquillo","Los Mártiles", "Antonio Nariño", "Puente Aranda", "Candelaria",
            "Rafael Uribe", "Ciudad Bolivar", "Sumapáz"};
           //Matriz hecha
            int distancias[][]={{1,0,16,20,8,20,14,16,18,14,11,5,15,14,15,3,4,3,6,4}, {16,1,17,16,13,6,2,6,15,6,6,3,2,17,12,11,6,15,12,3},
               {0,18,1,14,7,7,11,15,16,14,3,2,15,20,17,8,3,18,11,2}, {1,18,9,1,16,18,1,10,2,10,6,0,9,7,13,20,10,15,20,1},
               {8,12,0,4,1,13,4,9,14,11,6,11,4,3,16,12,17,12,1,19}, {2,3,13,17,10,1,4,1,13,0,13,6,7,7,7,11,1,18,14,6},
               {4,12,17,4,0,8,1,12,19,4,11,13,5,2,15,4,8,12,19,2}, {0,12,9,11,11,13,19,1,20,8,0,14,17,12,13,7,8,0,4,9}, 
               {10,11,13,17,12,20,18,14,1,3,14,2,17,17,8,18,10,3,8,20}, {20,18,3,14,10,18,16,14,13,1,11,16,20,3,6,13,19,9,9,16},
               {10,17,12,0,14,19,16,19,10,14,1,8,9,3,19,0,14,0,0,9}, {0,6,5,12,20,0,10,16,1,4,2,1,0,8,9,2,0,16,5,2},
               {18,15,18,14,20,17,20,6,11,5,7,20,1,16,11,11,11,19,15,6}, {17,13,20,8,9,10,19,2,20,1,16,0,11,1,5,17,18,9,18,20},
               {8,7,14,19,13,8,5,19,1,0,20,6,11,20,1,2,12,13,14,1}, {1,19,11,3,7,11,0,13,10,16,11,13,5,19,7,1,15,7,13,19},
               {0,20,17,20,6,12,15,2,7,10,15,2,12,0,5,13,1,20,16,20}, {14,16,20,3,4,4,15,17,12,4,19,14,19,4,8,2,3,1,13,13},
               {13,10,18,4,13,6,6,20,14,3,17,16,4,18,7,19,11,19,1,17}, {0,3,10,1,8,5,12,9,17,0,13,0,7,7,19,20,9,17,5,1}};
            /*
            int distancias[][]= new int[20][20];
            Random randito = new Random();
            for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                    if(i==j){
                        distancias[i][j]=1;
                    }else{
                        distancias[i][j]=randito.nextInt(20+1);
                    }                
                }
            }
            */
            for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                     System.out.print(distancias[i][j]+"  ");
                }
                System.out.print("\n");
            }           
            System.out.print("-----------------------------------");
            //Llamamos objetos
            //Validamos
            String NombresRemitente;
            String cedula;
            int edad;
            long telefono;
            String NombresDestinatario;
            String cedula2;
            int edad2;
            long telefono2;    
            
            float peso;
            int origen;
            int destino;
            double costo;
            String FechaEstimada;
            
            
            boolean valido =false;
            while(valido==false){
                String Fechaentrega=JOptionPane.showInputDialog("Ingrese fecha de entrega dd/MM/yyyy hh:mm");
                valido=validarFecha(Fechaentrega);
            }
            
            
            /*//Llenamos 1 objeto- Costo y FechaEstimada calculadas          
             paque = new Paquete("Marta Alejandra", "22200013", 14, 398764345 , 
                    "Rodrigo Rojas", "22200014", 23, 399949190, "28/11/2017 13:00", 1.0f, 1, 4);
            paque.hallarFecha(paque.getFechaentrega(), paque.getOrigen(), paque.getDestino(), distancias);
            System.out.println("Probamos " + paque.getFechaEstimada() +  " costo " + paque.getCosto());
            */       
            //Llaves de paquetes- Mineria de datos;
            Set<String> llaves=jedis.keys("100*");
            for (String llave : llaves) {
                
                int orig=Integer.parseInt(jedis.hget(llave, "origen"));
                int dest=Integer.parseInt(jedis.hget(llave, "destino"));
                //de las listas hallo las fechas y la cantidad de dias que se demoro
                String strFecha=jedis.lindex("estado:"+llave, 2);
                String strFecha1=jedis.lindex("estado:"+llave, -1);
                
                Date fecha = null;
                Date fecha1 = null;
                try {
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
                fecha = formatoDelTexto.parse(strFecha);
                fecha1=formatoDelTexto.parse(strFecha1);
                int cantdias = (int)((fecha1.getTime()-fecha.getTime())/86400000);  
                    //Modificamos la matriz en tal posicion
                    System.out.println(cantdias + " Cantidad dias");
                    int antiguo=distancias[orig-1][dest-1];
                    System.out.println(antiguo + " antiguo ");
                    int prom= (antiguo+cantdias)/2;
                    System.out.println(prom + "Nuevo prom");
                    distancias[orig-1][dest-1]=prom;
                    System.out.println(distancias[orig-1][dest-1] + " probando");
                    for(int i=0;i<20;i++){
                        for(int j=0;j<20;j++){
                            System.out.print(distancias[i][j] + "   ");
                        }
                    System.out.println("\n");
                    }
                } catch (ParseException ex) {
                ex.printStackTrace();
                }                
            }
             System.out.println("\n");
             System.out.println("Matriz actualizada");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    
    
    
}
