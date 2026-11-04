package s107_n1_e01_02_Override;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreballadorTest {

    @Test
    void presencialWithOneParamUsesBenzina() {
        TreballadorPresencial t = new TreballadorPresencial("Marshall", "Faulk", 350);
        double expected = 160 * 350 + 118;
        assertEquals(expected, t.calcularSou(160), 0.0001);
    }

    @Test
    void onlineWithOneParamUsesTarifaInternet() {
        TreballadorOnline t = new TreballadorOnline("Marion", "Jones", 375);
        double expected = 160 * 375 + 35.79;
        assertEquals(expected, t.calcularSou(160), 0.0001);
    }

    @Test
    void presencialWithTwoParamsUsesArg() {
        TreballadorPresencial t = new TreballadorPresencial("A", "B", 100);
        double expected = 160 * 100 + 200; // 200 is the passed value that overrides the constant
        assertEquals(expected, t.calcularSou(160, 200), 0.0001);
    }

    @Test
    void onlineWithTwoParamsUsesArg() {
        TreballadorOnline t = new TreballadorOnline("A", "B", 100);
        double expected = 160 * 100 + 50; // 50 is the passed value that overrides the constant
        assertEquals(expected, t.calcularSou(160, 50), 0.0001);
    }

    @Test
    void polymorphismImplementsChildClass() {
        Treballador t = new TreballadorPresencial("A", "B", 100);
        // Despite parent refence, method should call child class constant anyway
        double expected = 160 * 100 + 118;
        assertEquals(expected, t.calcularSou(160), 0.0001);
    }
}
