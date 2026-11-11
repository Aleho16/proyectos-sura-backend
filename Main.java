public class Main {
    public static void main(String[] args) {
        RepositorioTransacciones repositorio = new BaseDatosRepositorio();
        Notificador notificador = new EmailNotificador();
        MetodoPago metodoPago = new TarjetaCredito();

        ProcesadorSuscripciones procesador = new ProcesadorSuscripciones(repositorio, notificador);

        Cliente cliente = new Cliente("Alejoo", true);
        Plan planPremium = new Plan("Plan Premium", 20.00);

        

        try {
            procesador.suscribirCliente(cliente, planPremium, metodoPago);
        } catch (CuentaInactivaException | PagoRechazadoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}