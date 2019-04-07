package array;

/**
 * 189. Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * 189. 旋转数组
 * 给定一个数组，向右旋转k步，k是非负数
 *
 * @Author rex
 * 2019/4/7
 */
public class Problem189 {
    /**
     * 辅助空间
     * 旋转核心 res[(i + k) % length] = nums[i];
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        // 边界条件
        if (nums.length == 0) {
            return;
        }
        int length = nums.length;
        // 新建一个数组, 额外空间
        int[] res = new int[length];
        k  = k % length;
        for (int i = 0; i < length; i++) {
            res[(i + k) % length] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = res[i];
        }

    }

    /**
     * 循环替换
     * 证明日后再说😭
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        // 边界条件
        if (nums.length == 0) {
            return;
        }
        int length = nums.length;
        k = k % length;
        // 需要替换的次数 length - 1
        int count = 0;
        for (int start = 0; count < length; start++) {
            int current = start;
            int prev = nums[start];
            int next;
            int temp;
            do {
                next = (current + k) % length;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count ++;
                // 终止条件：回到原点
            } while (current != start);
        }
    }

    /**
     * 利用逆转
     * 自证，哈哈
     * 1. 整体逆转
     * 2. 部分逆转
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        // 边界条件
        if (nums.length == 0) {
            return;
        }
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    /**
     * 数组逆转
     * @param nums
     */
    public void reverse(int[] nums, int start, int end) {
        // 边界条件
        if (nums.length <= 1) {
            return;
        }
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
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
