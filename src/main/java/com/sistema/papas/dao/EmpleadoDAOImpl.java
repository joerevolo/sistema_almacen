/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.papas.dao;
import com.sistema.papas.model.Empleado;
import com.sistema.papas.config.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {
    @Override
    public void registrar(Empleado emp){
        Connection conectar=ConexionBD.conectar();
        if (conectar!=null){
            String sql ="INSERT INTO empleados (id,nombre,edad,categoria) VALUES (?,?,?,?)";
            try{
                PreparedStatement pst =conectar.prepareStatement(sql);
                pst.setInt(1, emp.id);
                pst.setString(2, emp.nombre);
                pst.setInt(3, emp.edad);
                pst.setString(4, emp.getCategoria());
                pst.executeUpdate();
                System.out.println("[DAO]Registro exitoso");
                pst.close();
                conectar.close();
            }catch(SQLException e){
                System.out.println("[DAO ERROR] al registrar"+ e.getMessage());
            }
        }
    }
    @Override
    public ArrayList<Empleado>listar(){ 
        ArrayList<Empleado> listaAuxiliar=new ArrayList<>();
        Connection conectar=ConexionBD.conectar();
        if(conectar!=null){
            String sql="SELECT id, nombre, edad,fecha_Creacion, fecha_actualizacion FROM empleados";
            try{
                Statement st=conectar.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next()){
                    Empleado emp=new Empleado(rs.getString("nombre"),rs.getInt("edad"),rs.getInt("id"));
                    emp.setFechaCreacion(rs.getString("fecha_creacion"));
                    emp.setFechaActualizacion(rs.getString("fecha_actualizacion"));
                    listaAuxiliar.add(emp);
                    }
                rs.close();
                st.close();
                conectar.close();
            }catch(SQLException e){
                System.out.println("[DAO]error al listar"+ e.getMessage());
            }
        }
        return listaAuxiliar;
    }
    @Override
    public boolean existeID(int id){
        Connection conectar=ConexionBD.conectar();
        if (conectar!=null){
            String sql="SELECT id FROM empleados WHERE id= ?";
            try{
                PreparedStatement pst=conectar.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs=pst.executeQuery();
                boolean existe=rs.next();
                rs.close();
                pst.close();
                conectar.close();
                return existe;
            }catch(SQLException e){
                System.out.println("[DAO] error al verificar ID"+ e.getMessage());
                
            }
        }
        return false;
    }
    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection cn = ConexionBD.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("[DAO ERROR] al eliminar: " + e.getMessage());
            return false;
        }
    }
    @Override
    public boolean actualizar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, edad = ? WHERE id = ?";
        try (Connection con = ConexionBD.conectar(); // Ajusta según tu conexión
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setInt(2, empleado.getEdad());
            ps.setInt(3, empleado.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
