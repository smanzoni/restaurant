package controlador;

import logica.Gestor;
import logica.Mozo;

public interface VistaLogin {

    public void accesoDenegadoMozo(String message);

    public void accesoPermitidoMozo(Mozo usuario);

    public void accesoDenegadoGestor(String message);

    public void accesoPermitidoGestor(Gestor usuario);

    public void notificarErrorMozo(String message);

    public void notificarErrorGestor(String message);

    public void desloguear();

}
