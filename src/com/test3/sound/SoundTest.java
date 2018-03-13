package com.test3.sound;

import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * java对声音的操作
 * @author xuzhen
 *
 */
public class SoundTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.创建一个AePlayWave对象实例
		AePlayWave apw=new AePlayWave("src/com/test3/sound/111.wav");
		//2.启动该线程播放
		apw.start();
	}

}

//播放声音的类
class AePlayWave extends Thread{
	private String filename;
	public AePlayWave(String wavfile){
		filename = wavfile;
	}
	
	public void run() {
		File soundFile = new File(filename);
		
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		auline.start();
		int nBytesRead = 0;
		//这是缓冲
		byte[] abData = new byte[1024];
		
		try {
			while(nBytesRead != -1){
				nBytesRead = audioInputStream.read(abData,0,abData.length);
				if(nBytesRead >= 0){
					auline.write(abData, 0, nBytesRead);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			auline.drain();
			auline.close();
		}
	}
}