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
public class OperacionesPlaylist {

    Cancion cabeza;
    Cancion cola;

    public OperacionesPlaylist() {

        cabeza = cola = null;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public void AgregarCancion(String nombre) {

        Cancion nuevaCancion = new Cancion(nombre);
        if (isEmpty()) {
            cabeza = cola = nuevaCancion;
            nuevaCancion.setSiguienteCancion(nuevaCancion);
        } else {
            nuevaCancion.setSiguienteCancion(cabeza);
            cola.setSiguienteCancion(nuevaCancion);
            cabeza = nuevaCancion;
        }

    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (cabeza == cola) {
            cabeza = null;
        } else {
            cola.setSiguienteCancion(cabeza.getSiguienteCancion());
            cabeza = cabeza.getSiguienteCancion();
        }
    }

    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("No exiten datos por borrar...");
        } else if (cabeza == cola) {
            cabeza = null;
        } else {
            Cancion current = this.cabeza;
            while (current.getSiguienteCancion() != cola) {
                current = current.getSiguienteCancion();
            }
            current.setSiguienteCancion(cabeza);
            cola = current;
        }
    }

    public void BorrarCancion(String nombre) throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else if (cabeza == cola) {
            cabeza = null;
        } else if (!exist(nombre)) {
            throw new Exception("El dato no existe en la play list");
        } else {
            Cancion current = this.cabeza;
            if (nombre.compareTo(cabeza.getNombreCancion()) == 0) {
                delete();
            } else if (nombre.compareTo(cola.getNombreCancion()) == 0) {
                deleteLast();
            }
            do {
                if (current.getSiguienteCancion().getNombreCancion().compareTo(nombre) == 0) {
                    current.setSiguienteCancion(current.getSiguienteCancion().getSiguienteCancion());
                }
                current = current.getSiguienteCancion();
            } while (current != cabeza && current != cola);
        }
    }

    private boolean exist(String nombre) {
        if (isEmpty()) {
            return false;
        } else {
            Cancion current = this.cabeza;
            do {
                if (current.getNombreCancion().compareTo(nombre) == 0) {
                    return true;
                }
                current = current.getSiguienteCancion();
            } while (current != cabeza);
            return false;
        }
    }

    public void update(String name, String newName) throws Exception {
        if (isEmpty()) {
            throw new Exception("No hay canciones para actualizar, la play list esta vacia...");
        } else if (!exist(name)) {
            throw new Exception("La cancion no existe...");
        } else {
            Cancion current = this.cabeza;
            do {
                if (current.getNombreCancion().compareTo(name) == 0) {
                    current.setNombreCancion(newName);
                }
                current = current.getSiguienteCancion();
            } while (current != cabeza);
        }
    }

    public String autoPlay() throws Exception {
        String data = "";

        Cancion current = this.cabeza;
        if (isEmpty()) {
            throw new Exception("La playLisy esta vacia...");
        } else {
            do {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                data += current.getNombreCancion() ;
                current = current.getSiguienteCancion();
            } while (current != this.cabeza);
        }
        return data;
    }

    public String showPlayList() {
        String data = "";
        Cancion current = this.cabeza;
        do {
            data += current.getNombreCancion();
            current = current.getSiguienteCancion();
        } while (current != cabeza);

        return data;
    }

    public String Aleatorio() {

        return null;
    }

}
