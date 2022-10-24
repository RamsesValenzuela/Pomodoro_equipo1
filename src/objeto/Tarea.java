/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

/**
 *
 * @author PC
 */
public class Tarea {
    
    private int id;
    private String nombre;
    private int estado;

    
    public Tarea(int id, String nombre, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    
    public Tarea(int id, int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
    
    
}
