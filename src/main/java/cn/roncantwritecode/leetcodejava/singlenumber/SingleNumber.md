### 题目描述
136.只出现一次的数字

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
```
输入: [2,2,1]
输出: 1
```

示例 2:
```
输入: [4,1,2,1,2]
输出: 4
```


### 题解

#### 算法1 哈希 O(n)

遍历所有元素存入哈希表中，如果已存在则删除，最终结果为哈希表中剩余的。由于对数组遍历，所以时间复杂度为O(n)
由于新增了额外的空间，不符合说明中的情况

```$java
/**
 * 哈希 O(n)
 * @param nums
 * @return
 */
public int singleNumber(int[] nums) {
    Map<Integer, Object> map = new HashMap<>(nums.length);
    for (int num : nums) {
        if (map.containsKey(num)) {
            map.remove(num);
        } else {
            map.put(num, null);
        }
    }

    return map.keySet().iterator().next();
}
```

#### 算法2 位运算异或 O(n)

该算法查看了LeetCode官方解法中的位运算。

概念：
- 如果对0和a做异或，得到的仍然是a
- 如果对a和a做异或，得到的是0
- 位运算满足交换律和结合律

根据以上概念，且数组中出现的是两次和一次，对所有数字做异或，最终结果就是唯一的数字

```$java
/**
 * 哈希 O(n)
 * @param nums
 * @return
 */
public int singleNumber(int[] nums) {
    Map<Integer, Object> map = new HashMap<>(nums.length);
    for (int num : nums) {
        if (map.containsKey(num)) {
            map.remove(num);
        } else {
            map.put(num, null);
        }
    }

    return map.keySet().iterator().next();
}