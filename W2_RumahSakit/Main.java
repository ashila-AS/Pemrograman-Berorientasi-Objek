public class Main {
    public static void main(String[] args) {
        
        ManajemenRumahSakit rs = new ManajemenRumahSakit();

        Kamar kamar1 = new Kamar("101", "Kelas 1");
        Kamar kamar2 = new Kamar("102", "VIP");
        rs.tambahKamar(kamar1);
        rs.tambahKamar(kamar2);

        Pasien pasien1 = new Pasien("P001", "Budi Santoso");
        Pasien pasien2 = new Pasien("P002", "Siti Aminah");

        rs.cekKetersediaanKamar();

        System.out.println();

        rs.checkIn(pasien1, kamar1, 1); 
        rs.checkIn(pasien2, kamar2, 2);   

        Pasien pasien3 = new Pasien("P003", "Andi Wijaya");
        rs.checkIn(pasien3, kamar1, 3);

        System.out.println();
        rs.cekKetersediaanKamar();

        System.out.println();

        rs.checkOut(pasien1, 5); 

        System.out.println();
        rs.cekKetersediaanKamar();
    }
}