package notificacion;

import modelo.Cliente;

public class NotificadorEmail implements Notificador {
    @Override
    public void notificar(Cliente cliente, String mensaje) {
        System.out.println("[email] Para: " + cliente.getEmail() + " | " + mensaje);
    }
}
