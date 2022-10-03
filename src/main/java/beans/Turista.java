package beans;

public class Turista {
    private String username;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Turista(String username, String contrasena, String nombre, String apellido, String telefono, String correo) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        return "Turista{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
}
