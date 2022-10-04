package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Plan_turistico;
import connection.DBConnection;

public class PlanController implements IPlanController {

    @Override
    public String listarPlanes(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.username, a.fecha, l.ciudad from plan_turistico l "
                + "inner join plan_turistico a on l.id = a.id inner join turista u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> planes = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date fechaPlan = rs.getDate("fecha");
                String ciudad = rs.getString("ciudad");

                Plan_turistico plan = new Plan_turistico(id, username, fechaPlan, ciudad);

                planes.add(gson.toJson(plan));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(planes);
    }
}
