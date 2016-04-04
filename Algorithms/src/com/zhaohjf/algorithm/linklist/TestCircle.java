package com.zhaohjf.algorithm.linklist;

/**
 * 
 * 两个指针h1,h2都从头开始遍历单链表，h1每次向前走1步，h2每次向前走2步，
 * 如果h2碰到了NULL，说明环不存在；如果h2碰到本应在身后的h1说明环存在（也就是发生了套圈）。
 * 如果环不存在，一定是h2先碰到NULL：
 * 如果环存在，h2与h1一定会相遇，
 * 而且相遇的点在环内：h2比h1遍历的速度快，一定不会在开始的那段非环的链表部分相遇，
 * 所以当h1,h2都进入环后，h2每次移动都会使h2与h1之间在前进方向上的差距缩小1，
 * 最后，会使得h1和h2差距减少为0，也即相遇
 * 
 * @author Winnie
 *
 */
public class TestCircle {

	public static Node isExitLoop(SingleList a) {
		Node slow = a.head;
		Node fast = a.head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return slow;
		}
		return null;
	}
	
	/**
	 * 当fast若与slow相遇时，slow肯定没有走遍历完链表，
	 * 而fast已经在环内循环了n圈(1<=n)。假设slow走了s步，
	 * 则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：
	 * 2s = s + nr
	 * s= nr
	 * 
	 * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
	 * a + x = nr
	 * a + x = (n – 1)r +r = (n-1)r + L - a
	 * a = (n-1)r + (L – a – x)
	 * (L – a – x)为相遇点到环入口点的距离，由此可知，
	 * 从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点
	 * 
	 * @param a
	 * @return
	 */
	public static Node entranceNode(SingleList a) {
		Node meetNode = isExitLoop(a);
		if (meetNode == null)
			throw new NullPointerException("链表不存在环");
		Node first = a.head;
		Node second = meetNode;
		while (first != null && second != null) {
			if (first == second)
				return first;
			first = first.next;
			second = second.next;
		}
		return null;
	}
	
	public static int circleLen(SingleList a) {
		Node entraNode = entranceNode(a);
		if (entraNode == null)
			throw new NullPointerException("链表不存在环");
		Node pointer = entraNode;
		int len = 1;
		pointer = pointer.next;
		while (entraNode != pointer) {
			len++;
			pointer = pointer.next;
		}
		return len;
	}
	
	public static void main(String[] args) {
		SingleList list = new SingleList();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		list.addCircle();
		System.out.println(TestCircle.isExitLoop(list)!=null?true:false);
		System.out.println(entranceNode(list).data);
		System.out.println(circleLen(list));
	}
	
	
}












