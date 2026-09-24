public class Barang {
    private String namaBarang;
    private boolean tersedia;

    public Barang(String namaBarang, boolean tersedia) {
        this.namaBarang = namaBarang;
        this.tersedia = tersedia;
    }

    public void pinjamBarang() {
        if (tersedia) {
            tersedia = false;
            System.out.println(namaBarang + " berhasil dipinjam.");
        } else {
            System.out.println(namaBarang + " sedang tidak tersedia.");
        }
    }

    public void kembalikanBarang() {
        tersedia = true;
        System.out.println(namaBarang + " telah dikembalikan.");
    }

    public void tampilkanInfo() {
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Status      : " + (tersedia ? "Tersedia" : "Sedang Dipinjam"));
    }
}