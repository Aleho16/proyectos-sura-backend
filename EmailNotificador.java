public class EmailNotificador implements Notificador {
    @Override
    public void enviarNotificacion(String cliente, String mensaje) {
        System.out.println("Correo enviado a " + cliente + ": " + mensaje);
    }
}