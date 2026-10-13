package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
    public static Connection conexion() {

        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/probas";
            String usuario = "postgres";
            String contrasena = "admin";

            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            return conn;

        } catch (Exception e) {
            System.out.println("Erro na conexión: "+ e.getMessage());
            return null;
        }

    }
}

