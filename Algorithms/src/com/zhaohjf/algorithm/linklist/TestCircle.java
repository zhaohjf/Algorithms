package com.zhaohjf.algorithm.linklist;

/**
 * 
 * ����ָ��h1,h2����ͷ��ʼ����������h1ÿ����ǰ��1����h2ÿ����ǰ��2����
 * ���h2������NULL��˵���������ڣ����h2������Ӧ������h1˵�������ڣ�Ҳ���Ƿ�������Ȧ����
 * ����������ڣ�һ����h2������NULL��
 * ��������ڣ�h2��h1һ����������
 * ���������ĵ��ڻ��ڣ�h2��h1�������ٶȿ죬һ�������ڿ�ʼ���Ƕηǻ���������������
 * ���Ե�h1,h2�����뻷��h2ÿ���ƶ�����ʹh2��h1֮����ǰ�������ϵĲ����С1��
 * ��󣬻�ʹ��h1��h2������Ϊ0��Ҳ������
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
	 * ��fast����slow����ʱ��slow�϶�û���߱���������
	 * ��fast�Ѿ��ڻ���ѭ����nȦ(1<=n)������slow����s����
	 * ��fast����2s����fast����������s �����ڻ��϶�ת��nȦ�����軷��Ϊr����
	 * 2s = s + nr
	 * s= nr
	 * 
	 * ����������L����ڻ������������Ϊx����㵽����ڵ�ľ���Ϊa��
	 * a + x = nr
	 * a + x = (n �C 1)r +r = (n-1)r + L - a
	 * a = (n-1)r + (L �C a �C x)
	 * (L �C a �C x)Ϊ�����㵽����ڵ�ľ��룬�ɴ˿�֪��
	 * ������ͷ������ڵ����(n-1)ѭ���ڻ�+�����㵽����ڵ�
	 * 
	 * @param a
	 * @return
	 */
	public static Node entranceNode(SingleList a) {
		Node meetNode = isExitLoop(a);
		if (meetNode == null)
			throw new NullPointerException("�������ڻ�");
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
			throw new NullPointerException("�������ڻ�");
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












