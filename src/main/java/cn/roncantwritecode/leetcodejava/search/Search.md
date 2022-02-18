### 题目描述
33.搜索旋转排序数组

整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

示例 1：
```
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
```

示例 2：
```
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
```

示例 3：
```
输入：nums = [1], target = 0
输出：-1
```

说明：

- 1 <= nums.length <= 5000
- -10^4 <= nums[i] <= 10^4
- nums 中的每个值都 独一无二
- 题目数据保证 nums 在预先未知的某个下标上进行了旋转
- -10^4 <= target <= 10^4
  
进阶： 你可以设计一个时间复杂度为 O(log n) 的解决方案吗？


### 题解

#### 算法1 二分法 O(log n)

进阶要求中的时间复杂度O(log n)可以判断属于二分法查找，但是该数组不是严格意义的有序数组。仔细思考，将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也可能是部分有序。部分有序这个一直二分下去即可。时间复杂度O(log n)。


```$java
public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int middle;
    while (left <= right) {
        middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[left] <= target && target < nums[middle]) {
            // 左边有序，且匹配
            right = middle - 1;
        } else if (nums[middle] < target && target <= nums[right]) {
            // 右边有序，且匹配
            left = middle + 1;
        } else {
            // 确定有序的没有匹配，对不确定是否有序的做二分
            if (nums[left] <= nums[middle]) {
                left = middle + 1;
            } else  {
                right = middle - 1;
            }
        }
    }
    return -1;
}
```