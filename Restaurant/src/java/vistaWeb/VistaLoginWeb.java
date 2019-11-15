package vistaWeb;

import controlador.ControladorLogin;
import controlador.VistaLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Gestor;
import logica.Mozo;
import logica.Usuario;

public class VistaLoginWeb implements VistaLogin {

    private ControladorLogin controlador;
    private String destino;
    private HttpServletRequest request;
    private PrintWriter out;

    public VistaLoginWeb() {
        controlador = new ControladorLogin(this);
    }

    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        out = response.getWriter();

        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String accion = request.getParameter("inputAccion");

        this.request = request;

        Usuario user = null;

        switch (accion) {
            case "loginMozo":
                user = (Usuario) request.getSession().getAttribute("Usuario");
                if (user != null) {
                    accesoDenegadoMozo("Usted está logueado!");
                    break;
                }
                controlador.loginMozo(username, password);
                break;

            case "logoutMozo":
                Mozo mozo = (Mozo) request.getSession().getAttribute("Usuario");
                controlador.logoutMozo(mozo);
                break;

            case "loginGestor":
                user = (Usuario) request.getSession().getAttribute("Usuario");
                if (user != null) {
                    accesoDenegadoGestor("Usted está logueado!");
                    break;
                }
                controlador.loginGestor(username, password);
                break;

            case "logoutGestor":
                Gestor gestor = (Gestor) request.getSession().getAttribute("Usuario");
                controlador.logoutGestor(gestor);
                request.getSession().invalidate();
                destino = "";
                break;
        }

        if (destino != null) {
            response.sendRedirect(destino);
        }

    }

    @Override
    public void accesoDenegadoMozo(String message) {
        destino = "mozoLogin.jsp?message=" + message;
    }

    @Override
    public void accesoPermitidoMozo(Mozo usuario) {
        destino = "mozo.jsp";
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("Usuario", usuario);
    }

    @Override
    public void accesoDenegadoGestor(String message) {
        destino = "gestorLogin.jsp?message=" + message;
    }

    @Override
    public void accesoPermitidoGestor(Gestor usuario) {
        destino = "gestor.jsp";
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("Usuario", usuario);
    }

    @Override
    public void notificarError(String message) {
        out.write(message);
    }

    @Override
    public void desloguear() {
        request.getSession().invalidate();
        destino = "";
    }

}
