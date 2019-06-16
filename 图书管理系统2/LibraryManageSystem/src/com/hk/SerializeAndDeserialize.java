package com.hk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Vector;

public class SerializeAndDeserialize {
    
    public static void SerializeBook(String fileName, Object obj,boolean isFirst) throws FileNotFoundException,
          IOException {
			boolean isexit = false;
			File file=new File(fileName);
			if (file.exists()&&!isFirst) {
				isexit = true;// ���л��ļ�����,׷������
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file,!isFirst);
			// ÿ��new��ʱ�򶼻�д��һ��StreamHeader,����Ҫ��ƨ�ɺ����StreamHeaderȥ��
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			long pos = 0;// ����˵���ļ��ĳ���
			if (isexit) {
				// getChannel()���ش�ͨ�����ļ�λ�ã�����һ���Ǹ���������������ļ��Ŀ�ʼ����ǰλ��֮����ֽ���
				pos = fileOutputStream.getChannel().position() - 4;// StreamHeader��4���ֽ����Լ�ȥ
				// ����ͨ�����ļ���ȡΪ������С
				fileOutputStream.getChannel().truncate(pos);
			}else if(isFirst)
			{
				pos = fileOutputStream.getChannel().position();
				fileOutputStream.getChannel().truncate(pos);
			}
	 
			objectOutputStream.writeObject(obj);
			// �ر���
			objectOutputStream.close();
			fileOutputStream.close();
}

    
    
    public static Vector<Book> DeserializeBook(String fileName) throws Exception, IOException {
    	File file=new File(fileName);
    	boolean isexit=false;
    	if(file.exists())
    	{
    		isexit = true;
    	}
    	FileInputStream fileInputStream = null;
    	ObjectInputStream objectInputStream = null;
    	Vector<Book> vec=new Vector<Book>(); 
    	if(isexit)
    	{
	    	try {
	    		fileInputStream = new FileInputStream(file);
	    		objectInputStream = new ObjectInputStream(fileInputStream);
	    		while (fileInputStream.available() > 0) {
	    			vec.add((Book) objectInputStream.readObject());
	    		}
	
	    	} catch (FileNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} catch (ClassNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
    	}
    	
    	return vec;
    }

}
