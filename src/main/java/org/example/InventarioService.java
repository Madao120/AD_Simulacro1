package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventarioService {



    // UPDATE ALL
    public void actualizar(int descuento) {

        String sql = "UPDATE anime SET porcentaxeoferta = ?";

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, descuento);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
}
