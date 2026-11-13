package modelo;

public class Cliente {
    private final String nombre;
    private final String email;
    private boolean activo;

    public Cliente(String nombre, String email, boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.activo = activo;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
