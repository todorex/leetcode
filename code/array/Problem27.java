package array;

/**
 * 27. Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * 27. 移除元素
 * 给定一个数组和一个值value，原地移除数组中所有的value，并返回新的长度
 *
 * @Author rex
 * 2019/4/6
 */
public class Problem27 {

    /**
     * 使用首尾双指针逼近
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // 边界条件
        if (nums.length == 0) {
            return 0;
        }
        // 定义两个指针，把每一个等于val的值都放到最后
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            // 注意边界条件： start <= end
            while(nums[start] == val && start <= end) {
                swap(nums, start, end);
                end--;
            }
            start++;
        }
        return end + 1;
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
