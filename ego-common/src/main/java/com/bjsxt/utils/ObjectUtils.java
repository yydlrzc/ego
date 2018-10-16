package com.bjsxt.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectUtils {

	/***
	 * 将对象序列化为byte数组
	 * **/
	public static byte[] objToByte(Object obj){

		try {
			//创建输出流对象
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			
			//创建对象输出流
			ObjectOutputStream oos=new ObjectOutputStream(baos);
			
			//该对象被写入到baos的数组属性中
			oos.writeObject(obj);
			
			//获得字节数组，该数组中保存着对象数据
			byte[] buf = baos.toByteArray();
			
			oos.flush();
			oos.close();
			baos.close();
			
			return buf;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 进行对象的反序列化
	 * **/
	public static <T> T byteToObj(byte[] buf,Class<T> clz ){
		
		try {
			//创建输入流对象
			ByteArrayInputStream bais=new ByteArrayInputStream(buf);
			
			//创建对象输入流
			ObjectInputStream ois=new ObjectInputStream(bais);
			
			T t=(T) ois.readObject();
			
			ois.close();
			bais.close();
			
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
}
