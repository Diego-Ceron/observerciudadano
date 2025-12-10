package modelo;

/**
 * Clase Corredor - Proyecto de corredor
 * Todos los ciudadanos de todos los distritos deben ser notificados
 */
public class Corredor extends Proyecto {
    
    public Corredor(String nombre, String descripcion) {
        super(nombre, descripcion);
    }
    
    @Override
    public boolean debeNotificar(String distritoObserver) {
        // Los proyectos de corredor son para todos los distritos
        return true;
    }
    
    @Override
    public String getTipo() {
        return "PROYECTO CORREDOR";
    }
}
