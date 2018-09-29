package org.great.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.junit.Test;

import sun.misc.BASE64Encoder;

public class TsecIm {
	 public static String xians(String a){
     	JBarcode jBarcode = new JBarcode(EAN13Encoder.getInstance(),WidthCodedPainter.getInstance(),
     			EAN13TextPainter.getInstance());
     	jBarcode.setShowText(true);
     	BufferedImage bufferedImage = null;
     	ByteArrayOutputStream ou =null;
     	try {
				bufferedImage = jBarcode.createBarcode(a);
				ou = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", ou);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     	
     	BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(ou.toByteArray());
     	
     }
	 public static void main(String[] args) {
		 String l =xians("1234567");
		 System.out.println(l);
	}

}
