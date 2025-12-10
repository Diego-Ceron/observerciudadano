package modelo;

/**
 * Clase Distrito - Proyecto específico de un distrito
 * Solo los ciudadanos del mismo distrito deben ser notificados
 */
public class Distrito extends Proyecto {
    private String distrito;
    
    public Distrito(String nombre, String descripcion, String distrito) {
        super(nombre, descripcion);
        this.distrito = distrito;
    }
    
    public String getDistrito() {
        return distrito;
    }
    
    @Override
    public boolean debeNotificar(String distritoObserver) {
        // Solo notificar si el ciudadano pertenece al mismo distrito
        return this.distrito.equals(distritoObserver);
    }
    
    @Override
    public String getTipo() {
        return "PROYECTO DISTRITO " + distrito;
    }
}
