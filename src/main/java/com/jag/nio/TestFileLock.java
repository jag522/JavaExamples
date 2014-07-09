package com.jag.nio;

//�ж��ļ��Ƿ��
import java.io.RandomAccessFile;
import java.nio.channels.*;
public class TestFileLock {
  public static void main(String[] args) throws Exception{
    Runnable r = new Runnable(){
      public void run()
      {
        try{
          RandomAccessFile raf = new RandomAccessFile ("c:\\test.txt","rw");
          FileChannel fc = raf.getChannel();
          //��ͼȥ�õ�������
          FileLock lock = fc.tryLock();
          if(lock!=null)
          {
              System.out.println(Thread.currentThread().getName()+": Open the File");
              Thread.sleep(10000);
              lock.release();
              System.out.println(Thread.currentThread().getName()+": Release the File.");
          }
          else
            System.out.println(Thread.currentThread().getName()+": Because the file is being used, you can't get the file lock.");      
        }catch(Exception e)
        {
          
        }

      }
    };
    //���̴߳��ļ����õ���
	new Thread(r).start();
	//���̵߳ò�������
	new Thread(r).start();
  }
  
}
