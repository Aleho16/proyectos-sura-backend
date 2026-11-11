public class TarjetaCredito implements MetodoPago {
    @Override
    public boolean procesarCobro(double monto) {
        System.out.println("Procesando pago de $" + monto + " con tarjeta de crédito.");
        return true;
    }
}