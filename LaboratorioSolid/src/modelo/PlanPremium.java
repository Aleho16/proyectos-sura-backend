package modelo;

public class PlanPremium implements PlanSuscripcion {
    @Override public String getNombre() { return "Plan Premium"; }
    @Override public double getPrecio() { return 25000.0; }
}
