### 题目描述
283.移动零

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例：
```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

说明：

- 必须在原数组上操作，不能拷贝额外的数组。
- 尽量减少操作次数。

### 题解

#### 算法1 非零移动 O(n)

循环时，将非零移动覆盖和前面为零调换位置。时间复杂度O(n)


```$java
/**
 * 非零移动 O(n)
 * @param nums
 */
public void moveZeroes(int[] nums) {
    int zeroLength = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            zeroLength++;
        } else if (zeroLength > 0) {
            nums[i - zeroLength] = nums[i];
            nums[i] = 0;
        }
    }
}
```