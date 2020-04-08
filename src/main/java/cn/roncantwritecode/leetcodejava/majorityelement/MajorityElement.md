### 题目描述
169.多数元素

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1 :
```
输入: [3,2,3]
输出: 3
```

示例 2 :
```
输入: [2,2,1,1,1,2,2]
输出: 2
```

### 题解

#### 算法1 哈希 O(n)

循环遍历数组，将每个数值出现次数存入哈希表中。最后遍历哈希表获取最大次数的值。时间复杂度O(n)


```$java
/**
 * 哈希 O(n)
 * @param nums
 * @return
 */
public int majorityElement(int[] nums) {
    // 记录出现次数
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
        if (countMap.containsKey(num)) {
            countMap.put(num, countMap.get(num) + 1);
        } else {
            countMap.put(num, 1);
        }
    }

    // 循环hash获取次数最多值
    Map.Entry<Integer, Integer> maxEntry = null;
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        if (maxEntry == null || entry.getValue() > maxEntry.getValue() ) {
            maxEntry = entry;
        }
    }


    return maxEntry.getKey();
}
```

#### 算法2 投票算法 O(n)

参考leetcode官方题解

- 第一个数字当成选举数
- 相同数字count加1，不同数字count减1
- 当count变为0时，下一个数字为选举数

由于该题目中的众数超过一半，所以当count变为0时，后面的数字中众数肯定超过一半，即最终选举数肯定为该众数。时间复杂度为O(n)，空间复杂度O(1).


```$java
/**
 * 投票法 O(n)
 * @param nums
 * @return
 */
public int majorityElementCandidate(int[] nums) {
    int count = 0;
    int candidate = 0;
    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        if (candidate == num) {
            count ++;
        } else {
            count --;
        }
    }

    return candidate;
}
```


