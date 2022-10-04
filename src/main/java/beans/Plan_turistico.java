package beans;

import java.sql.Date;

public class Plan_turistico {
    private int id;
    private String username;
    private Date fecha;
    private String ciudad;

    public Plan_turistico(int id, String username, Date fecha, String ciudad) {
        this.id = id;
        this.username = username;
        this.fecha = fecha;
        this.ciudad = ciudad;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public String toString() {
        return "Plan_turistico{" + "id=" + id + ", username=" + username + ", fecha=" + fecha + ", ciudad=" + ciudad + '}';
    }
    
}
