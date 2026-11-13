package notificacion;

import modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensaje);
}
