package s107_n1_e01_02_Override;

public class TreballadorPresencial extends Treballador {
    private static final double BENZINA = 118.0;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(double horesTreballades, double costFix) {
        return (horesTreballades * this.getPreuHora()) + costFix;
    }

    // Overloaded method as default parameter
    @Override
    public double calcularSou(double horesTreballades) {
        return calcularSou(horesTreballades, BENZINA);
    }

    @Deprecated
    @Override
    public double calcularSouSenseCostFix(double horesTreballades) {
        return (horesTreballades * this.getPreuHora());
    }
}
