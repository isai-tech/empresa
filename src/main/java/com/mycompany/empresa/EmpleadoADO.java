/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresa;

/**
 *
 * @author isaiv
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoADO {

    /**
     * Consulta la tabla empleados, instancia los objetos Empleado
     * y los retorna en una lista.
     */
    public List<Empleado> consultarEmpleados() {
        List<Empleado> lista = new ArrayList<>();

        String sql = "SELECT id_empleado, id_puesto, Nombre, Apellidos, Fecha_contratacion FROM empleados";

        try (Connection con = ConexionBD.IniciarConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getInt("id_puesto"),
                        rs.getDate("Fecha_contratacion").toLocalDate()
                );

                lista.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar empleados: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }

        return lista;
    }
}
