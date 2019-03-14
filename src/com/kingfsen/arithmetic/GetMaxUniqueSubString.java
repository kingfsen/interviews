package com.kingfsen.arithmetic;

/**
 * author:SUNJINFU
 * date:2019/3/14
 */
public class GetMaxUniqueSubString {


    public static String getMaxUniqueString(String str) {
        if (str == null || str.length() == 0 ) {
            return "";
        }
        //循环过程中保存的最长字符串
        String maxUniqueStr = "";
        //标记位
        int mark = 0;
        char[] chars = str.toCharArray();
        //存放字符的位置
        int[] position = new int[256];
        //位置都初始化-1,表示未发现
        for (int i=0;i<position.length;i++) {
            position[i] = -1;
        }
        for (int i=0;i<chars.length;i++) {
            //当前字符的上一次出现位置
            int lastPos = position[chars[i]];
            //不为-1表示之前出现过该字符
            if (lastPos != -1 && mark <= lastPos) {
                String subStr = str.substring(mark, i);
                if (subStr.length() > maxUniqueStr.length()) {
                    maxUniqueStr = subStr;
                }
                mark = lastPos + 1;
            }
            position[chars[i]] = i;
        }
        //可能漏掉结尾一段
        if (mark <= chars.length) {
            String subStr = str.substring(mark, chars.length);
            if (subStr.length() > maxUniqueStr.length()) {
                maxUniqueStr = subStr;
            }
        }

        return maxUniqueStr;
    }

    public static void main(String[] args) {
        String str = "abccd";
        String maxUniqueString = getMaxUniqueString(str);
        System.out.println(maxUniqueString);
    }
}
