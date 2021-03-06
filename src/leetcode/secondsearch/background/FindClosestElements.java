package secondsearch.background;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

示例 1:

输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
 

示例 2:

输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
 

说明:

k 的值为正数，且总是小于给定排序数组的长度。
数组不为空，且长度不超过 104
数组里的每个元素与 x 的绝对值不超过 104
 

更新(2017/9/19):
这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 * @author ouyangxizhu
 *
 */
public class FindClosestElements {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
		 int left = 0;
		 int right = arr.length-1;
		 List<Integer> list = new ArrayList<Integer>();
		 while (right - left > k-1) {
			 int le = x-arr[left];
			 int ri = arr[right]-x;
			if (le>ri) {
				left++;
			}else {
				right--;
			}
		}
		 for (int i = left; i <= right; i++) {
			list.add(arr[i]);
		}
		 return list;
	        
	 }
	 

}
