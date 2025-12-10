package modelo;

/**
 * Clase abstracta Proyecto - Base para todos los tipos de proyectos
 */
public abstract class Proyecto {
    protected String nombre;
    protected String descripcion;
    
    public Proyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Método abstracto para determinar si un ciudadano debe ser notificado
     * @param distrito El distrito del ciudadano
     * @return true si el ciudadano debe ser notificado, false en caso contrario
     */
    public abstract boolean debeNotificar(String distrito);
    
    /**
     * Método abstracto para obtener el tipo de proyecto
     * @return El tipo de proyecto
     */
    public abstract String getTipo();
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s", getTipo(), nombre, descripcion);
    }
}
