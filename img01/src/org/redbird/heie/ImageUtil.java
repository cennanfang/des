package org.redbird.heie;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageUtil {
	public static final String BASIC_PATH = "D:/eclipse/workspace/eclipse_041030/img01/images/";
	
	/**
	 * 测试
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(BASIC_PATH + "preview_contact_0.jpg");
		FileOutputStream fos = new FileOutputStream(BASIC_PATH + "preview_contact_1.jpg");
//		resizeImage(fis, fos, 200, "JPG");
		resizeImage(fis, fos, 720, 720, "JPG");
		
		
	}
	
	/**
	 * 改变图片的大小到宽为size，然后高随着宽等比例变化
	 * @param is 上传的图片的输入流
	 * @param os 改变了图片的大小后，把图片的流输出到目标OutputStream
	 * @param size 新图片的宽 px
	 * @param format 新图片的格式
	 * @throws IOException
	 */
	public static void resizeImage(InputStream is, OutputStream os, int size, String format) throws IOException {
		BufferedImage prevImage = ImageIO.read(is);
		double width = prevImage.getWidth();
		double height = prevImage.getHeight();
		System.out.println("with=" + width);
		double percent = size/width;
		int newWidth = (int)(width * percent);
		int newHeight = (int)(height * percent);
		BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.createGraphics();
		graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
		ImageIO.write(image, format, os);
		os.flush();
		is.close();
		os.close();
	}
	
	/**
	 * 制定长宽改变图片大小
	 * @param is 上传的图片的输入流
	 * @param os 改变了图片的大小后，把图片的流输出到目标OutputStream
	 * @param width 新图片的宽 px
	 * @param height 新图片的高度 px
	 * @param format 新图片的格式
	 * @throws IOException
	 */
	public static void resizeImage(InputStream is, OutputStream os, int width,int height, String format) throws IOException {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.createGraphics();
		graphics.drawImage(ImageIO.read(is), 0, 0, width, height, null);
		ImageIO.write(image, format, os);
		os.flush();
		is.close();
		os.close();
	}
}

