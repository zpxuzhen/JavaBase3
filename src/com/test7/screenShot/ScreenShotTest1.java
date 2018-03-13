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
 * 截图工具
 */
public class ScreenShotTest1 {
	
	private ScreenShotTest1() {
	}
	
	//截取图片指定位置大小
	public static void ImgCut(String src, String dest, int x, int y, int width, int height){
		try {
			  // 取得图片读入器
			  Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
			  ImageReader reader = (ImageReader) readers.next();
			  // 取得图片读入流
			  ImageInputStream imageInputStream= ImageIO.createImageInputStream(new FileInputStream(src));
			  reader.setInput(imageInputStream, true);
			  // 设置图片参数
			  ImageReadParam param = reader.getDefaultReadParam();
			  param.setSourceRegion(new Rectangle(x, y, width, height));
			  //获得新的图片
			  BufferedImage saveImage = reader.read(0, param);
			  ImageIO.write(saveImage, "jpg", new File(dest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 截取屏幕指定位置大小
	public static void Shot(String filename,int x, int y, int width, int height) {
		
		try {
			BufferedImage saveImage = new Robot().createScreenCapture(new Rectangle(x, y, width, height));
			ImageIO.write(saveImage, "jpg", new File(filename));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		//文件名
		String filename = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
		//获取屏幕尺寸
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		//截取屏幕
//		ScreenShot.Shot("d://"+filename+".jpg",0, 0, d.width, d.height);
		//截取图片
		ScreenShotTest1.ImgCut("d://2.jpg", "d://3.jpg",200,2100, 2900, 2400);
	}
	
}
