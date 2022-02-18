### 题目描述
17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 *任意顺序* 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/letterCombinations/200px-telephone-keypad2svg.png)


示例 1：

```
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

示例 2：
```
输入：digits = ""
输出：[]
```

示例 3：
```
输入：digits = "2"
输出：["a","b","c"]
```


提示：

- 0 <= digits.length <= 4
- digits[i] 是范围 ['2', '9'] 的一个数字。


### 题解

#### 算法1 O(n*m)

类似于树的遍历，采用深度优先遍历。时间复杂度O(n*m)

```$java
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
```
