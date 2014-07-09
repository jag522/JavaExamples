package com.jag.image;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;

public class ImageUtils {
	
	/**
	 * ��ǰ�Ƿ���windows���� 
	 */
	private static boolean isWindows;

    /**  
	  * ImageMagick��·��  
	  */  
	  public static String imageMagickPath = null;   
	      
	  static{   
		  isWindows = ("" + System.getProperty("os.name")).indexOf("Windows") >= 0;
	      /**  
	       * ��ȡImageMagick��·��  
	       */  
	      //linux�²�Ҫ���ô�ֵ����Ȼ�ᱨ��   
	      imageMagickPath = "E:/Program Files (x86)/ImageMagick-6.3.9-Q16";
	      if(isWindows) {
	    	  ProcessStarter.setGlobalSearchPath(imageMagickPath);
	      }
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		resize(120, 120);
	}

	public static void resize(int w, int h) throws Exception {
		IMOperation op = new IMOperation();
		op.addImage(new String[]{"duck.jpg"});
		op.resize(new Integer(w), new Integer(h));
		op.addImage(new String[]{"duck_output.jpg"});
		ConvertCmd convert = new ConvertCmd();
		convert.run(op);
	}

}
