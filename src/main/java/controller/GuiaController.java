package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import com.google.gson.Gson;

import beans.Guia_turista;
import connection.DBConnection;

public class GuiaController implements IGuiaController {

    @Override
    public String listar(boolean ordenar, String orden) {
        
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        String sql = "Select * from guia_turista";

        if (ordenar == true)
        {
            sql += " order by ciudad " + orden;
        }
        List<String> guia_turistas = new ArrayList<String>();

        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String ciudad = rs.getString("ciudad");
                String zona = rs.getString("zona");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Guia_turista guia = new Guia_turista(id, nombre, apellido, ciudad, zona, telefono, correo);
                
                guia_turistas.add(gson.toJson(guia));
            }

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(guia_turistas);
    }
    @Override
    public String cancelar(int id, String username) {

        DBConnection con = new DBConnection();
        String sql = "Delete from plan_turistico where id= " + id + " and username = '" 
                + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeQuery(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    @Override
    public String reservar(int id, String username, String ciudad) {

        Timestamp fecha = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        String sql = "Insert into plan_turistico values ('" + id + "', '" + username + "', '" + fecha + "', '" + ciudad + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }
        return "false";
    }

}