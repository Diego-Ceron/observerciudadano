package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase SistemaMensajeria - Implementa el Subject del patrón Observer
 * Gestiona la lista de ciudadanos y envía notificaciones de proyectos
 */
public class SistemaMensajeria implements Subject {
    private List<Ciudadano> ciudadanos;
    private List<Proyecto> proyectosAnotificados;
    
    public SistemaMensajeria() {
        this.ciudadanos = new ArrayList<>();
        this.proyectosAnotificados = new ArrayList<>();
    }
    
    @Override
    public void registrarObserver(Observer observer) {
        if (observer instanceof Ciudadano) {
            Ciudadano c = (Ciudadano) observer;
            if (!ciudadanos.contains(c)) {
                ciudadanos.add(c);
                System.out.println("✓ Ciudadano registrado en el sistema de mensajería");
            }
        }
    }
    
    @Override
    public void eliminarObserver(Observer observer) {
        if (observer instanceof Ciudadano) {
            Ciudadano c = (Ciudadano) observer;
            if (ciudadanos.remove(c)) {
                System.out.println("✓ Ciudadano eliminado del sistema de mensajería");
            }
        }
    }
    
    @Override
    public void notificarObservers() {
        // Notifica a cada ciudadano sobre todos los proyectos acumulados
        for (Ciudadano ciudadano : ciudadanos) {
            for (Proyecto proyecto : proyectosAnotificados) {
                ciudadano.actualizar(proyecto);
            }
        }
        
        // Muestra todas las notificaciones para cada ciudadano
        mostrarNotificacionesPorCiudadano();
    }
    
    /**
     * Muestra las notificaciones acumuladas para cada ciudadano
     */
    private void mostrarNotificacionesPorCiudadano() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║          PROYECTOS A VOTAR POR CIUDADANO              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        for (Ciudadano ciudadano : ciudadanos) {
            ciudadano.mostrarNotificaciones();
        }
    }
    
    /**
     * Añade un proyecto a la lista de notificación
     * @param proyecto El proyecto a notificar
     */
    public void agregarProyectoANotificar(Proyecto proyecto) {
        proyectosAnotificados.add(proyecto);
        System.out.println("✓ Proyecto añadido a la notificación: " + proyecto.getNombre());
    }
    
    /**
     * Envía todas las convocatorias acumuladas
     */
    public void enviarConvocatorias() {
        if (proyectosAnotificados.isEmpty()) {
            System.out.println("\n⚠ No hay proyectos para notificar");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║     ENVIANDO " + proyectosAnotificados.size() + " CONVOCATORIA(S) DE VOTACIÓN      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        notificarObservers();
    }
    
    /**
     * Limpia los proyectos acumulados
     */
    public void limpiarProyectos() {
        proyectosAnotificados.clear();
        for (Ciudadano ciudadano : ciudadanos) {
            ciudadano.limpiarNotificaciones();
        }
    }
    
    /**
     * Registra múltiples ciudadanos a la vez
     * @param listaCiudadanos Lista de ciudadanos a registrar
     */
    public void registrarCiudadanos(List<Ciudadano> listaCiudadanos) {
        for (Ciudadano ciudadano : listaCiudadanos) {
            registrarObserver(ciudadano);
        }
    }
    
    public int getCantidadCiudadanos() {
        return ciudadanos.size();
    }
}
