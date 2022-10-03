package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Turista;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "Select * from turista where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");

                Turista turista
                        = new Turista(username, contrasena, nombre, apellido, telefono, correo);
                return gson.toJson(turista);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        finally {
            con.desconectar();
        }

        return "false";
    }
    
    @Override
    public String register(String username, String contrasena, String nombre, String apellido, String telefono,
            String correo) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into turista values('" + username + "', '" + contrasena + "', '" + nombre
                + "', '" + apellido + "', '" + telefono + "', '" + correo + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Turista turista = new Turista(username, contrasena, nombre, apellido, telefono, correo);

            st.close();

            return gson.toJson(turista);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String pedir(String username) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Select * from turista where username ='" + username + "'";
        try {
            
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                                
                Turista turista = new Turista(username, contrasena, nombre, apellido, telefono, correo);
                return gson.toJson(turista);

            }
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }


    @Override
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevoApellido,
            String nuevoTelefono, String nuevoCorreo) {

        DBConnection con = new DBConnection();

        String sql = "Update turista set contrasena = '" + nuevaContrasena + "', nombre = '" + nuevoNombre + "', apellido = '" + nuevoApellido + "', telefono = '" + nuevoTelefono+ "', correo = '" + nuevoCorreo +"'" ;

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String cancelarPlan(String username, Map<Integer, Integer> plan) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> guia_turista : plan.entrySet()) {
                int id = guia_turista.getKey();
                int num_plan = guia_turista.getValue();

                String sql = "Delete * from plan_turistico  where id = " + id + "and " + " username" + username;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from plan_turistico where username = '" + username + "'";
        String sql2 = "Delete from turista where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

}


