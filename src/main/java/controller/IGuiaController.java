package controller;

public interface IGuiaController {

    public String listar(boolean ordenar, String orden);

    public String cancelar(int id, String username);

    public String reservar(int id, String username, String ciudad);


}
