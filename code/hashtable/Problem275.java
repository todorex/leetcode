package hashtable;

/**
 * 274. H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * 274. H-级
 * 给定一个研究者引用数量数组，写一个函数去计算研究者的H-级
 * 根据维基百科说明：
 * "H-级的科学家，他至少有h篇论文至少h次被引用，其他N-h论文的引用不超过h次"
 *
 * @Author rex
 * 2019/4/10
 */
public class Problem275 {
    /**
     * 利用hashmap
     * 统计次数 =》hashmap
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        // 边界条件
        if (citations.length == 0) {
            return 0;
        }
        // bucket
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int i : citations) {
            if (i >= n) {
                buckets[n]++;
            } else {
                buckets[i]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
