package pago;

import excepciones.PagoFallidoException;

public class BilleteraVirtual implements MetodoPago {
    private double saldo;

    public BilleteraVirtual(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void cobrar(double monto) {
        if (saldo < monto) {
            throw new PagoFallidoException("saldo insuficiente en la billetera virtual. saldo: $" + saldo);
        }
        saldo -= monto;
    }

    @Override
    public String getNombre() { return "Billetera Virtual"; }
}
