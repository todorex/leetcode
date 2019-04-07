package array;

/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * 41. 找到第一个丢失的正数
 * 给定一个未排序的整数数组，找出最小丢失的正整数
 *
 * @Author rex
 * 2019/4/7
 */
public class Problem41 {
    /**
     * 循环替换
     * 类似：287. Find the Duplicate Number
     * 把数放到正确的位置上
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        // 边界条件
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;


    }
    /**
     * 交换函数
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
