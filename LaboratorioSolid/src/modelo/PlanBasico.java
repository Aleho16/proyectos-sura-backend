package modelo;

public class PlanBasico implements PlanSuscripcion {
    @Override public String getNombre() { return "Plan Básico"; }
    @Override public double getPrecio() { return 10.0; }
}
