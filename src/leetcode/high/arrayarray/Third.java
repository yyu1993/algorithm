package high.arrayarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author ouyangxizhu
 *
 */
public class Third {
	/**
	 * 显然如果暴力解题，复杂度会到达恐怖的O(n^4)，显然是不合要求的。

然后又想了下，分为两组的话，可以将复杂度降到O(n^2)。

本来觉得这个复杂度还不是最优的，但实在想不到如何再优化，结果网上搜一下，结果都是这个O(n^2)的算法。

思路就是，HashMap存前两个数组能组成的数字及其组成的次数，再遍历后两个数组，查看HashMap中是否存在两数和的相反数，如果存在，则记录出现次数，累加即为结果。
--------------------- 
作者：whd_Alive 
来源：CSDN 
原文：https://blog.csdn.net/whdAlive/article/details/80459522 
版权声明：本文为博主原创文章，转载请附上博文链接！
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
			}
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				count += map.getOrDefault(-C[i]-D[j], 0);
 			}
		}
        return count;
    }

}
