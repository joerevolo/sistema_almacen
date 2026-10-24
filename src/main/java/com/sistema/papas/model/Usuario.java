package com.sistema.papas.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class Usuario {
    private Integer id;
    private String nombre;
    private String email;
    private String pasword;
    private String rol;
    
    public Usuario(){}
    public Usuario(Integer id,String nombre,String email,String pasword,String rol){
        this.id=id;
        this.nombre=nombre;
        this.email=email;
        this.pasword=pasword;
        this.rol=rol;
        
    }
    //GETTERS Y SETTER
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    
    public String getPasword(){return pasword;}
    public void setPasword(String pasword){this.pasword=pasword;}
    
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    
    public String getRol(){return rol;}
    public void setRol(String rol){this.rol=rol;}
    
    
}
