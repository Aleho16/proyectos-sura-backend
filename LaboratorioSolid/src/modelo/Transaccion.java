package modelo;

import java.time.LocalDateTime;

public class Transaccion {
    private final Cliente cliente;
    private final PlanSuscripcion plan;
    private final double monto;
    private final String metodoPago;
    private final LocalDateTime fecha;

    public Transaccion(Cliente cliente, PlanSuscripcion plan, double monto, String metodoPago) {
        this.cliente = cliente;
        this.plan = plan;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fecha = LocalDateTime.now();
    }

    public Cliente getCliente() { return cliente; }
    public PlanSuscripcion getPlan() { return plan; }
    public double getMonto() { return monto; }
    public String getMetodoPago() { return metodoPago; }
    public LocalDateTime getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Transaccion{cliente=" + cliente.getNombre() + ", plan=" + plan.getNombre()
                + ", monto=$" + monto + ", metodo=" + metodoPago + ", fecha=" + fecha + "}";
    }
}
