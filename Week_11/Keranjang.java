import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    public static final int HARGA_PER_POINT = 1000;

    private final List<ItemKeranjang> items = new ArrayList<>();

    public void tambah(Produk produk, int qty) {
        for (ItemKeranjang item : items) {
            if (item.getProduk().getId().equals(produk.getId())) {
                item.tambahQty(qty);
                return;
            }
        }
        items.add(new ItemKeranjang(produk, qty));
    }

    public List<ItemKeranjang> getItems() { return items; }

    public boolean isKosong() { return items.isEmpty(); }

    public void kosongkan() { items.clear(); }

    public int getTotal() {
        int total = 0;
        for (ItemKeranjang item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int getPoints() {
        return getTotal() / HARGA_PER_POINT;
    }

    public String buatStruk() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== POIN OFF-SALES =====\n");
        sb.append("Toko: Demo Toko\n");
        sb.append("================================\n");
        sb.append(String.format("%-5s %-15s %3s %s%n", "ID", "Nama", "Qty", "Subtotal"));
        sb.append("--------------------------------\n");
        for (ItemKeranjang item : items) {
            sb.append(String.format("%-5s %-15s %3d %s%n",
                    item.getProduk().getId(),
                    item.getProduk().getNama(),
                    item.getQty(),
                    Rupiah.format(item.getSubtotal())));
        }
        sb.append("--------------------------------\n");
        sb.append("TOTAL:  ").append(Rupiah.format(getTotal())).append("\n");
        sb.append("POINTS DIDAPAT: ").append(getPoints())
          .append(" (1 point per Rp ").append(HARGA_PER_POINT).append(")\n");
        sb.append("================================\n");
        sb.append("Terima kasih! Silakan kunjungi kembali.\n");
        return sb.toString();
    }
}