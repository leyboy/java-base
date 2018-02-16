package io;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class TestIO {

	private static final String FILE_PATH = "E:/1.log";

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * Reader & Write is char stream,often use to operate disk file
	 * <p>
	 * test write file in disk and use FileWriter Class
	 **/
	@Test
	public void testWriteFileInDisk() throws Exception {
		// 在文件末尾追加数据
		FileWriter fileWriter = new FileWriter(FILE_PATH, true);
		fileWriter.write("Hello World\r\n");
		fileWriter.write("武炼巅峰");
		fileWriter.flush();// 刷新缓冲区
		System.out.println("file write");
		fileWriter.close();
	}

	/**
	 * test read file in disk
	 * <p>
	 * use FileReader Class
	 * <p>
	 * use char[] buf
	 **/
	@Test
	public void testReadFileInDisk() throws Exception {
		FileReader fileReader = new FileReader(FILE_PATH);
		char[] buf = new char[30];
		while ((fileReader.read(buf)) != -1) {
			continue;
		}
		System.out.println(buf);
		fileReader.close();
	}

	/**
	 * test copy file
	 **/
	@Test
	public void testCopyFile()throws Exception {
		System.out.println("请输入拷贝文件的路径: ");
		Scanner in=new Scanner(System.in);
		String src=in.next();
		System.out.println("请输入拷贝文件到路径的文件生成名: ");
		String dest=in.next();
		in.close();
		copyFile(src, dest);
		System.out.println("复制完毕");
	}

	private void copyFile(final String src, final String dest) throws Exception {
		FileReader fileReader=new FileReader(src);
		FileWriter fileWriter=new FileWriter(dest);
		char[] buf=new char[1024];
		int length=0;
		int off=0;
		while((length=fileReader.read(buf))!=-1){
			fileWriter.write(buf,off,length);
			off=length;
			System.out.println(off+":"+length);
		}
		fileWriter.flush();
		fileReader.close();
		fileWriter.close();
	}
	
	
	/**
	 * test buffered reader
	 * <p>
	 * BufferedReader
	 * **/
	@Test
	public void testBufferedReader()throws Exception{
		FileReader fileReader=new FileReader(FILE_PATH);
		BufferedReader bReader=new BufferedReader(fileReader);
		while(true){
			String string=bReader.readLine();
			if(string==null){
				break;
			}
			System.out.println(string);
		}
		fileReader.close();
		bReader.close();
	}
	

	Map<String, Object> map=new HashMap<String, Object>();
	Map<String, Object> linkedListMap=new LinkedHashMap<>();
	Thread thread;
	URLDecoder urlDecoder;
	
	@Test
	public void testStringSplit(){
		String string="a,b,c,d,";
		String[] array=string.split(",");
		System.out.println(array.length);
		System.out.println(array[3]);
		for(String string2 : array){
			System.out.println(string2);
		}
	}
	
	
	@Test
	public void testMapEntrySet(){
		long startTime=System.currentTimeMillis();
		Map<String, String> map=new HashMap<>();
		map.put("1", "Hello World!");
		map.put("2", "Hello");
		map.put("3", "World");
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
	
	@Test
	public void testMapKeySet(){
		Map<String, String> map=new HashMap<>();
		map.put("1", "Hello World!");
		map.put("2", "Hello");
		map.put("3", "World");
		for(String key : map.keySet()){
			System.out.println(key+":"+map.get(key));
		}
	}
}
