import id.ac.polban.model.Kamar;
import id.ac.polban.model.Pasien;
import id.ac.polban.service.ManajemenRumahSakit;

public class App {
    public static void main(String[] args) {
        ManajemenRumahSakit rs = new ManajemenRumahSakit("RS Sehat Sentosa");

        Kamar kamar1 = new Kamar("101", "Kelas 1");
        Kamar kamar2 = new Kamar("102", "VIP");
        rs.tambahKamar(kamar1);
        rs.tambahKamar(kamar2);

        Pasien pasien1 = new Pasien("Budi Santoso");
        Pasien pasien2 = new Pasien("P002", "Siti Aminah");

        System.out.println("Nama RS   : " + rs.getNamaRumahSakit());
        System.out.println("ID Pasien 1 (auto)  : " + pasien1.getIdPasien());
        System.out.println("ID Pasien 2 (manual): " + pasien2.getIdPasien());
        System.out.println();

        rs.cekKetersediaanKamar();
        System.out.println();

        rs.checkIn(pasien1, kamar1, 1);
        rs.checkIn(pasien2, kamar2, 2);

        Pasien pasien3 = new Pasien("Andi Wijaya");
        rs.checkIn(pasien3, kamar1, 3);

        System.out.println();
        rs.cekKetersediaanKamar();
        System.out.println();

        rs.checkOut(pasien1, 5);

        System.out.println();
        rs.cekKetersediaanKamar();
        System.out.println();

        System.out.println("Total objek Kamar dibuat  : " + Kamar.getTotalKamar());
        System.out.println("Total objek Pasien dibuat : " + Pasien.getTotalPasien());
    }
}