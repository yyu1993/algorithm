package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

public class Six {
	public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> li = new ArrayList<>();
        li.add(list);
        
        for (int i = 0; i < nums.length; i++) {
			int size = li.size();
			for (int j = 0; j < size; j++) {
				list = li.get(j);
				list.add(nums[i]);
				li.add(list);
			}
			
		}
        return li;
    }
}
