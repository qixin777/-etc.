import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileUtil {
	public static String pathname ="data"; 
	public static void read()
	{
	    ArrayList<String> result=new ArrayList<String>();
		File filename = new File(pathname); 
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(
					new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader); 
			String line = "";
	
				line = br.readLine();
		while (line != null) {
			try{
				System.out.println(line);
				line = br.readLine(); 
				result.add(line);
			}catch(Exception e)
			{
				System.out.println("");
			}
			
		}} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	public static void write(String content)
	{
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(pathname, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
