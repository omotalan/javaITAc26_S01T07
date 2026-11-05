package s107_n1_e01_02_Override;

public abstract class Treballador {
    private String nom;
    private String cognom;
    private double preuHora;

    public Treballador(String nom, String cognom, double preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public double getPreuHora() {
        return preuHora;
    }

    public double calcularSou(double horesTreballades) {
        return horesTreballades * preuHora;
    }

    public abstract double calcularSou(double horesTreballades, double costFix);

    @Deprecated
    public abstract double calcularSouSenseCostFix(double horesTreballades);
}
