/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.papas.dao;
import com.sistema.papas.model.Usuario;
import com.sistema.papas.dao.UsuarioDAO;
import com.sistema.papas.config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {
    @Override
    public Usuario login(String email,String pasword){
        String sql="SELECT * FROM usuarios WHERE email=? AND pasword=?";
        try (Connection cn=ConexionBD.conectar();
             PreparedStatement ps=cn.prepareStatement(sql)){
                ps.setString(1,email);
                ps.setString(2,pasword);
            
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                    return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("pasword"),
                    rs.getString("rol")
                    );
                }
            }
        }catch (SQLException e){
            System.out.println("[DAO ERROR]al verificar email: " +e.getMessage());
        }return null;
    }
    @Override
    public boolean existeEmail(String email) {
        String sql = "SELECT id FROM usuarios WHERE email = ?";
        try (Connection cn = ConexionBD.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("[DAO ERROR] al verificar email: " + e.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean registrar(Usuario usuario){
        String sql="INSERT INTO usuarios (nombre, email, pasword, rol)VALUES(?,?,?,?)";
        try(Connection cn=ConexionBD.conectar();
        PreparedStatement ps=cn.prepareStatement(sql)){
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getPasword());
            ps.setString(4,usuario.getRol() !=null ? usuario.getRol():"USER");
            
            return ps.executeUpdate()>0;
        }catch(SQLException e){
                System.out.println("[DAO ERROR]al registrar usuario"+ e.getMessage());
                return false;
                }
    }
}
