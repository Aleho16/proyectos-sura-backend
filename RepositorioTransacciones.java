public interface RepositorioTransacciones {
    void guardarTransaccion(String cliente, String plan, double monto);
}