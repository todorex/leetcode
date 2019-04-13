package array;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * 11. 包含最多水的容器
 * 给定一个非负整数数组，每个数代表了一个点坐标(i, ai)
 * 我们可以找两个点(i,ai)和(i,0)画出 n 条垂直的线
 * 找出一条水平线，使得容器的水最多
 *
 * @Author rex
 * 2019/4/13
 */
public class Problem11 {
    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ret = 0;
        // 双指针
        int start = 0, end = height.length - 1;
        while (start < end) {
            int minHeight = Math.min(height[start], height[end]);
            ret = Math.max(ret, (end - start) * minHeight);
            if (height[start] == minHeight) {
                start++;
            } else {
                end--;
            }
        }
        return ret;
    }
}
