package com.example.demo.util;

import java.util.Random;

/**
 * @author: Leonezhurui
 * @Date: 2022/2/18 - 3:55 下午
 * @Package: 后端mybatis版本
 */

public class RandomUtil {
    /**
     * 随机获取0或1
     * @return 0｜1
     */
    public static Integer getRandomIsCompleted(){
        Random random = new Random();
        return random.nextInt(2);
    }
    /**
     * 随机获取一个长度为3-10的英文title
     * @return string
     */
    public static String getRandomtitle(){
        return getRandomString(3, 10);
    }

    public static String getRandomString(int minLength, int maxLength) {
        Random random = new Random();
        int number = random.nextInt(maxLength - minLength) + minLength;
        return getRandomString(number);
    }

    public static String getRandomString(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
