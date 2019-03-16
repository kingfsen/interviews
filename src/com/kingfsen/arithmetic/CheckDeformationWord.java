package com.kingfsen.arithmetic;

/**
 * 判断两个单词是否是变形词
 * "abcd", "abcc" -> false
 * "abcc", "acbc" -> true
 */
public class CheckDeformationWord {

    public static boolean deformationWord(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }
        int[] charCount = new int[256];
        char[] word1ChartArray = word1.toCharArray();
        char[] word2ChartArray = word2.toCharArray();
        for (int i=0;i<word1ChartArray.length;i++) {
            charCount[word1ChartArray[i]]++;
        }
        for (int i=0;i<word2ChartArray.length;i++) {
            char c = word2ChartArray[i];
            charCount[c]--;
            if (charCount[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "regher";
        String word2 = "reehgr";
        System.out.println(deformationWord(word1, word2));

    }
}
