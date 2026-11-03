package id.ac.polban.pbo.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @ParameterizedTest(name = "sisi {0}, {1}, {2} -> luas {3}")
    @CsvSource({
        "3, 4, 5, 6",
        "5, 5, 6, 12",
        "2, 2, 2, 1.7320508"
    })
    @DisplayName("luas segitiga dihitung dengan rumus Heron")
    void area_heron(double a, double b, double c, double luasDiharapkan) {
        // Arrange: segitiga dari tiga sisi yang valid
        Shape segitiga = new Triangle(a, b, c);

        // Act: hitung luas
        double luas = segitiga.area();

        // Assert: luas sesuai hasil rumus Heron
        assertEquals(luasDiharapkan, luas, 0.001);
    }

    @Test
    @DisplayName("keliling segitiga adalah jumlah tiga sisi")
    void perimeter_jumlahTigaSisi() {
        // Arrange: segitiga siku-siku 3-4-5
        Shape segitiga = new Triangle(3, 4, 5);

        // Act: hitung keliling
        double keliling = segitiga.perimeter();

        // Assert: 3 + 4 + 5 = 12
        assertEquals(12, keliling, 1e-9);
    }

    @ParameterizedTest(name = "sisi {0}, {1}, {2} ditolak")
    @CsvSource({
        "1, 2, 10",
        "1, 2, 3",
        "0, 4, 5",
        "-3, 4, 5"
    })
    @DisplayName("sisi yang tidak membentuk segitiga ditolak")
    void constructor_sisiTidakValid_ditolak(double a, double b, double c) {
        // Arrange: tiga sisi yang tidak membentuk segitiga (dari parameter)

        // Act + Assert: pembuatan objek harus melempar exception
        assertThrows(IllegalArgumentException.class,
            () -> new Triangle(a, b, c));
    }
}