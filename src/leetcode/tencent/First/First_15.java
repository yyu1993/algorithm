package Tencent.First;

import java.util.Arrays;
/**
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�

����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��

ʾ�� 1:

����: [1,2,3,1]
���: true
ʾ�� 2:

����: [1,2,3,4]
���: false
ʾ�� 3:

����: [1,1,1,3,3,4,3,2,4,2]
���: true
 * @author ouyangxizhu
 *
 */
public class First_15 {
	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
			if (nums[i]==nums[i+1]) {
				return true;
			}
		}
        return false;
    }

}