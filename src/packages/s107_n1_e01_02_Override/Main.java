package s107_n1_e01_02_Override;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Defining Treballador class just to demonstrate polymorphism
        Treballador presi = new TreballadorPresencial("Marshall", "Faulk", 350);
        Treballador onli = new TreballadorOnline("Marion", "Jones", 375);

        // Use default value, called overridden, overloaded method with only one arg
        System.out.println("Sou presencial: " + presi.calcularSou(160));
        System.out.println("Sou online: " + onli.calcularSou(160));

        // Use override with two args
        System.out.println("Sou presencial (2 params): " + presi.calcularSou(160, 53.52));
        System.out.println("Sou online (2 params): " + onli.calcularSou(160, 174));

        // Call deprecated methods
        System.out.println("Sou presencial (deprecated): " + presi.calcularSouSenseCostFix(160));
        System.out.println("Sou online (deprecated): " + onli.calcularSouSenseCostFix(160));
    }
}
