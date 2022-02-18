### 题目描述

3.无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1：
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2：
```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例 3：
```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

### 题解

#### 算法1 区间扫描 O(n)
使用区间扫描的方式，或者称为双指针扫描。右指针从左到右扫描，判断是否包含重复，重复时左指针右移。时间复杂度O(n)

注意：
1. i为左指针，j为右指针，不重复字符即为该区间大小。该题保存下区间最大值即可
2. 当出现重复字符时，判断左指针位置可以使用依次向右扫描，该方法占用内存较少但是需要扫描两次。
3. 所以使用map存储字符，value为下标，当扫描重复字符时，保存最大下标
4. 判断左指针i的值的时候，由于map是保含不在区间内的字符，所以需要添加判断map.get(chars[j]) > i，否则会出现问题。例如字符“abba”。

```$java
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

```