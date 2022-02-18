### 题目描述
11. 三数之和

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1:

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
```

示例 2:
```
输入：nums = []
输出：[]
```

示例 3:
```
输入：nums = [0]
输出：[]
```

提示:

- 0 <= nums.length <= 3000
- -105 <= nums[i] <= 105



### 题解

#### 算法1  双指针 O(n*n)

结果要求三元组不重复，所以第一步应该对数组进行排序。三数之和为0，循环迭代数组，确定第一个数字，剩余问题即对于有序的数组求两个数字 b+c=-a，可以使用双指针。由于双指针时间复杂度O(n),所以时间复杂度为O(n*n)。

```$java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    //数组排序
    Arrays.sort(nums);

    // 循环迭代第一个数字，第一个数字最小，所以i < nums.length - 2
    for (int i=0; i < nums.length - 2; i++) {
        // 重复的数字跳过
        if (i > 0 && nums[i] == nums[i-1]) {
            continue;
        }

        //初始化左右两个指针
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {

            if(nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else if(nums[i] + nums[left] + nums[right] > 0) {
                right--;
            } else {
                // 用一个list记录每次循环找到的结果
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);

                // 指针同时移动，寻找其他符合条件结果
                left++;
                right--;
                // 如果下一个相同的话直接跳过，否则会返回重复结果
                while (left < right && nums[right+1] == nums[right]) {
                    right--;
                    continue;
                }
                while (left < right && nums[left-1] == nums[left]) {
                    left++;
                    continue;
                }
            }


        }
    }

    return result;
}
```
