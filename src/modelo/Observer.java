package modelo;

/**
 * Interfaz Observer - Define el contrato para los observadores
 */
public interface Observer {
    /**
     * Método que será llamado cuando el sujeto notifique un cambio
     * @param proyecto El proyecto sobre el cual se notifica
     */
    void actualizar(Proyecto proyecto);
}
