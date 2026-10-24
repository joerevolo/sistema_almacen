/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.papas.dao;

import com.sistema.papas.model.Usuario;


public interface UsuarioDAO {
    Usuario login(String email,String pasword);
    boolean registrar (Usuario usuario);
    boolean existeEmail(String email);
}
    
