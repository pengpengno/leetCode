package com.peng.leetcode;

/**
 * 5. 最长回文
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindRome {
    /**
     * 中心拓展法
     * 1、 对于 回文数组 s[] 当
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
//        1. 判断串长度为1 的特殊情况
        if(s==null || s .length() ==1){
            return s;
        }
        int start =0 ,end =0;
        for(int i = 0; i<s.length() ;i++){
            int len1 = getPalindLength(s,i,i); // 尝试查询回文为长度为奇数的情况
            int len2 = getPalindLength(s,i,i+1); // 尝试查询回文为长度为偶数情况
            int len = Math.max(len1,len2);
            if (len > end - start){
                if(len == len1){
                    // 回文长度为奇数的处理情况
                    start =  i - (len -1)/2;
                    end = i + (len+1)/2-1;
                }
                else {
                    // 回文长度为偶数的处理情况
                    start =  i- len /2+1;
                    end = i + len/2;
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static int getPalindLength(String s,Integer left,Integer right){
        char[] chars = s.toCharArray();
        while (left >= 0 && right<= s.length()-1 && chars[left] == chars[right]){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s = "babdd";
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));
//        String s ="213sd";
//        System.out.println(s.charAt(0));
//        System.out.println(s.substring(0, 2));
    }
}
