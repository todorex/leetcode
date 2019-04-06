package array;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * 26. 从一个排序数组中移除重复元素
 * 给定一个排序数组nums，原地移除重复元素使得数组中的每一个元素都只出现一次，并返回新数组长度
 *
 * @Author rex
 * 2019/4/6
 */
public class Problem26 {
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
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // 这里太死板
                // 可以直接用 nums[++slow] = nums[fast]
                swap(nums, ++slow, fast);
            }
            fast++;
        }

        return slow + 1;
    }

    /**
     * 数组元素交换
     * @param array
     * @param index1
     * @param index2
     */
    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
