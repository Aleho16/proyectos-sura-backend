package excepciones;

public class PagoFallidoException extends RuntimeException {
    public PagoFallidoException(String mensaje) {
        super(mensaje);
    }
}
