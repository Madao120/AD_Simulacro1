package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoxogoService {

    private static ArrayList<Videoxogo> videoxogoList;
    private Videoxogo xogo;

    // READ ALL
    public static ArrayList<Videoxogo> ListarTodo(){
        String sql = "SELECT * FROM videoxogo";
        ArrayList<Videoxogo> videoxogoList = new ArrayList<>();

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()){


            while (resultSet.next()){
                videoxogoList.add(new Videoxogo(
                                resultSet.getString("titulo"),
                                resultSet.getString("plataforma"),
                                resultSet.getString("anolanzamento"),
                                resultSet.getString("descripcion")
                ));
            }
            return videoxogoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    // READ 1
    public static Videoxogo listarId(int id) {
        String sql = "SELECT * FROM anime WHERE id = ?";
        Videoxogo xogo = null;

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                xogo = new Videoxogo(
                        resultSet.getString("titulo"),
                        resultSet.getString("plataforma"),
                        resultSet.getString("anolanzamento"),
                        resultSet.getString("descripcion")
                );
            }
            return xogo;

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
            return null;

        }
    }

    // Insertar
    public static void insertar(Videoxogo videoxogo) {

        String sql = "INSERT INTO videoxogo (titulo, plataforma, anolanzamento, descripcion) " + "VALUES (?, ?, ?, ?)";

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, videoxogo.getTitulo());
            ps.setString(2, videoxogo.getPlataforma());
            ps.setInt(3, Integer.parseInt(videoxogo.getAnolanzamento()));
            ps.setString(4, videoxogo.getDescripcion());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }



    // DELETE → Elimina un anime por su nombre.
    public void eliminar(String titulo) {

        String sql = "DELETE FROM videoxogo WHERE titulo = ?";

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public static void eliminarTodo() {

        String sql = "DELETE FROM videoxogo";

        try (Connection conn = new DBconnector().conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public static void updateVideoxogoPlataforma (String plataforma, int id) {
        String sql = "UPDATE Videoxogo SET Plataforma = ? WHERE id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, plataforma);
            ps.setInt(2, id);
            int n = ps.executeUpdate();
            System.out.println("Actualizáronse " + n + "videoxogos");

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // READ ONE

}
