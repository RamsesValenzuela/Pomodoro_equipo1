/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class Tarea {
    
    private int id;
    private String nombre;
    private int estado;
    private LocalDateTime fechaDeTerminacion;
    private int prioridad;

    
    public Tarea(int id, String nombre, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Tarea(int id, String nombre, int estado, LocalDateTime fechaDeTerminacion, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaDeTerminacion = fechaDeTerminacion;
        this.prioridad = prioridad;
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    public Tarea(int id) {
        this.id = id;
    }

    
    public Tarea(int id, int estado) {
        this.id = id;
        this.estado = estado;
    }

    public LocalDateTime getFechaDeTerminacion() {
        return fechaDeTerminacion;
    }

    public void setFechaDeTerminacion(LocalDateTime fechaDeTerminacion) {
        this.fechaDeTerminacion = fechaDeTerminacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
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
