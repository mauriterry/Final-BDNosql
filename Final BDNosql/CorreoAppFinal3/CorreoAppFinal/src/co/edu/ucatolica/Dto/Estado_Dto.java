/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.Dto;

import java.util.Objects;

/**
 *
 * @author MaRu
 */
public class Estado_Dto {
    private int codigo = 0;    
    private String estado = null;
    private String fecha = null;
    private String Observación = null;

    public Estado_Dto(String id, String EstadoActual, String Observaciones,String Fechaentrega) {
        this.codigo = Integer.parseInt(id);
        this.estado = EstadoActual;
        this.Observación = Observaciones;
        this.fecha = Fechaentrega;
    }

    public Estado_Dto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getObservación() {
        return Observación;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.fecha);
        hash = 29 * hash + Objects.hashCode(this.Observación);
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
        final Estado_Dto other = (Estado_Dto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.Observación, other.Observación)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado_Dto{" + "codigo=" + codigo + ", estado=" + estado + ", fecha=" + fecha + ", Observaci\u00f3n=" + Observación + '}';
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param Observación the Observación to set
     */
    public void setObservación(String Observación) {
        this.Observación = Observación;
    }
    
    
}
