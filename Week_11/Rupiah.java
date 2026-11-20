import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rupiah {
    private static final DecimalFormat FORMAT;

    static {
        DecimalFormatSymbols sym = new DecimalFormatSymbols(Locale.forLanguageTag("id-ID"));
        sym.setGroupingSeparator('.');
        sym.setDecimalSeparator(',');
        FORMAT = new DecimalFormat("#,##0.00", sym);
    }

    public static String format(int nilai) {
        return "Rp" + FORMAT.format(nilai);
    }
}