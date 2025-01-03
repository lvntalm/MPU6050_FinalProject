package MPU6050;

public class MPU6050_Motion {
    private double gyroX, gyroY, gyroZ;
    private double accX, accY, accZ;

 public void updateValues(String data) {
    try {
        String[] lines = data.split("\n"); // Her satırı ayır
        for (String line : lines) {
           // System.out.println("İşlenecek Satır: " + line); // Gelen her satırı konsola yazdır
            String[] values = line.split("\t");
            if (values.length == 6) {
                gyroX = Double.parseDouble(values[0].split(": ")[1]);
                accX = Double.parseDouble(values[1].split(": ")[1]);
                gyroY = Double.parseDouble(values[2].split(": ")[1]);
                accY = Double.parseDouble(values[3].split(": ")[1]);
                gyroZ = Double.parseDouble(values[4].split(": ")[1]);
                accZ = Double.parseDouble(values[5].split(": ")[1]);
                System.out.println("Güncellenen Değerler -> " +
                        "GyroX: " + gyroX + ", AccX: " + accX +
                        ", GyroY: " + gyroY + ", AccY: " + accY +
                        ", GyroZ: " + gyroZ + ", AccZ: " + accZ);
            }/* else {
                System.out.println("Hatalı format: " + line); // Eğer format yanlışsa bildir
            }*/
        }
    } catch (Exception e) {
        System.out.println("Veri ayrıştırma hatası: " + e.getMessage());
        e.printStackTrace(); // Hata detaylarını yazdır
    }
}



    public double getGyroX() { return gyroX; }
    public double getAccX() { return accX; }
    public double getGyroY() { return gyroY; }
    public double getAccY() { return accY; }
    public double getGyroZ() { return gyroZ; }
    public double getAccZ() { return accZ; }
}
