package com.sistema.papas.dao;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import com.sistema.papas.model.Empleado;
import com.sistema.papas.model.Empleado;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public interface EmpleadoDAO {
        public void registrar(Empleado emp);
        ArrayList<Empleado> listar();
        boolean existeID(int id);
        boolean eliminar(int id);
        public boolean actualizar(Empleado empleado);
    
 
}
