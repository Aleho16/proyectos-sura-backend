import excepciones.CuentaInactivaException;
import excepciones.PagoFallidoException;
import modelo.*;
import notificacion.NotificadorEmail;
import pago.*;
import repositorio.RepositorioTransaccionesEnMemoria;
import servicio.ProcesadorSuscripcion;

public class Main {
    public static void main(String[] args) {
        ProcesadorSuscripcion procesador = new ProcesadorSuscripcion(
                new RepositorioTransaccionesEnMemoria(),
                new NotificadorEmail());

        Cliente activo = new Cliente("Ana", "ana@mail.com", true);
        Cliente inactivo = new Cliente("Luis", "luis@mail.com", false);

        System.out.println("--- Caso exitoso ---");
        procesador.suscribir(activo, new PlanPremium(), new TarjetaCredito("1234567812345678", 100));

        System.out.println("\n--- Cuenta inactiva ---");
        try {
            procesador.suscribir(inactivo, new PlanBasico(), new BilleteraVirtual(50));
        } catch (CuentaInactivaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Fondos insuficientes ---");
        try {
            procesador.suscribir(activo, new PlanPremium(), new BilleteraVirtual(5));
        } catch (PagoFallidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Transferencia ---");
        procesador.suscribir(activo, new PlanBasico(), new TransferenciaBancaria("001-234", 30));
    }
}
