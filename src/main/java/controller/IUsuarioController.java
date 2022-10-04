package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre, String apellido, String telefono, String correo);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellido,
            String nuevoTelefono, String nuevoCorreo);

    public String cancelarPlan(String username, Map<Integer, Integer> plan);

    public String eliminar(String username);

}
