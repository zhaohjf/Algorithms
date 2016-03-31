package zhaohjf.yonyou.com.thread;
/**
 * synchronized(object)
 *
 * {　     
 *
 *　}
 *
 *　表示线程在执行的时候会将object对象上锁。（注意这个对象可以是任意类的对象，也可以使用this关键字）。
 *
 *　这样就可以自行规定上锁对象。　
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






