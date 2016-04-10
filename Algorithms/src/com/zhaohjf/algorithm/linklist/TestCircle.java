package com.zhaohjf.algorithm.linklist;

/**
 * ����ָ��h1,h2����ͷ��ʼ����������h1ÿ����ǰ��1����h2ÿ����ǰ��2����
 * ���h2������NULL��˵���������ڣ����h2������Ӧ������h1˵�������ڣ�Ҳ���Ƿ�������Ȧ����
 * ����������ڣ�һ����h2������NULL��
 * ��������ڣ�h2��h1һ����������
 * ���������ĵ��ڻ��ڣ�h2��h1�������ٶȿ죬һ�������ڿ�ʼ���Ƕηǻ���������������
 * ���Ե�h1,h2�����뻷��h2ÿ���ƶ�����ʹh2��h1֮����ǰ�������ϵĲ����С1��
 * ��󣬻�ʹ��h1��h2������Ϊ0��Ҳ������
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












