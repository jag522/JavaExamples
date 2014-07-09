package com.jag.nio;

import java.nio.channels.*;
import java.io.*;
public class Untitled1
{
public static void main(String[] args)
{
try
{
FileOutputStream a=new FileOutputStream("c:\\test.txt",true);
FileChannel c=a.getChannel() ;
FileLock l=c.tryLock();
//如果得不到锁，说明文件已被锁住了
if(l==null)System.out.println("file is locked!") ;
else System.out.println("file is not locked!");
a.close() ;
}catch(Exception ex){ex.printStackTrace() ;}
}
} 