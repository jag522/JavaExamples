package com.jag.other;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图象处理
 * 
 * @author jag522
 * 
 */
public class Image {
	public static void main(String[] args) {
//		batchProcess();
		
//		compressImage("C:/duck.jpg", "c:/duck_output.jpg");
		compressImage("C:/duck.jpg", 210, 210);
	}

	/**
	 * 对图象进行批处理
	 */
	public static void batchProcess() {
		int counter = 0;
		String s = "e:/jpg/";
		File dir = new File(s);
		if (dir.isDirectory()) {
			String[] files = dir.list();
			for (int i = 0; i < files.length; i++) {
				String filepath = s + files[i];
				File f = new File(filepath);
				if (f.length() > 32768) { // 如果图象超过32K，进行压缩
					System.out.println(files[i] + " size:" + f.length());
					counter++;
//					 compressImage(filepath, "e:/jpg60-100/" + files[i]);
//					copyFile("e:/jpg/", "e:/jpg2/", files[i]);
//					delFile("e:/jpg2/",files[i]);
//					renameFile("e:/jpg2/",files[i],files[i].substring(0,15)+".jpg");
				}
			}
		}
		System.out.println(counter + " files has been processed successfully!");
	}

	public static String getImageSize(String filename) {
		String rtval = "";
		try {
			BufferedImage bufImg = ImageIO.read(new FileInputStream(filename));
			rtval = "width:" + bufImg.getWidth() + ",height:"
					+ bufImg.getHeight();
		} catch (IOException exp) {
			exp.printStackTrace();
			rtval = "error";
		}
		return rtval;
	}

	public static void compressImage(String filename, String outputFile) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(filename));
			FileOutputStream out = new FileOutputStream(outputFile);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			// 设置图片的压缩比
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
			// public void setQuality(float quality, boolean forceBaseline)
			// quality取值在 1.0 到 0.0 之间
			// Some guidelines: 0.75-high quality; 0.5-medium quality; 0.25-low quality
			param.setQuality(0.5f, false);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(image);
			image.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 要得到一张指定高度和宽度的图片
	 * 
	 * @param filename
	 * @param height
	 * @param width
	 */
	public static void compressImage(String filename, int height, int width) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(filename));
			System.out.println(image.getHeight());
			// 注意第一行新建 BufferedImage 的时候要使用原图片的type，这样可以保证输出与原图片相同质量的图片
			BufferedImage tag = new BufferedImage(height, width, image.getType());
			tag.getGraphics().drawImage(image, 0, 0, height, width, null); // 绘制缩小后的图
			FileOutputStream out2 = new FileOutputStream("c:\\out2.jpg");
			JPEGImageEncoder encoder2 = JPEGCodec.createJPEGEncoder(out2);
			JPEGEncodeParam param2 = encoder2.getDefaultJPEGEncodeParam(tag);
			param2.setQuality(1f, false);
			encoder2.setJPEGEncodeParam(param2);
			encoder2.encode(tag);
			out2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFile(String from_name, String to_name, String filename){
		try {
			FileInputStream from = null;
			FileOutputStream to = null;
			try {
				from = new FileInputStream(from_name + filename);
				to = new FileOutputStream(to_name + filename);
				byte[] buffer = new byte[4096];
				int bytes_read;

				while ((bytes_read = from.read(buffer)) != -1)
					to.write(buffer, 0, bytes_read);
			} finally {
				if (from != null)
					try {
						from.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
				if (to != null)
					try {
						to.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void delFile(String dir, String filename) {
		try {
			File f = new File(dir,filename);
			f.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void renameFile(String dir, String filename, String newname) {
		try {
			File f = new File(dir,filename);
			File f2 = new File(dir,newname);
			f.renameTo(f2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
