public class ProcesadorSuscripciones {
    private final RepositorioTransacciones repositorio;
    private final Notificador notificador;

    public ProcesadorSuscripciones(RepositorioTransacciones repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void suscribirCliente(Cliente cliente, Plan plan, MetodoPago metodoPago) {
        if (!cliente.isActivo()) {
            throw new CuentaInactivaException("El cliente " + cliente.getNombre() + " está inactivo.");
        }

        boolean cobroExitoso = metodoPago.procesarCobro(plan.getPrecio());
        if (!cobroExitoso) {
            throw new PagoRechazadoException("Fondos insuficientes para " + cliente.getNombre());
        }

        repositorio.guardarTransaccion(cliente.getNombre(), plan.getNombre(), plan.getPrecio());
        notificador.enviarNotificacion(cliente.getNombre(), "¡Bienvenido al " + plan.getNombre() + "!");
    }
}