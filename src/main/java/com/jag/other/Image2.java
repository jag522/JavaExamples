package com.jag.other;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

public class Image2 {
	
	public static void main(String[] args) {
		Image2 img = new Image2();
		img.compressJpegFile(new File("C:/mainBG.png"), new File("c:/output.jpg"), 0.5f);
	}

	// Reads the jpeg image in infile, compresses the image,
	// and writes it back out to outfile.
	// compressionQuality ranges between 0 and 1,
	// 0-lowest, 1-highest.
	public void compressJpegFile(File infile, File outfile, float compressionQuality) {
	    try {
	        // Retrieve jpg image to be compressed
	        RenderedImage rendImage = ImageIO.read(infile);

	        // Find a jpeg writer
	        ImageWriter writer = null;
	        Iterator iter = ImageIO.getImageWritersByFormatName("png");
	        if (iter.hasNext()) {
	            writer = (ImageWriter)iter.next();
	        }

	        // Prepare output file
	        ImageOutputStream ios = ImageIO.createImageOutputStream(outfile);
	        writer.setOutput(ios);

	        // Set the compression quality
	        ImageWriteParam iwparam = new MyImageWriteParam();
	        iwparam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
	        iwparam.setCompressionQuality(compressionQuality);

	        // Write the image
	        writer.write(null, new IIOImage(rendImage, null, null), iwparam);

	        // Cleanup
	        ios.flush();
	        writer.dispose();
	        ios.close();
	    } catch (IOException e) {
	    }
	}

	// This class overrides the setCompressionQuality() method to workaround
	// a problem in compressing JPEG images using the javax.imageio package.
	public class MyImageWriteParam extends JPEGImageWriteParam {
	    public MyImageWriteParam() {
	        super(Locale.getDefault());
	    }

	    // This method accepts quality levels between 0 (lowest) and 1 (highest) and simply converts
	    // it to a range between 0 and 256; this is not a correct conversion algorithm.
	    // However, a proper alternative is a lot more complicated.
	    // This should do until the bug is fixed.
	    public void setCompressionQuality(float quality) {
	        if (quality < 0.0F || quality > 1.0F) {
	            throw new IllegalArgumentException("Quality out-of-bounds!");
	        }
	        this.compressionQuality = 256 - (quality * 256);
	    }
	}

}
