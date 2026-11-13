package pago;

import excepciones.PagoFallidoException;

public class TarjetaCredito implements MetodoPago {
    private final String numero;
    private double cupoDisponible;

    public TarjetaCredito(String numero, double cupoDisponible) {
        this.numero = numero;
        this.cupoDisponible = cupoDisponible;
    }

    @Override
    public void cobrar(double monto) {
        if (cupoDisponible < monto) {
            throw new PagoFallidoException("Cupo insuficiente en la tarjeta terminada en "
                    + numero.substring(numero.length() - 4));
        }
        cupoDisponible -= monto;
    }

    @Override
    public String getNombre() { return "Tarjeta de Crédito"; }
}
