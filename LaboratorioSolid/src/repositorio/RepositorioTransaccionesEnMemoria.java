package repositorio;

import modelo.Transaccion;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTransaccionesEnMemoria implements RepositorioTransacciones {
    private final List<Transaccion> baseDeDatos = new ArrayList<>();

    @Override
    public void guardar(Transaccion transaccion) {
        baseDeDatos.add(transaccion);
        System.out.println("[BD] Transacción guardada: " + transaccion);
    }

    public List<Transaccion> getTransacciones() {
        return List.copyOf(baseDeDatos);
    }
}
