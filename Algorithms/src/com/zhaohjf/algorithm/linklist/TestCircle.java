package com.zhaohjf.algorithm.linklist;

/**
 * 两个指针h1,h2都从头开始遍历单链表，h1每次向前走1步，h2每次向前走2步，
 * 如果h2碰到了NULL，说明环不存在；如果h2碰到本应在身后的h1说明环存在（也就是发生了套圈）。
 * 如果环不存在，一定是h2先碰到NULL：
 * 如果环存在，h2与h1一定会相遇，
 * 而且相遇的点在环内：h2比h1遍历的速度快，一定不会在开始的那段非环的链表部分相遇，
 * 所以当h1,h2都进入环后，h2每次移动都会使h2与h1之间在前进方向上的差距缩小1，
 * 最后，会使得h1和h2差距减少为0，也即相遇
 * @author Winnie
 *
 */
public class TestCircle {

	public static boolean isExitLoop(SingleList a) {
		Node slow = a.head;
		Node fast = a.head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SingleList list = new SingleList();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		list.addCircle();
		System.out.println(TestCircle.isExitLoop(list));
	}
	
	
}












