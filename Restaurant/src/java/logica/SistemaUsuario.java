package logica;

import java.util.ArrayList;
import utilidades.CustomException;

/**
 *
 * @author Ignacio
 */
public class SistemaUsuario {

    // Atributos
    private ArrayList<Mozo> mozosTodos;
    private ArrayList<Mozo> mozosLogueados;
    private ArrayList<Gestor> gestoresTodos;
    private ArrayList<Gestor> gestoresLogueados;

    public SistemaUsuario() {
        mozosTodos = new ArrayList<>();
        mozosLogueados = new ArrayList<>();
        gestoresTodos = new ArrayList<>();
        gestoresLogueados = new ArrayList<>();

    }

    public Mozo loginMozo(String nombreUsuario, String contrasena) {
        for (Mozo m : mozosTodos) {
            Mozo mozo = m.login(nombreUsuario, contrasena);
            if (mozo != null) {
                mozosLogueados.add(mozo);
                return mozo;
            }
        }
        return null;
    }

    public void logoutMozo(Mozo m) throws CustomException {
        if (m == null) {
            throw new CustomException("No hay mozo!");
        }

        if (!m.getMesasAbiertas().isEmpty()) {
            throw new CustomException("Tienes mesas abiertas!");
        }

        if (!mozosLogueados.contains(m)) {
            throw new CustomException("No está logueado!");
        }

        mozosLogueados.remove(m);

    }

    public Gestor loginGestor(String nombreUsuario, String contrasena) {
        for (Gestor g : gestoresTodos) {
            Gestor gestor = g.login(nombreUsuario, contrasena);
            if (gestor != null) {
                gestoresLogueados.add(gestor);
                return gestor;
            }
        }
        return null;
    }

    public boolean logoutGestor(Gestor g) {
        try {
            gestoresLogueados.remove(g);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Getters & Setters
    public void setMozosTodos(ArrayList<Mozo> mozosTodos) {
        this.mozosTodos = mozosTodos;
    }

    public ArrayList<Mozo> getMozosTodos() {
        return mozosTodos;
    }

    public ArrayList<Mozo> getMozosLogueados() {
        return mozosLogueados;
    }

    public void setGestoresTodos(ArrayList<Gestor> gestoresTodos) {
        this.gestoresTodos = gestoresTodos;
    }

    public ArrayList<Gestor> getGestoresTodos() {
        return gestoresTodos;
    }

    public ArrayList<Gestor> getGestoresLogueados() {
        return gestoresLogueados;
    }

}
