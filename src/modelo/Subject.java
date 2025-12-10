package modelo;

/**
 * Interfaz Subject - Define el contrato para los sujetos observables
 */
public interface Subject {
    /**
     * Registra un observador
     * @param observer El observador a registrar
     */
    void registrarObserver(Observer observer);
    
    /**
     * Elimina un observador
     * @param observer El observador a eliminar
     */
    void eliminarObserver(Observer observer);
    
    /**
     * Notifica a todos los observadores registrados
     */
    void notificarObservers();
}
