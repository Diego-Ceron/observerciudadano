import controlador.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import vista.*;

/**
 * Clase Main - Ejemplo de uso del sistema de mensajería con patrón Observer
 * Demuestra el polimorfismo en la notificación de proyectos por distrito
 */
public class Main {
    public static void main(String[] args) {
        // Crear la vista
        VistaConsola vista = new VistaConsola();
        
        // Crear el sistema de mensajería (controlador)
        SistemaMensajeria sistema = new SistemaMensajeria();
        
        vista.mostrarEncabezado();
        vista.mostrarMensajeRegistro();
        
        // Crear ciudadanos de diferentes distritos
        List<Ciudadano> ciudadanos = new ArrayList<>();
        
        // Distrito 1
        ciudadanos.add(new Ciudadano("Juan Perez", "1", "juan.perez@email.com"));
        ciudadanos.add(new Ciudadano("Maria Garcia", "1", "maria.garcia@email.com"));
        
        // Distrito 2
        ciudadanos.add(new Ciudadano("Carlos Lopez", "2", "carlos.lopez@email.com"));
        ciudadanos.add(new Ciudadano("Ana Martinez", "2", "ana.martinez@email.com"));
        
        // Distrito 3
        ciudadanos.add(new Ciudadano("Luis Rodriguez", "3", "luis.rodriguez@email.com"));
        
        // Distrito 4
        ciudadanos.add(new Ciudadano("Laura Sanchez", "4", "laura.sanchez@email.com"));
        
        // Distrito 5
        ciudadanos.add(new Ciudadano("Pedro Hernandez", "5", "pedro.hernandez@email.com"));
        
        // Distrito 6
        ciudadanos.add(new Ciudadano("Carmen Diaz", "6", "carmen.diaz@email.com"));
        
        // Distrito 7
        ciudadanos.add(new Ciudadano("Roberto Torres", "7", "roberto.torres@email.com"));
        
        // Registrar todos los ciudadanos en el sistema
        sistema.registrarCiudadanos(ciudadanos);
        
        vista.mostrarTotalCiudadanos(sistema.getCantidadCiudadanos());
        
        // Añadir proyectos a la convocatoria
        System.out.println(">>> Anadiendo proyectos a la convocatoria...\n");
        
        // Proyecto de Distrito 1
        Proyecto proyectoDistrito1 = new Distrito(
            "Parque Recreativo Distrito 1",
            "Construccion de parque recreativo con areas verdes y juegos infantiles",
            "1"
        );
        sistema.agregarProyectoANotificar(proyectoDistrito1);
        
        // Proyecto de Distrito 2
        Proyecto proyectoDistrito2 = new Distrito(
            "Biblioteca Municipal Distrito 2",
            "Remodelacion y ampliacion de la biblioteca municipal",
            "2"
        );
        sistema.agregarProyectoANotificar(proyectoDistrito2);
        
        // Proyecto Corredor 1
        Proyecto corredor1 = new Corredor(
            "Corredor Verde Metropolitano",
            "Creacion de corredor verde que conecta todos los distritos de la ciudad"
        );
        sistema.agregarProyectoANotificar(corredor1);
        
        // Proyecto Corredor 2
        Proyecto corredor2 = new Corredor(
            "Corredor Verde Fmat",
            "Creacion de corredor verde en la zona Fmat"
        );
        sistema.agregarProyectoANotificar(corredor2);
        
        // Enviar todas las convocatorias
        vista.mostrarSeparador();
        sistema.enviarConvocatorias();
    }
}
