/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Mauricio Rodriguez
 */
public class Envio_Dto {
    
    private int codigoPaquete = 0 ;
    private String NombresRemitente = null;
    private String cedula = null;
    private String edad = null;
    private String teléfono = null;
    private String NombreDestinatario = null;
    private String cedula1 = null;
    private String edad1 = null;
    private String teléfono1 = null;
    private String Fechaentrega = null;
    private String peso = null;
    private String costo = null;
    private int origen;
    private int destino;
    private String FechaEstimada;

    public String getFechaEstimada() {
        return FechaEstimada;
    }

    public int[][] getDistancias() {
        return distancias;
    }

    public void setFechaEstimada(String FechaEstimada) {
        this.FechaEstimada = FechaEstimada;
    }

    public void setDistancias(int[][] distancias) {
        this.distancias = distancias;
    }
    
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
            
    
    public Envio_Dto() {
        super();
    }

    public Envio_Dto(int codigoPaquete,String NombresRemitente,String cedula,String edad,String teléfono,String NombreDestinatario,String cedula1,String edad1,String teléfono1, String Fechaentrega,String peso, int origen, int destino) {
       this.codigoPaquete = codigoPaquete;
       this.NombresRemitente = NombresRemitente;
       this.cedula = cedula;
       this.edad = edad;
       this.teléfono = teléfono;
       this.NombreDestinatario = NombreDestinatario;
       this.cedula1 = cedula1;
       this.edad1 = edad1;
       this.teléfono1 = teléfono1;
       this.Fechaentrega = Fechaentrega;
       this.peso = peso;
       this.origen = origen;
       this.destino = destino;
       this.costo = Integer.toString(Integer.parseInt(this.peso)*90000);
       this.FechaEstimada=this.hallarFecha(Fechaentrega, origen, destino, distancias);
    }
    
    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getNombresRemitente() {
        return NombresRemitente;
    }

    public void setNombresRemitente(String NombresRemitente) {
        this.NombresRemitente = NombresRemitente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getNombreDestinatario() {
        return NombreDestinatario;
    }

    public void setNombreDestinatario(String NombreDestinatario) {
        this.NombreDestinatario = NombreDestinatario;
    }

    public String getCedula1() {
        return cedula1;
    }

    public void setCedula1(String cedula1) {
        this.cedula1 = cedula1;
    }

    public String getEdad1() {
        return edad1;
    }

    public void setEdad1(String edad1) {
        this.edad1 = edad1;
    }

    public String getTeléfono1() {
        return teléfono1;
    }

    public void setTeléfono1(String teléfono1) {
        this.teléfono1 = teléfono1;
    }

    public String getFechaentrega() {
        return Fechaentrega;
    }

    public void setFechaentrega(String Fechaentrega) {
        this.Fechaentrega = Fechaentrega;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Envio_Dto{" + "codigoPaquete=" + codigoPaquete + ", NombresRemitente=" + NombresRemitente + ", cedula=" + cedula + ", edad=" + edad + ", tel\u00e9fono=" + teléfono + ", NombreDestinatario=" + NombreDestinatario + ", cedula1=" + cedula1 + ", edad1=" + edad1 + ", tel\u00e9fono1=" + teléfono1 + ", Fechaentrega=" + Fechaentrega + ", peso=" + peso + ", costo=" + costo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codigoPaquete;
        hash = 83 * hash + Objects.hashCode(this.NombresRemitente);
        hash = 83 * hash + Objects.hashCode(this.cedula);
        hash = 83 * hash + Objects.hashCode(this.edad);
        hash = 83 * hash + Objects.hashCode(this.teléfono);
        hash = 83 * hash + Objects.hashCode(this.NombreDestinatario);
        hash = 83 * hash + Objects.hashCode(this.cedula1);
        hash = 83 * hash + Objects.hashCode(this.edad1);
        hash = 83 * hash + Objects.hashCode(this.teléfono1);
        hash = 83 * hash + Objects.hashCode(this.Fechaentrega);
        hash = 83 * hash + Objects.hashCode(this.peso);
        hash = 83 * hash + Objects.hashCode(this.costo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Envio_Dto other = (Envio_Dto) obj;
        if (this.codigoPaquete != other.codigoPaquete) {
            return false;
        }
        if (!Objects.equals(this.NombresRemitente, other.NombresRemitente)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.teléfono, other.teléfono)) {
            return false;
        }
        if (!Objects.equals(this.NombreDestinatario, other.NombreDestinatario)) {
            return false;
        }
        if (!Objects.equals(this.cedula1, other.cedula1)) {
            return false;
        }
        if (!Objects.equals(this.edad1, other.edad1)) {
            return false;
        }
        if (!Objects.equals(this.teléfono1, other.teléfono1)) {
            return false;
        }
        if (!Objects.equals(this.Fechaentrega, other.Fechaentrega)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        return Objects.equals(this.costo, other.costo);
    }
    
    
    
    String hallarFecha(String fechEntrega, int orig, int desti, int matriz[][]){
        String result = "";
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        int dias=matriz[orig-1][desti-1];
        System.out.println("Los dias son " + dias);
        try {
        Date fecha = formatoDelTexto.parse(fechEntrega);
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        result = ""+calendar.getTime().toLocaleString();
        
        } catch (ParseException ex) {
        }
        return result;
    }
    
    void actualizarMatriz(){
        Jedis jedis = new Jedis("192.168.56.101");
        jedis.select(0);
        Set<String> llaves=jedis.keys("100*");
            for (String llave : llaves) {
                
                int orig=Integer.parseInt(jedis.hget(llave, "origen"));
                int dest=Integer.parseInt(jedis.hget(llave, "destino"));
                //de las listas hallo las fechas y la cantidad de dias que se demoro
                String strFecha=jedis.lindex("estado:"+llave, 2);
                String strFecha1=jedis.lindex("estado:"+llave, -1);
                
                Date fecha ;
                Date fecha1 ;
                try {
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
                fecha = formatoDelTexto.parse(strFecha);
                fecha1=formatoDelTexto.parse(strFecha1);
                int cantdias = (int)((fecha1.getTime()-fecha.getTime())/86400000);  
                    //Modificamos la matriz en tal posicion
                    int antiguo=distancias[orig-1][dest-1];
                    int prom= (antiguo+cantdias)/2;
                    distancias[orig-1][dest-1]=prom;
                } catch (ParseException ex) {
                }                
            }
    }
     
    
}

