package test;

import beans.Guia_turista;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        //listarGuia();
        //actualizarGuia(12437, "unicorlandia");
    }

    public static void actualizarGuia(int id, String ciudad) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE guia_turista SET ciudad ='" + ciudad + "'WHERE id=" + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarGuia() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM guia_turista";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String ciudad = rs.getString("ciudad");
                String zona = rs.getString("zona");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Guia_turista guias = new Guia_turista(id, nombre, apellido, ciudad, zona, telefono, correo);
                System.out.println(guias.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }
}
