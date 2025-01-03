package JavaFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JLabel gyroXLabel;
    private final JLabel gyroYLabel;
    private final JLabel gyroZLabel;
    private final JLabel accXLabel;
    private final JLabel accYLabel;
    private final JLabel accZLabel;

    public MainFrame() {
        setTitle("MPU6050 Verileri");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 10, 10)); // 1 satır, 2 sütunlu düzen

        // Sol sütun: Cayro verileri
        JPanel gyroPanel = new JPanel();
        gyroPanel.setLayout(new GridLayout(3, 1, 5, 5)); // 3 satırlı düzen
        gyroPanel.setBorder(BorderFactory.createTitledBorder("3 EKSEN CAYRO VERILERI"));

        gyroXLabel = new JLabel("CayroX: 0.0");
        gyroYLabel = new JLabel("CayroY: 0.0");
        gyroZLabel = new JLabel("CayroZ: 0.0");

        gyroPanel.add(createLabeledPanel(gyroXLabel));
        gyroPanel.add(createLabeledPanel(gyroYLabel));
        gyroPanel.add(createLabeledPanel(gyroZLabel));

        // Sağ sütun: Ivme verileri
        JPanel accPanel = new JPanel();
        accPanel.setLayout(new GridLayout(3, 1, 5, 5)); // 3 satırlı düzen
        accPanel.setBorder(BorderFactory.createTitledBorder("3 EKSEN IVME VERILERI"));

        accXLabel = new JLabel("IvmeX: 0.0");
        accYLabel = new JLabel("IvmeY: 0.0");
        accZLabel = new JLabel("IvmeZ: 0.0");

        accPanel.add(createLabeledPanel(accXLabel));
        accPanel.add(createLabeledPanel(accYLabel));
        accPanel.add(createLabeledPanel(accZLabel));

        // Panelleri ana çerçeveye ekle
        add(gyroPanel);
        add(accPanel);
    }

    // Etiketleri kutucuk içine almak için yardımcı metod
    private JPanel createLabeledPanel(JLabel label) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Çerçeve ekle
        return panel;
    }

    public void updateValues(double gyroX, double accX, double gyroY, double accY, double gyroZ, double accZ) {
        // Ekran üzerindeki değerleri güncelle
        SwingUtilities.invokeLater(() -> {
            gyroXLabel.setText("CayroX: " + gyroX);
            gyroYLabel.setText("CayroY: " + gyroY);
            gyroZLabel.setText("CayroZ: " + gyroZ);
            accXLabel.setText("IvmeX: " + accX);
            accYLabel.setText("IvmeY: " + accY);
            accZLabel.setText("IvmeZ: " + accZ);
        });
    }
}
