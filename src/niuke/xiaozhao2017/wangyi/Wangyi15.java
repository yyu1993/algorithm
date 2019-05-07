package niuke.xiaozhao2017.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * 题目描述
考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
"car" < "carriage" < "cats" < "doggies < "koala"
2.根据字符串的长度排序。例如：
"car" < "cats" < "koala" < "doggies" < "carriage"
考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
输入描述:
输入第一行为字符串个数n(n ≤ 100)
接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
输出描述:
如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",

如果根据长度排列而不是字典序排列输出"lengths",

如果两种方式都符合输出"both"，否则输出"none"
示例1
输入
复制
3
a
aa
bbb
输出
复制
both
 * @author changzhen.zhang
 *
 */
public class Wangyi15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] a = new String[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLine();
		}
		String[] s1 = Arrays.copyOf(a, a.length);
		String[] s2 = Arrays.copyOf(a, a.length);
		Arrays.sort(s1, (o1, o2) -> o1.compareTo(o2));
		Arrays.sort(s2, (o1, o2) -> o1.length() - o2.length());
		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 0; i < s1.length; i++) {
			if (a[i] != s1[i]) {
				flag1 = false;
				break;
			}
		}
		for (int i = 0; i < s2.length; i++) {
			if (a[i] != s2[i]) {
				flag2 = false;
				break;
			}
		}
		String res = "";
		if (flag1 && flag2) {
			res = "both";
		}else if (flag2) {
			res = "lengths";
		}else if (flag1) {
			res = "lexicographically";
		}else {
			res = "none";
		}
		System.out.println(res);
		
	}
	

}
