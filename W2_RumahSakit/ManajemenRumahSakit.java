import java.util.ArrayList;

public class ManajemenRumahSakit {

    private final ArrayList<Kamar> daftarKamar; 

    public ManajemenRumahSakit() {
        this.daftarKamar = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public void cekKetersediaanKamar() {
        String garis = "+------------+----------------+--------------+";
        System.out.println(garis);
        System.out.printf("| %-10s | %-14s | %-12s |%n", "No. Kamar", "Tipe Kamar", "Status");
        System.out.println(garis);
        for (Kamar k : daftarKamar) {
            k.tampilkanBaris(); 
        }
        System.out.println(garis);
    }

    public void checkIn(Pasien pasien, Kamar kamar, int hariMasuk) {
        if (kamar.isTersedia()) {
            kamar.setTersedia(false);
            pasien.setKamar(kamar);
            pasien.setHariMasuk(hariMasuk);
            System.out.println(pasien.getNama() + " berhasil check-in di Kamar "
                    + kamar.getNomorKamar() + " pada hari ke-" + hariMasuk);
        } else {
            System.out.println("Kamar " + kamar.getNomorKamar() + " sedang terisi, tidak bisa check-in.");
        }
    }

    public void checkOut(Pasien pasien, int hariKeluar) {
        pasien.setHariKeluar(hariKeluar);
        Kamar kamar = pasien.getKamar();
        if (kamar != null) {
            kamar.setTersedia(true);
        }
        System.out.println(pasien.getNama() + " check-out pada hari ke-" + hariKeluar
                + ". Lama rawat inap: " + pasien.hitungLamaInap() + " hari.");
    }
}