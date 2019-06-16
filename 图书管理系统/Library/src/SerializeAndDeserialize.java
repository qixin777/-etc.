

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
				isexit = true;// 序列化文件存在,追加内容
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file,!isFirst);
			// 每次new的时候都会写入一个StreamHeader,所以要把屁股后面的StreamHeader去掉
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			long pos = 0;// 可以说是文件的长度
			if (isexit) {
				// getChannel()返回此通道的文件位置，这是一个非负整数，它计算从文件的开始到当前位置之间的字节数
				pos = fileOutputStream.getChannel().position() - 4;// StreamHeader有4个字节所以减去
				// 将此通道的文件截取为给定大小
				fileOutputStream.getChannel().truncate(pos);
			}else if(isFirst)
			{
				pos = fileOutputStream.getChannel().position();
				fileOutputStream.getChannel().truncate(pos);
			}
	 
			objectOutputStream.writeObject(obj);
			// 关闭流
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
