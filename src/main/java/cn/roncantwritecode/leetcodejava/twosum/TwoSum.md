### 题目描述
1.两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 题解

#### 算法1 枚举 O(n*n)
循环嵌套枚举下标i和j，判断nums[i] + nums[j] = target。时间复杂度O(n*n)

```$java
/**
 * 枚举 时间复杂度O(n*n)
 * @param nums
 * @param target
 * @return
 */
public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i=0; i < nums.length; i++) {
        for (int j=i+1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
    }
    return result;
}
```

#### 算法2 哈希 O(n)
只执行一次循环，将前面数字存储到hashMap中，判断target - nums[i]是否在HashMap中，如存在则可以返回结果。时间复杂度
O(n)
```$java
/**
 * 哈希 时间复杂度O(n)
 * @param nums
 * @param target
 * @return
 */
public int[] twoSumHash(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>(nums.length-1);
    for (int i=0; i < nums.length; i++) {
        int other = target - nums[i];
        if (map.containsKey(other)) {
            result[0] = map.get(other);
            result[1] = i;
            break;
        }
        map.put(nums[i], i);
    }
    return result;
}
```