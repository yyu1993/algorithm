package mihayou;

import java.util.PriorityQueue;

import mihayou.Mihayou1.Node;

public class TT {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(5);
		q.add(4);
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
