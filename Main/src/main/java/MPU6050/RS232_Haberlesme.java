package MPU6050;

import com.fazecast.jSerialComm.SerialPort;

public class RS232_Haberlesme {
    private SerialPort comPort;

    public RS232_Haberlesme() {
        SerialPort[] ports = SerialPort.getCommPorts();
        for (SerialPort port : ports) {
            try {
                port.setComPortParameters(9600, 8, 1, 0);
                port.openPort();
                if (port.bytesAvailable() > 0) {
                    comPort = port;
                    System.out.println("Aktif seri port: " + port.getSystemPortName());
                    break;
                }
                port.closePort();
            } catch (Exception e) {
                // Hata durumunda sonraki porta geç
            }
        }

        if (comPort == null) {
            System.out.println("Aktif seri port bulunamadı.");
        }
    }

    public String readData() {
        if (comPort != null) {
            // Veri geldiğinde oku
            if (comPort.bytesAvailable() > 0) {
                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                comPort.readBytes(readBuffer, readBuffer.length);
                return new String(readBuffer).trim();
            }
        }
        return null;
    }

    public void close() {
        if (comPort != null) {
            comPort.closePort();
        }
    }
}