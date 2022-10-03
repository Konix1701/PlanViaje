package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.GuiaController;

/**
 *
 * @author usuario
 */
@WebServlet(name = "ServletGuiaListar", urlPatterns
        = {
            "/ServletGuiaListar"
        })
public class ServletGuiaListar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletGuiaListar() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        GuiaController guia = new GuiaController();

        boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
        String orden = request.getParameter("orden");

        String guiaStr = guia.listar(ordenar, orden);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(guiaStr);
        out.flush();
        out.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
