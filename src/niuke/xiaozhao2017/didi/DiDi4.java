package niuke.xiaozhao2017.didi;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
输入描述:
输入为一行，n(1 ≤ n ≤ 1000)
输出描述:
输出一个整数,即题目所求
示例1
输入
复制
10
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class DiDi4 {//超时
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				int m = i;
				while (m % 5 == 0) {
					sum ++;
					m /= 5;
				}
			}
			
		
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
