package com.zhaohjf.algorithm.linklist;

public class SingleList {

	private int size;
	public Node head;
	
	private void init() {
		this.size = 0;
		this.head = new Node();
	}
	
	public SingleList() {
		init();
	}
	
	public boolean contains(Object value) {
		boolean flag = false;
		Node p = head.next;
		while (p != null) {
			if (value.equals(p.data)) {
				flag = true;
				break;
			} else {
				p = p.next;
			}
		}
		return flag;
	}
	
	public boolean add(Object value) {
		if (contains(value)) {
			return false;
		}else {
			Node p = new Node(value);
			p.next = head.next;
			head.next = p;
			size++;
		}
		return true;
	}
	
	public void  addCircle() {
		Node p = head.next;
		for (int i = 0; i < size; i++) {
			if (p.next == null) {
				p.next = head;
			}
			p = p.next;
		}
	}
	
}






