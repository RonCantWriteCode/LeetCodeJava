package cn.roncantwritecode.leetcodejava.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wurunlong
 * @date 2020/3/23
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String str = "pwwkew";
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring(str);
        System.out.println(result);

    }

    /**
     * 用区间扫描(双指针扫描) O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        // key为扫描取钱字符，value为字符数组下标
        Map<Character, Integer> map = new HashMap(s.length());
        int maxLength = 0;

        for (int i=-1, j=0; j < chars.length; j++) {
            // map中的小于等于i的值不需要计算重复，i是左边界。 否则"abba"会有问题
            if (map.containsKey(chars[j]) && map.get(chars[j]) > i) {
                i = map.get(chars[j]);
            }
            // 扫描区间右移
            map.put(chars[j], j);
            // 只保存最大区间
            maxLength = Math.max(maxLength, j - i);
        }

        return maxLength;

    }
}
