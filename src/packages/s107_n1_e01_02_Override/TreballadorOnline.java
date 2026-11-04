package s107_n1_e01_02_Override;

public class TreballadorOnline extends Treballador {
    private static final double TARIFAINTERNET = 35.79;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(double horesTreballades, double tarifaNet) {
        return (horesTreballades * this.getPreuHora()) + tarifaNet;
    }

    // Overloaded method as default parameter
    @Override
    public double calcularSou(double horesTreballades) {
        return calcularSou(horesTreballades, TARIFAINTERNET);
    }
}
