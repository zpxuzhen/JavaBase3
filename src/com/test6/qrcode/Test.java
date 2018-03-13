package com.test6.qrcode;

public class Test {

	public static void main(String[] args) {
		String data = "Good morning,Sam!";
		System.out.println("×Ö½ÚÊý: " + data.getBytes().length);
		MyQRCode.encoder(data, "images/A.JPG");
		System.out.println(MyQRCode.decoder("images/A.JPG"));
	}

}
