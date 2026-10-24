/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.papas.model;

import com.sistema.papas.config.Configuracion;

/**
 *
 * @author PC
 */
public class Empleado {
    public String nombre;
    public int edad;
    public int id;
    private String fechaCreacion;
    private String fechaActualizacion;
    
    public Empleado(){
                    
    }
    public Empleado(String nombre, int edad, int id){
        this.nombre = nombre;
        this.edad=edad;
        this.id =id;       
    }
    public String getCategoria(){
        if (this.edad>=Configuracion.EDAD_SENIOR){
            return "SENIOR";
        }else{
            return "JUNIOR";
        }
    }
   
    
    //---GETTERS---
    public int getId() {
    return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; 
    }
    
    //SETTERS
    public void setId(int id){
        this.id=id;
    }
    public void setNombre(String nombre){
    this.nombre=nombre;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public String getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(String fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; 
    }
}
