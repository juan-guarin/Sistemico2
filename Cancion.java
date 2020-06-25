/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juan.guarin.juan.gutierrez;

/**
 *
 * @author Juanes Guarin
 */
public class Cancion {
    private String NombreCancion;
    private Cancion SiguienteCancion;

    public Cancion(String NombreCancion, Cancion SiguienteCancion) {
        this.NombreCancion = NombreCancion;
        this.SiguienteCancion = SiguienteCancion;
    }

    public Cancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }

    /**
     * @return the NombreCancion
     */
    public String getNombreCancion() {
        return NombreCancion;
    }

    /**
     * @param NombreCancion the NombreCancion to set
     */
    public void setNombreCancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }

    /**
     * @return the SiguienteCancion
     */
    public Cancion getSiguienteCancion() {
        return SiguienteCancion;
    }

    /**
     * @param SiguienteCancion the SiguienteCancion to set
     */
    public void setSiguienteCancion(Cancion SiguienteCancion) {
        this.SiguienteCancion = SiguienteCancion;
    }
    
    
    
}
