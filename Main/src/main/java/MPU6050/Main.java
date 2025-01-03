package MPU6050;

import JavaFrame.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(); // Ana çerçeve oluşturuluyor
        mainFrame.setVisible(true); // Çerçeve görünür hale getiriliyor
        
        RS232_Haberlesme rs232Haberlesme = new RS232_Haberlesme(); // RS232 haberleşmesi başlatılıyor
        MPU6050_Motion motion = new MPU6050_Motion(); // MPU6050 hareket sınıfı oluşturuluyor
        
        // Veri dinleme döngüsü
        new Thread(() -> {
            while (true) {
                String data = rs232Haberlesme.readData();
                if (data != null) {
                    System.out.println("Gelen Veri: " + data); // Konsola gelen veri yazdırılıyor
                    motion.updateValues(data); // Veriler güncelleniyor
                    
                    // Ekranı hemen güncelle
                    mainFrame.updateValues(
                        motion.getGyroX(), motion.getAccX(),
                        motion.getGyroY(), motion.getAccY(),
                        motion.getGyroZ(), motion.getAccZ()
                    ); // Çerçeve güncelleniyor
                }
                try {
                    Thread.sleep(50); // 50 ms bekle, her 50 ms'de bir veri kontrol edilir
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}