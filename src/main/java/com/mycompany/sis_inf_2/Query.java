/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sis_inf_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Query {
    private static final String URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.evyxcvhqzgimicjtbjpw";
    private static final String PASSWORD = "player88";
    
    public void agregarMueble(Mueble mueble) {
        String sql = "INSERT INTO mueble (id_mueble, modelo, tipo, material, precio_venta, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, mueble.getID_Mueble());
            pstmt.setString(2, mueble.getModelo());
            pstmt.setString(3, mueble.getTipo());
            pstmt.setString(4, mueble.getMaterial());
            pstmt.setString(5, mueble.getPrecio_Venta()); // Suponiendo que el precio es un BigDecimal
            pstmt.setString(6, mueble.getDescripcion());

            pstmt.executeUpdate();
            System.out.println("Datos del mueble añadidos correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar datos del mueble: " + e.getMessage());
        }
    }

    public void mostrarMensaje(String mensaje) {
        JFrame frame = new JFrame("Mensaje");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(mensaje);
        
        panel.add(label);
        frame.add(panel);

        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Crear un temporizador para cerrar el panel después de 3 segundos
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public int codMax(){
        int maxID = 0;
        String query = "SELECT MAX(id_mueble) AS MaxID FROM mueble"; // Reemplaza con el nombre real de tu tabla
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                maxID = rs.getInt("MaxID");
                System.out.println("El valor máximo de ID_Muebles es: " + maxID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxID;
    }
    public javax.swing.JTable cargarDatosEnTabla(javax.swing.JTable tabla) {
        String sql = "SELECT id_mueble, modelo, tipo, material, precio_venta, descripcion FROM mueble";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0); // Limpiar tabla antes de agregar datos
            while (resultSet.next()) {
                Object[] row = new Object[6];
                row[0] = resultSet.getInt("id_mueble");
                row[1] = resultSet.getString("modelo");
                row[2] = resultSet.getString("tipo");
                row[3] = resultSet.getString("material");
                row[4] = resultSet.getDouble("precio_venta");
                row[5] = resultSet.getString("descripcion");
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabla;
}
    public void eliminarMueble(Mueble mueble) {
    String sql = "DELETE FROM mueble WHERE id_mueble = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, mueble.getID_Mueble());

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            mostrarMensaje("Mueble eliminado correctamente.");
        } else {
            mostrarMensaje("No se encontró ningún mueble con el ID proporcionado.");
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar el mueble: " + e.getMessage());
    }
}
}