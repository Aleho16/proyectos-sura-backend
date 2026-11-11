public class BaseDatosRepositorio implements RepositorioTransacciones {
    @Override
    public void guardarTransaccion(String cliente, String plan, double monto) {
        System.out.println("Transacción registrada: " + cliente + " pagó $" + monto + " por " + plan + ".");
    }
}
