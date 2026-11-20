import javax.swing.*;
import java.awt.*;

public class PointOfSales extends JFrame {

    public PointOfSales() {
        super("POIN Off-Sales - Java Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 680);
        setLocationRelativeTo(null);

        setJMenuBar(buatMenuBar());

        Keranjang keranjang = new Keranjang();
        PanelKeranjang panelKeranjang = new PanelKeranjang(keranjang);
        PanelProduk panelProduk = new PanelProduk(keranjang, panelKeranjang::refresh);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelProduk, panelKeranjang);
        split.setResizeWeight(0.5);
        add(split, BorderLayout.CENTER);
    }

    private JMenuBar buatMenuBar() {
        JMenuBar bar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem miKeluar = new JMenuItem("Keluar");
        miKeluar.addActionListener(e -> System.exit(0));
        menuFile.add(miKeluar);

        JMenu menuHelp = new JMenu("Help");
        JMenuItem miTentang = new JMenuItem("Tentang");
        miTentang.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "POIN Off-Sales\nAplikasi POS sederhana dengan Java Swing",
                "Tentang", JOptionPane.INFORMATION_MESSAGE));
        menuHelp.add(miTentang);

        bar.add(menuFile);
        bar.add(menuHelp);
        return bar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PointOfSales().setVisible(true));
    }
}