package beans;

public class Guia_turista {

    private int id;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String zona;
    private String telefono;
    private String correo;

    public Guia_turista(int id, String nombre, String apellido, String ciudad, String zona, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.zona = zona;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Guia_turista{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad + ", zona=" + zona + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

}
