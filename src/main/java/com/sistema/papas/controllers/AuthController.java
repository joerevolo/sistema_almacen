/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.papas.controllers;


import com.sistema.papas.model.Usuario;
import com.sistema.papas.dao.UsuarioDAO;
import com.sistema.papas.dao.UsuarioDAOImpl;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UsuarioDAO usuarioDAO=new UsuarioDAOImpl();
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String,String>credenciales){
        Map<String,Object> respuesta =new HashMap<>();
        String email=credenciales.get("email");
        String pasword=credenciales.get("pasword");
            
        Usuario user =usuarioDAO.login(email,pasword);
        if(user !=null){
            respuesta.put("status","succes");
            respuesta.put("message","Inicio de sesion exitoso");
            
            user.setPasword(null);
            respuesta.put("usuario",user);
            return ResponseEntity.ok(respuesta);
        }else{
            respuesta.put("status","error");
            respuesta.put("message","correo o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
        }
    }
    @PostMapping("/registro")
    public ResponseEntity<Map<String,Object>> registro(@RequestBody Usuario nuevoUsuario){
        Map<String,Object> respuesta =new HashMap<>();
        if (usuarioDAO.existeEmail(nuevoUsuario.getEmail())){
            respuesta.put("status","error");
            respuesta.put("message","El correo ya esta registrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }
        boolean creado =usuarioDAO.registrar(nuevoUsuario);
        if(creado){
            respuesta.put("status","success");
            respuesta.put("message","Usuario registrado correctamente");
            return ResponseEntity.ok(respuesta);
        }else{
            respuesta.put("status","success");
            respuesta.put("message","usuario no se puede registrear");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
}
