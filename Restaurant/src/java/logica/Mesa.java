package logica;

import utilidades.CustomException;

public class Mesa {

    //<editor-fold desc="Atributos">
    private int numero;
    private boolean abierta;
    private Mozo responsable;
    private Servicio servicio;
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public Mesa(int numero, Mozo responsable) {
        this.numero = numero;
        this.abierta = false;
        this.responsable = responsable;
    }
    //</editor-fold>

    //<editor-fold desc="Comportamientos">
    public void abrir() throws CustomException {
        if (abierta) {
            throw new CustomException("La mesa ya está abierta!");
        } else {
            abierta = true;
            servicio = new Servicio(this);
        }
    }

    public void cerrar() throws CustomException {
        if (!abierta) {
            throw new CustomException("La mesa ya está cerrada!");
        } else {
            abierta = false;
            servicio = null;
        }
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setResponsable(Mozo responsable) {
        this.responsable = responsable;
    }

    public Mozo getResponsable() {
        return responsable;
    }

    public Servicio getServicio() {
        return servicio;
    }
    //</editor-fold>

    //<editor-fold desc="Equals">
    @Override
    public boolean equals(Object obj) {
        Mesa other = (Mesa) obj;
        return numero == other.getNumero();
    }
    //</editor-fold>

    //<editor-fold desc="To String">
    @Override
    public String toString() {
        return "Mesa " + numero + (abierta ? " Abierta" : " Cerrada");
    }
    //</editor-fold>

}
