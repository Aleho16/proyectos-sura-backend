package pago;

public interface MetodoPago {

    void cobrar(double monto);

    String getNombre();
}
