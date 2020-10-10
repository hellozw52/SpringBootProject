package com.imooc.demo.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @<p>Title:md5加密工具类</p>
 * @<p>Description:对字符串进行md5加密</p>
 * @<p>Company:</p>
 * @author: lwh
 * @Date: 2019-12-11
 * 
 */
public class MD5Util {
	
	/**
	 * @Description:对字符串进行md5加密
	 * @param str 字符串
	 * @return String加密后的字符串
	 * @throws 
	 * @author lwh
	 * @date 2019-12-11
	 */
	public static String string2MD5(String str){
		try {
			//拿到一个MD5转换器，如果想要转换SHA1参数换成“SHA1”
			MessageDigest md = MessageDigest.getInstance("MD5");
			//输入的字符串转成字节数组
			byte[] inputByteArray = str.getBytes();
			md.update(inputByteArray);
			byte[] resultByteArray = md.digest();
			return byteArrayToHex(resultByteArray).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @Description:md5加密方法
	 * @param bytes
	 * @return String
	 * @throws 
	 * @author lwh
	 * @date 2019-12-11
	 */
	public static String byteArrayToHex(byte[] bytes){
		//首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//new一个字符数组，这个是用来组成结果字符串的（一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[bytes.length*2];
		//遍历字节数组，通过位运算，转换成字符放到字符数组中去
		int index = 0;
		for(byte b:bytes){
			resultCharArray[index++] = hexDigits[b>>>4&0xf];
			resultCharArray[index++] = hexDigits[b&0xf];
		}
		//返回数组组合成字符串返回
		return new String(resultCharArray);
	}


	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr){

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++){
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}


	public static void main(String[] args) {
		String s = "123456";
		System.out.println("MD5后：" + string2MD5(s));
		System.out.println("解密的：" + convertMD5(convertMD5(s)));
    }

}
