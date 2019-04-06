package array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * 80. 从一个排序数组中移除重复元素II
 * 给定一个排序数组nums，原地移除重复元素使得数组中的每一个元素最多出现两次，并返回新数组长度
 *
 * @Author rex
 * 2019/4/6
 */
public class Problem80 {
    /**
     * 使用同向双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 边界条件
        if (nums.length == 0) {
            return 0;
        }
        // 使用同向双指针
        // slow之前的元素都是不重复的
        int slow = 0;
        // fast正常遍历
        int fast = 1;
        // 两次的标志位
        int twiceFlag = 1;
        while (fast < nums.length) {
            // 这里还有更简单的方式
            // 直接判断nums[slow - 1] 是否等于 nums[fast]
            if (nums[fast] == nums[slow]) {
                if (twiceFlag < 2) {
                    nums[++slow] = nums[fast];
                }
                twiceFlag++;
            } else {
                twiceFlag = 1;
                nums[++slow] = nums[fast];
            }
            fast++;

        }

        return slow + 1;
    }
}
