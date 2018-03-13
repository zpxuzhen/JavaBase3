package com.test7.screenShot;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/*
 * ��ͼ����
 */
public class ScreenShotTest1 {
	
	private ScreenShotTest1() {
	}
	
	//��ȡͼƬָ��λ�ô�С
	public static void ImgCut(String src, String dest, int x, int y, int width, int height){
		try {
			  // ȡ��ͼƬ������
			  Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
			  ImageReader reader = (ImageReader) readers.next();
			  // ȡ��ͼƬ������
			  ImageInputStream imageInputStream= ImageIO.createImageInputStream(new FileInputStream(src));
			  reader.setInput(imageInputStream, true);
			  // ����ͼƬ����
			  ImageReadParam param = reader.getDefaultReadParam();
			  param.setSourceRegion(new Rectangle(x, y, width, height));
			  //����µ�ͼƬ
			  BufferedImage saveImage = reader.read(0, param);
			  ImageIO.write(saveImage, "jpg", new File(dest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ��Ļָ��λ�ô�С
	public static void Shot(String filename,int x, int y, int width, int height) {
		
		try {
			BufferedImage saveImage = new Robot().createScreenCapture(new Rectangle(x, y, width, height));
			ImageIO.write(saveImage, "jpg", new File(filename));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		//�ļ���
		String filename = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
		//��ȡ��Ļ�ߴ�
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//��ȡ��Ļ
//		ScreenShot.Shot("d://"+filename+".jpg",0, 0, d.width, d.height);
		//��ȡͼƬ
		ScreenShotTest1.ImgCut("d://2.jpg", "d://3.jpg",200,2100, 2900, 2400);
	}
	
}
