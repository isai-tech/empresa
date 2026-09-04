/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empresa;

/**
 *
 * @author isaiv
 */
import com.mycompany.empresa.daoempresa.ClienteDAO;
import com.mycompany.empresa.daoempresa.EmpleadoDAO;
import com.mycompany.empresa.daoempresa.MarcasDAO;
import java.util.List;

public class Empresa {

    public static void main(String[] args) {

        // --- Prueba de Clientes ---
        ClienteDAO daoCliente = new ClienteDAO();
        List<Cliente> cl = daoCliente.listarTodos();
        System.out.println("=== Lista de Clientes ===");
        for (Cliente c : cl) {
            System.out.println(c.getNombre());
        }

        // --- Prueba de Empleados ---
        EmpleadoDAO daoEmpleado = new EmpleadoDAO();
        List<Empleado> emp = daoEmpleado.listarTodos();
        System.out.println("=== Lista de Empleados ===");
        for (Empleado e : emp) {
            System.out.println(e.getDescripcion());
        }
        
        MarcasDAO daoMarca = new MarcasDAO();
        List<Marca> mc = daoMarca.listarTodos();
        System.out.println("=== Lista de Marcas ===");
        for (Marca m : mc) {
            System.out.println(m.getNombre());
        }   
    }
}