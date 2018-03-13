package com.test6.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

public class MyQRCode {

	private static int MAX_DATA_LENGTH = 84; // �������ɶ�ά�����������С
	private static int QrcodeVersion = 5; // 
	private static int QrcImageLength = 67+12*(QrcodeVersion-1); // 
	private static int pixoff = 2;  // ƫ����
	private static BufferedImage image;

	private class MyQRCodeImage implements QRCodeImage {

		public int getWidth() {
			return MyQRCode.image.getWidth();
		}

		public int getHeight() {
			return MyQRCode.image.getHeight();
		}

		public int getPixel(int x, int y) {
			return MyQRCode.image.getRGB(x, y);
		}
	}

	private static MyQRCodeImage getQRCodeImage() {
		return new MyQRCode().new MyQRCodeImage();
	}

	public static String decoder(String qrcFilePath) {
		/* ��ȡ��ά��ͼ������ */
		try {
			MyQRCode.image = ImageIO.read(new File(qrcFilePath));
		} catch (IOException e) {
			System.out.println("Decoding failed, read QRCode image error: " + e.getMessage());
			return null;
		}
		/* ���ά�� */
		return new String(new QRCodeDecoder().decode(getQRCodeImage()));
	}

	public static boolean encoder(String date, String qrcFilePath) {

		/* ��������*/
		MyQRCode.image = new BufferedImage(QrcImageLength, QrcImageLength, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = image.createGraphics();
		graphics2d.setBackground(Color.WHITE);
		graphics2d.clearRect(0, 0, QrcImageLength, QrcImageLength);
		graphics2d.setColor(Color.BLACK);
		
		/* ���ɶ�ά�� */
		byte[] srcDate = date.getBytes();
		if (srcDate.length > 0 && srcDate.length <= MAX_DATA_LENGTH) {
			Qrcode qrcode = new Qrcode();
			qrcode.setQrcodeErrorCorrect('M'); // L, Q, H, Ĭ��
			qrcode.setQrcodeEncodeMode('B'); // A, N, Ĭ��
			qrcode.setQrcodeVersion(QrcodeVersion); 
			boolean[][] qrcDate = qrcode.calQrcode(srcDate);
			for (int i = 0; i < qrcDate.length; i++) {
				for (int j = 0; j < qrcDate.length; j++) {
					if (qrcDate[j][i]) {
						graphics2d.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
			System.out.println("��ά�����ݳ���(�ֽ�):" + qrcDate.length);
		} else {
			System.out.println(
					"Generate QRCode image error! Data size is " + srcDate.length + ", it is lager than 84 bytes.");
			return false;
		}
		graphics2d.dispose();
		MyQRCode.image.flush();
		
		/* ����ͼƬ */
		File qrcFile = new File(qrcFilePath);
		String qrcFileName = qrcFile.getName();
		String suffix = qrcFileName.substring(qrcFileName.lastIndexOf(".") + 1, qrcFileName.length());
		try {
			ImageIO.write(MyQRCode.image, suffix, qrcFile);
		} catch (IOException ioe) {
			System.out.println("Generate QRCode image error!" + ioe.getMessage());
			return false;
		}

		return true;
	}

}