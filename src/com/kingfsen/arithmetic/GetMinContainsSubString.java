package com.kingfsen.arithmetic;

/**
 * 获取最小包含的子串
 * str1="some3gs", str2="og" -> ome3g
 */
public class GetMinContainsSubString {

    public static String getMinSubString(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() > str1.length()) {
            return "";
        }
        int[] charCount = new int[256];
        char[] parentArray = str1.toCharArray();
        char[] subArray = str2.toCharArray();
        for (int i=0;i<subArray.length;i++) {
            charCount[subArray[i]]++;
        }
        //最小子串右边界位置
        int i = 0;
        //最小子串左边界位置
        int j = 0;
        //需要匹配的总字符数
        int match = str2.length();
        String minSubString = "";
        while(i != parentArray.length) {
            char c = parentArray[i];
            charCount[c]--;
            //减1之后还大于等于0,表示之前存在该字符
            if (charCount[c] >= 0) {
                match--;
            }
            //此时已全部匹配,i则是右边界位置，此时还需压缩左边界位置
            if (match == 0) {
                while(charCount[parentArray[j++]] == -1 ) {
                    minSubString = str1.substring(j + 1, i + 1);
                    return minSubString;
                }
            }
            i++;
        }
        return minSubString;
    }

    public static void main(String[] args) {
        String str1 = "some45baby";
        String str2 = "m4a";
        System.out.println(getMinSubString(str1, str2));
    }
}
