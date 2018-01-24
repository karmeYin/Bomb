package yin.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileCollectionUtil
{
	public void fileCopy(String file)
	{
		//查找电脑中所有的图片然后集中放到一个文件夹
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;
		File f=new File(file);
		String[] str=f.list();
		if(str!=null)
		{
			for(int x=0;x<str.length;x++)
			{
				File f1=new File(file+"\\"+str[x]);
				if(f1.isDirectory())
				{
					fileCopy(file+"\\"+str[x]);
				}
				else
				{
					if(str[x].endsWith(".JPG"))
					{
						try {
							bos=new BufferedOutputStream((new FileOutputStream("f:\\±¸·ÝÎÄµµ\\jpeg"+str[x])));
							bis=new BufferedInputStream((new FileInputStream(file+"\\"+str[x])));
							byte[] b=new byte[1024];

							int num=bis.read(b);
							while(num>0)
							{
								bos.write(b);
								num=bis.read(b);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally
						{
							try {
								bis.close();
								bos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}
			}
		}
	}
}
public class Collection 
{
	public static void main(String[] args) 
	{
		String str="e:\\";
		FileCollectionUtil fcu=new FileCollectionUtil();
		fcu.fileCopy(str);
	
		
	}

}
