### 题目描述
5. 最大回文子串

给你一个字符串 s，找到 s 中最长的回文子串。


示例1:
```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

示例2:
```
输入：s = "cbbd"
输出："bb"
```

示例3:
```
输入：s = "a"
输出："a"
```

示例4:
```
输入：s = "ac"
输出："a"
```

提示：

* 1 <= s.length <= 1000
* s 仅由数字和英文字母（大写和/或小写）组成


### 题解

#### 算法1 动态规划 O(n*n)

不管是奇数回文还是偶数回文，只要长度大于2， s[i:j] 是回文串，并且 s 的第 i-1 和 j+1 个字母相同时，s[i-1:j+1] 才会是回文串。长度等于1时是回文，长度等于2时相同是回文，长度等于3时首尾相同是回文。以此类推，对于回文长度从1开始做枚举（循环），判断各个子字符串是否满足i,j边界相同并且子串i+1,j-1是回文。时间复杂度O(n*n)


```$java
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
```
