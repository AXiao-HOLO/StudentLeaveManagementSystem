package com.student.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {
    /**
     * 密码加密
     * @param password 明文密码
     * @return 加密后的密码
     */
    public static String encryptPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

     /**
     * 密码校验
     * @param password 明文密码
     * @param encryptedPassword 加密后的密码
     * @return 是否校验通过
     */
    public static boolean checkPassword(String password,String encryptedPassword){
        return BCrypt.checkpw(password,encryptedPassword);
    }
}
