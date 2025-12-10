package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Ciudadano - Implementa el patrón Observer
 * Cada ciudadano pertenece a un distrito y solo recibe notificaciones
 * de proyectos de su distrito o de corredores
 */
public class Ciudadano implements Observer {
    private String nombre;
    private String distrito;
    private String email;
    private List<Proyecto> proyectosNotificados;
    
    public Ciudadano(String nombre, String distrito, String email) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.email = email;
        this.proyectosNotificados = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDistrito() {
        return distrito;
    }
    
    public String getEmail() {
        return email;
    }
    
    /**
     * Método polimórfico que determina si debe procesar la notificación
     * Acumula los proyectos que le corresponden al ciudadano
     */
    @Override
    public void actualizar(Proyecto proyecto) {
        // Polimorfismo: el proyecto decide si debe notificar a este ciudadano
        if (proyecto.debeNotificar(this.distrito)) {
            proyectosNotificados.add(proyecto);
        }
    }
    
    /**
     * Muestra todas las notificaciones acumuladas del ciudadano
     */
    public void mostrarNotificaciones() {
        if (proyectosNotificados.isEmpty()) {
            return;
        }
        
        System.out.println("============================================");
        System.out.println("NOTIFICACIONES PARA: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Distrito: " + distrito);
        System.out.println("============================================\n");
        
        for (int i = 0; i < proyectosNotificados.size(); i++) {
            Proyecto p = proyectosNotificados.get(i);
            System.out.println("[" + (i+1) + "] " + p.getTipo());
            System.out.println("    Proyecto: " + p.getNombre());
            System.out.println("    Descripción: " + p.getDescripcion());
            System.out.println();
        }
        
        System.out.println("-------------------------------------------");
        System.out.println("Tiene " + proyectosNotificados.size() + " proyecto(s) para votar.");
        System.out.println("============================================\n");
    }
    
    /**
     * Limpia las notificaciones acumuladas
     */
    public void limpiarNotificaciones() {
        proyectosNotificados.clear();
    }
    
    @Override
    public String toString() {
        return String.format("%s (Distrito: %s)", nombre, distrito);
    }
}
