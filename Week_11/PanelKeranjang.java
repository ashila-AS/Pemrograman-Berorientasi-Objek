import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;

public class PanelKeranjang extends JPanel {
    private final Keranjang keranjang;

    private DefaultTableModel modelKeranjang;
    private JLabel lblTotal, lblPoints;
    private JTextArea txtStruk;

    public PanelKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;

        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Keranjang"));

        add(buatTabel(), BorderLayout.NORTH);
        add(buatBagianBawah(), BorderLayout.CENTER);
        refresh();
    }

    private JScrollPane buatTabel() {
        modelKeranjang = new DefaultTableModel(
                new String[]{"ID", "Nama Produk", "Qty", "Harga", "Subtotal"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        JScrollPane sp = new JScrollPane(new JTable(modelKeranjang));
        sp.setPreferredSize(new Dimension(400, 250));
        return sp;
    }

    private JPanel buatBagianBawah() {
        JPanel bawah = new JPanel();
        bawah.setLayout(new BoxLayout(bawah, BoxLayout.Y_AXIS));
        bawah.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 10));

        lblTotal = new JLabel();
        lblTotal.setFont(lblTotal.getFont().deriveFont(Font.BOLD, 16f));
        lblTotal.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblPoints = new JLabel();
        lblPoints.setFont(lblPoints.getFont().deriveFont(Font.PLAIN, 14f));
        lblPoints.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnCheckout.addActionListener(e -> checkout());

        JButton btnCetak = new JButton("Cetak");
        btnCetak.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnCetak.addActionListener(e -> cetak());

        JLabel lblStruk = new JLabel("Struk:");
        lblStruk.setFont(lblStruk.getFont().deriveFont(Font.BOLD));
        lblStruk.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtStruk = new JTextArea(12, 30);
        txtStruk.setEditable(false);
        txtStruk.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane spStruk = new JScrollPane(txtStruk);
        spStruk.setAlignmentX(Component.LEFT_ALIGNMENT);

        bawah.add(lblTotal);
        bawah.add(Box.createVerticalStrut(8));
        bawah.add(lblPoints);
        bawah.add(Box.createVerticalStrut(8));
        bawah.add(btnCheckout);
        bawah.add(btnCetak);
        bawah.add(Box.createVerticalStrut(10));
        bawah.add(lblStruk);
        bawah.add(spStruk);
        return bawah;
    }

    // Dipanggil setiap isi keranjang berubah
    public void refresh() {
        modelKeranjang.setRowCount(0);
        for (ItemKeranjang item : keranjang.getItems()) {
            modelKeranjang.addRow(new Object[]{
                    item.getProduk().getId(),
                    item.getProduk().getNama(),
                    item.getQty(),
                    item.getProduk().getHarga(),
                    item.getSubtotal()});
        }
        lblTotal.setText("Total: " + Rupiah.format(keranjang.getTotal()));
        lblPoints.setText("Points: " + keranjang.getPoints());
    }

    private void checkout() {
        if (keranjang.isKosong()) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong.",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        txtStruk.setText(keranjang.buatStruk());
        txtStruk.setCaretPosition(0);
        keranjang.kosongkan();
        refresh();
    }

    private void cetak() {
        if (txtStruk.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada struk. Lakukan checkout terlebih dahulu.",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            txtStruk.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}