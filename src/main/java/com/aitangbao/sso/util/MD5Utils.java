package com.aitangbao.sso.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

	private static String salt = "sso";
	
	/**
	 * 加密字符串
	 * @param password 要加密的明文
	 * @param isAddSalt 是否加默认盐
	 * @return 加密之后的结果
	 */
	public static String Encrypt(String password, boolean isAddSalt){
		if (StringUtils.isNotEmpty(password)){
			if (isAddSalt){
				return DigestUtils.md5Hex(DigestUtils.md5(password + salt));
			} else {
				return DigestUtils.md5Hex(DigestUtils.md5(password));
			}
		}
		return null;		
	}

	
	/**
	 * MD5加盐加密
	 * @param password 要加密的明文
	 * @param salt 盐
	 * @return 加密之后的结果
	 */
	public static String Encrypt(String password, String salt){
		if (StringUtils.isNotEmpty(password)){
			return DigestUtils.md5Hex(DigestUtils.md5(password + salt));
		}
		return null;			
	}
	
	public static void main(String[] args){
		System.out.println(MD5Utils.Encrypt("admin", true));
	}
}
