package com.sistema.papas.controllers;

import com.sistema.papas.model.Empleado;
import com.sistema.papas.dao.EmpleadoDAOImpl;
import com.sistema.papas.dao.EmpleadoDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/empleados") // Esta será la ruta web
@CrossOrigin(origins = "*")

public class EmpleadoController {
    

    // Instanciamos tu DAO de siempre
    private final EmpleadoDAO empleadoDao = new EmpleadoDAOImpl();

    @GetMapping // Cuando entren por GET (Navegador), se ejecutará esto
    public ArrayList<Empleado> listarEmpleadosWeb() {
        return empleadoDao.listar(); // ¡Spring lo convierte a JSON automáticamente!
    }
    @PostMapping("/registrar")
    public String registrarEmpleadoWeb(@RequestBody Empleado nuevoEmpleado){
        try{
            if (nuevoEmpleado.getNombre()==null || nuevoEmpleado.getNombre().isEmpty()){
                return"{\\\"status\\\": \\\"error\\\", \\\"message\\\": \\\"El nombre no puede estar vacío\\\"}";
                
            }
            empleadoDao.registrar(nuevoEmpleado);
            return "{\"status\": \"success\", \"message\": \"Empleado registrado con éxito\"}";
           
        }catch (Exception e ){
            return "{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}";
   
        }   
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarEmpleado(@PathVariable int id) {
           Map<String, Object> respuesta = new HashMap<>();
           boolean eliminado = empleadoDao.eliminar(id); // ajusta la llamada según tu DAO

           if (eliminado) {
               respuesta.put("status", "success");
               respuesta.put("message", "Empleado eliminado correctamente.");
               return ResponseEntity.ok(respuesta);
           } else {
               respuesta.put("status", "error");
               respuesta.put("message", "No se pudo eliminar el empleado.");
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
           }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, Object>> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoDetalles) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            // Asignamos el ID al objeto que viene del frontend para asegurar que coincida
            empleadoDetalles.setId(id);
            
            // Ejecutamos tu método de actualizar en el DAO (debes asegurarte de tener este método en tu EmpleadoDAO / EmpleadoDAOImpl)
            boolean actualizado = empleadoDao.actualizar(empleadoDetalles);

            if (actualizado) {
                respuesta.put("status", "success");
                respuesta.put("message", "Empleado actualizado correctamente.");
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("status", "error");
                respuesta.put("message", "No se encontró el empleado a actualizar.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
            }
        } catch (Exception e) {
            respuesta.put("status", "error");
            respuesta.put("message", "Error al actualizar: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
    
}