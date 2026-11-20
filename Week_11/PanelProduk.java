import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelProduk extends JPanel {
    private final List<Produk> daftarProduk = new ArrayList<>();
    private final Keranjang keranjang;
    private final Runnable onKeranjangBerubah;

    private JTable tblProduk;
    private JLabel lblDipilih;
    private JTextField txtQty;

    public PanelProduk(Keranjang keranjang, Runnable onKeranjangBerubah) {
        this.keranjang = keranjang;
        this.onKeranjangBerubah = onKeranjangBerubah;

        isiDataProduk();
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Produk"));

        add(buatTabel(), BorderLayout.CENTER);
        add(buatBagianBawah(), BorderLayout.SOUTH);
    }

    private void isiDataProduk() {
        daftarProduk.add(new Produk("P001", "Air Mineral 600ml", 3000));
        daftarProduk.add(new Produk("P002", "Kopi Sachet", 5000));
        daftarProduk.add(new Produk("P003", "Roti isi", 8000));
        daftarProduk.add(new Produk("P004", "Snack Keripik", 6000));
        daftarProduk.add(new Produk("P005", "Minuman Botol", 12000));
    }

    private JScrollPane buatTabel() {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "Nama Produk", "Harga (Rp)"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        for (Produk p : daftarProduk) {
            model.addRow(new Object[]{p.getId(), p.getNama(), p.getHarga()});
        }

        tblProduk = new JTable(model);
        tblProduk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProduk.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) updateLabelDipilih();
        });
        return new JScrollPane(tblProduk);
    }

    private JPanel buatBagianBawah() {
        JPanel bawah = new JPanel();
        bawah.setLayout(new BoxLayout(bawah, BoxLayout.Y_AXIS));

        lblDipilih = new JLabel("Pilih produk dari tabel di kiri");
        lblDipilih.setFont(lblDipilih.getFont().deriveFont(Font.BOLD));
        lblDipilih.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel barisQty = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        barisQty.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel lblQty = new JLabel("Qty:");
        lblQty.setFont(lblQty.getFont().deriveFont(Font.BOLD));
        txtQty = new JTextField("1", 4);
        JButton btnAdd = new JButton("Add to Cart");
        btnAdd.addActionListener(e -> addToCart());
        barisQty.add(lblQty);
        barisQty.add(txtQty);
        barisQty.add(btnAdd);

        bawah.add(lblDipilih);
        bawah.add(barisQty);
        return bawah;
    }

    private void updateLabelDipilih() {
        int row = tblProduk.getSelectedRow();
        if (row < 0) {
            lblDipilih.setText("Pilih produk dari tabel di kiri");
            return;
        }
        Produk p = daftarProduk.get(row);
        lblDipilih.setText("Dipilih: " + p.getId() + " - " + p.getNama()
                + " (" + Rupiah.format(p.getHarga()) + ")");
    }

    private void addToCart() {
        int row = tblProduk.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih produk terlebih dahulu.",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(txtQty.getText().trim());
            if (qty <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Qty harus berupa angka bulat lebih dari 0.",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        keranjang.tambah(daftarProduk.get(row), qty);
        txtQty.setText("1");
        onKeranjangBerubah.run();
    }
}