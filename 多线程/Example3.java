public class Example3 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();  // ����MyThread��ʵ������    
		Thread thread=new Thread(myThread);  // �����̶߳���
		int i;
		thread.start();                          // �����̣߳�ִ���߳��е�run()����
	for(i=0;i<100;i++) {
			System.out.println("main");			
		 }
	   }
}
class MyThread implements Runnable {
		int j;
	public void run() {          // �̵߳Ĵ���Σ�������start()����ʱ���̴߳Ӵ˴���ʼִ��
		for(j=0;j<50;j++) {
				System.out.println("new");
				
			}
		}
}
