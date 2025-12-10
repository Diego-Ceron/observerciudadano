package vista;

import modelo.*;
import controlador.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase VistaConsola - Maneja la presentación de la información en consola
 */
public class VistaConsola {
    
    /**
     * Muestra el encabezado del sistema
     */
    public void mostrarEncabezado() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE VOTACIÓN CIUDADANA - PATRÓN OBSERVER     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }
    
    /**
     * Muestra mensaje de registro de ciudadanos
     */
    public void mostrarMensajeRegistro() {
        System.out.println(">>> Registrando ciudadanos...\n");
    }
    
    /**
     * Muestra el total de ciudadanos registrados
     * @param cantidad Número de ciudadanos registrados
     */
    public void mostrarTotalCiudadanos(int cantidad) {
        System.out.println("\n✓ Total de ciudadanos registrados: " + cantidad);
        System.out.println("✓ Distritos representados: 1, 2, 3, 4, 5, 6, 7");
        System.out.println("\n" + "=".repeat(60) + "\n");
    }
    
    /**
     * Muestra el encabezado de un caso de uso
     * @param numeroCaso Número del caso
     * @param titulo Título del caso
     * @param descripcion Descripción breve
     */
    public void mostrarCaso(int numeroCaso, String titulo, String descripcion) {
        System.out.println(">>> CASO " + numeroCaso + ": " + titulo);
        System.out.println(">>> " + descripcion + "\n");
    }
    
    /**
     * Muestra un separador visual
     */
    public void mostrarSeparador() {
        System.out.println("\n" + "=".repeat(60) + "\n");
    }
}
