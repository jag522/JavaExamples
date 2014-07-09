package com.jag.nio;

//判断文件是否打开
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
          //试图去得到排他锁
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
    //此线程打开文件，得到锁
	new Thread(r).start();
	//此线程得不到锁了
	new Thread(r).start();
  }
  
}
