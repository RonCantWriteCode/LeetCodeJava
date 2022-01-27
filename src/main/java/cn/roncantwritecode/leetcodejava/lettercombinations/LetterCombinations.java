package cn.roncantwritecode.leetcodejava.lettercombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ron Wu
 * @date 2022/1/27
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "";
        List<String> result = letterCombinations.letterCombinations(digits);
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        StringBuffer result = new StringBuffer();

        // 对应关系定义
        Map<Character, String> phoneMap = new HashMap();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // 递归调用
        addLetterCombination(digits, 0, phoneMap, result, resultList);

        return resultList;
    }

    private void addLetterCombination(String digits, int index, Map<Character, String> phoneMap, StringBuffer combination, List<String> resultList) {
        if (digits.length() == 0) {
            return;
        }
        if (index == digits.length()) {
            // 最后一位将结果记录下俩
            resultList.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            // 循环下一位的所有情况
            for (int i=0; i < letters.length(); i++) {
                // 记录当前位字母
                combination.append(letters.charAt(i));
                // 深度遍历递归调用获取下一位的所有情况
                addLetterCombination(digits, index+1,phoneMap, combination, resultList);
                // 删除当前位字母，后面复用combination
                combination.deleteCharAt(index);
            }
        }

    }
}
