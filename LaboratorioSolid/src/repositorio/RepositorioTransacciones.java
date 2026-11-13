package repositorio;

import modelo.Transaccion;

public interface RepositorioTransacciones {
    void guardar(Transaccion transaccion);
}
