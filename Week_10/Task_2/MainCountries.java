import java.util.HashSet;

public class MainCountries {

    public static void main(String[] args) {

        HashSet<String> countries = new HashSet<String>();

        System.out.println(
            "Tambah Indonesia: " + countries.add("Indonesia")
        );
        System.out.println(
            "Tambah Jepang: " + countries.add("Jepang")
        );
        System.out.println(
            "Tambah Brasil: " + countries.add("Brasil")
        );
        System.out.println(
            "Tambah Kanada: " + countries.add("Kanada")
        );
        System.out.println(
            "Tambah Jepang (duplikat): " + countries.add("Jepang")
        );
        System.out.println(
            "Tambah Mesir: " + countries.add("Mesir")
        );

        System.out.println();
        System.out.println("Isi HashSet:");
        for (String c : countries) {
            System.out.println(c);
        }

        System.out.println();
        System.out.println("Jumlah negara: " + countries.size());
    }
}