public class Main {
    public static void main(String[] args) {
        Barang barang1 = new Barang("Proyektor", true);

        System.out.println("=== Informasi Barang ===");
        barang1.tampilkanInfo();

        System.out.println("\n=== Peminjaman Barang ===");
        barang1.pinjamBarang();

        System.out.println("\n=== Setelah Dipinjam ===");
        barang1.tampilkanInfo();

        System.out.println("\n=== Pengembalian Barang ===");
        barang1.kembalikanBarang();

        System.out.println("\n=== Setelah Dikembalikan ===");
        barang1.tampilkanInfo();
    }
}