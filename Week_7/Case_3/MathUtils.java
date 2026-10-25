public class MathUtils {
  
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException(
                "Factorial tidak didefinisikan untuk bilangan negatif: " + n);
        }
        if (n > 16) {
            throw new IllegalArgumentException(
                "Argumen terlalu besar (maksimum 16) karena akan terjadi overflow int: " + n);
        }

        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}