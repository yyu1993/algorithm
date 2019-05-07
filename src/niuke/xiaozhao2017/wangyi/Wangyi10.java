package niuke.xiaozhao2017.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  题目描述
一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
输入描述:
第一行输入一个正整数n(n ≤ 1000)
第二行为n个数正整数xi(xi ≤ 1000)
输出描述:
输出可以产生的幸运的袋子数
示例1
输入
复制
3
1 1 1
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class Wangyi10 {
	/**
	 *
题目可以转化成求符合条件的集合真子集个数。每次从全集中选择若干元素（小球）组成子集（袋子）。
集合子集个数为2^n个，使用dfs必然超时。且此题有重复元素，那么就搜索剪枝。
对于任意两个正整数a,b如果满足 a+b>a*b，则必有一个数为1.可用数论证明：
设a=1+x,b=1+y，则1+x+1+y>(1+x)*(1+y)，--->  1>x*y，则x，y必有一个为0，即a,b有一个为1.
推广到任意k个正整数，假设a1,a2,...ak，如果不满足给定条件，即和sum小于等于积pi，
如果此时再选择一个数b,能使其满足sum+b > pi*b，则，b必然为1，且为必要非充分条件。
反之，如果选择的b>1，则sum+b <=pi*b，即a1,a2,...,ak,b不满足给定条件。（搜索剪枝的重要依据）

因此，将球按标号升序排序。每次从小到大选择，当选择到a1,a2,...,ak-1时满足给定条件，而再增加选择ak时不满足条件（ak必然大于等于max(a1,a2,...,ak-1)），继续向后选择更大的数，必然无法满足！因此，可以进行剪枝。
如果有多个1，即当k=1时，sum(1)>pi(1)不满足，但下一个元素仍为1，则可以满足1+1>1*1，所以要判断当前ak是否等于1.
此外，对于重复数字，要去重复。
	 * @param args
	 */
	static int[] a = new int [1001];
 	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		
		for (i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a, 0, n);
		
		System.out.println(find(a, 0, 0, 1));
	}
	private static int find(int[] arr, Integer index, long sum, long multi) {
		int count = 0;
		for (int i = index; i < arr.length; i++) {
			sum += arr[i];
			multi *= arr[i];
			if (sum > multi) {
				count += 1 + find(arr, index + 1, sum, multi);
			}else if (arr[i] == 1 ) {
				count += find(arr, index + 1, sum, multi);
			}else {
				break;
			}
			sum -= arr[i];
			multi /= arr[i];
			while (i < arr.length - 1 && arr[i + 1] == arr[i]) {
				i ++;
			}
		}
		
		return count;
	}

	

	
	
}
