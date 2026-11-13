package servicio;

import excepciones.CuentaInactivaException;
import modelo.Cliente;
import modelo.PlanSuscripcion;
import modelo.Transaccion;
import notificacion.Notificador;
import pago.MetodoPago;
import repositorio.RepositorioTransacciones;

public class ProcesadorSuscripcion {
    private final RepositorioTransacciones repositorio;
    private final Notificador notificador;

    public ProcesadorSuscripcion(RepositorioTransacciones repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void suscribir(Cliente cliente, PlanSuscripcion plan, MetodoPago metodoPago) {
        if (!cliente.isActivo()) {
            throw new CuentaInactivaException(
                    "El cliente " + cliente.getNombre() + " tiene la cuenta inactiva.");
        }

        metodoPago.cobrar(plan.getPrecio());

       
        Transaccion transaccion = new Transaccion(
                cliente, plan, plan.getPrecio(), metodoPago.getNombre());
        repositorio.guardar(transaccion);
        notificador.notificar(cliente,
                "Suscripción a " + plan.getNombre() + " exitosa. Se cobraron $" + plan.getPrecio());
    }
}
