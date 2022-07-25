package com.peng.leetcode.backstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *17-电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberCombination {
    //  回溯解法
    public  static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();

        if (digits.length() == 0 ){
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backstack(res,digits,0,phoneMap,new StringBuilder());
        return res;
    }
    public static void backstack(List<String> res,String digits,Integer index,Map<Character, String> numMap,StringBuilder sb){
        //        触发结束条件
        if(index == digits.length()){
            res.add(sb.toString());
        }else {
            char c = digits.charAt(index);
            String num = numMap.get(c);
            int length = num.length();
            for(int i = 0; i < length; i++){
                sb.append(num.charAt(i));
                backstack(res,digits,index+1,numMap,sb);
                sb.deleteCharAt(index); // 回溯
            }
        }

    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        System.out.println(res);
        String s = "11111";
        System.out.println(s.charAt(0));
    }
}
