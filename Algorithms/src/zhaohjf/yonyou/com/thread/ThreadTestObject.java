package zhaohjf.yonyou.com.thread;
/**
 * synchronized(object)
 *
 * {��     
 *
 *��}
 *
 *����ʾ�߳���ִ�е�ʱ��Ὣobject������������ע��������������������Ķ���Ҳ����ʹ��this�ؼ��֣���
 *
 *�������Ϳ������й涨�������󡣡�
 * @author Administrator
 *
 */
public class ThreadTestObject {

	public static void main(String[] args) {
		Access object = new Access();
		Thread t1 = new Thread(new ThreadA(object));
		Thread t2 = new Thread(new ThreadB(object));
		
		t1.start();
		t2.start();
	}
}

class Access {
	public void A() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}

	public void B() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
		}
	}
}

class ThreadA implements Runnable {

	private Access object;
	
	public ThreadA(Access object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (object) {
			object.A();
		}
	}
	
}

class ThreadB implements Runnable {

	private Access object;
	
	public ThreadB(Access object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (object) {
			object.B();
		}
	}
	
}






