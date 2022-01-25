package cn.roncantwritecode.leetcodejava.longestpalindrome;

/**
 * @author Ron Wu
 * @date 2022/1/25
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "aaaaa";
        String result = longestPalindrome.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 循环枚举满足回文的各个子串的长度
        for (int length=1; length <= s.length(); length++) {
            // 循环满足长度的各个子串
            for (int i = 0; i < s.length() - length + 1; i++) {
                int j = length + i - 1;
                // 如果边界相同的 并且 （长度小于等于2 或者 子串是回文）
                if (charArray[i] == charArray[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    // 记录起始位置和最大长度
                    begin = i;
                    maxLen = j - i + 1;
                    // 同一个长度只记录第一个结果   不能跳出结果，否则后续取不到前面的值，不满足动态规划思想
//                    break;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
