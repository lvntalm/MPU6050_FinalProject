#include <Wire.h>
#include <MPU6050_tockn.h>

MPU6050 mpu(Wire);

void setup() {
  Serial.begin(9600);  // Seri haberleşme başlatılıyor
  Wire.begin();        // I2C başlatılıyor

  mpu.begin();         // MPU6050 başlatılıyor
  mpu.calcGyroOffsets(); // Sensör ofsetlerini kalibre ediyor
}

void loop() {
  mpu.update(); // Sensör verilerini güncelle

  // Java uygulamasının beklediği formatta veri gönderiyoruz
  Serial.print("CayroX: ");
  Serial.print(mpu.getGyroX());
  Serial.print("\t");

  Serial.print("IvmeX: ");
  Serial.print(mpu.getAccX());
  Serial.print("\t");

  Serial.print("CayroY: ");
  Serial.print(mpu.getGyroY());
  Serial.print("\t");

  Serial.print("IvmeY: ");
  Serial.print(mpu.getAccY());
  Serial.print("\t");

  Serial.print("CayroZ: ");
  Serial.print(mpu.getGyroZ());
  Serial.print("\t");

  Serial.print("IvmeZ: ");
  Serial.println(mpu.getAccZ()); // Her döngüde yeni satıra geç

  delay(500); // 500 ms bekle
}
