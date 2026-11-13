package pago;

import excepciones.PagoFallidoException;

public class TransferenciaBancaria implements MetodoPago {
    private final String cuenta;
    private double fondos;

    public TransferenciaBancaria(String cuenta, double fondos) {
        this.cuenta = cuenta;
        this.fondos = fondos;
    }

    @Override
    public void cobrar(double monto) {
        if (fondos < monto) {
            throw new PagoFallidoException("Fondos insuficientes en la cuenta " + cuenta);
        }
        fondos -= monto;
    }

    @Override
    public String getNombre() { return "Transferencia Bancaria"; }
}
