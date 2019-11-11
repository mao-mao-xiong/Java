package zuoye;
import java.util.Random;
public class Storage {
	private String[] cells=new String[10];
	private int inPos,outPos;
	private int count;
	private String name;
	public synchronized void put() {
		// TODO Auto-generated method stub
		try{
			while(count==cells.length){
				this.wait();
			}
			Thread.sleep(new Random().nextInt(100));
			name=String.valueOf(new Random().nextInt(100));
			cells[inPos]=name;
			System.out.println("cells["+inPos+"]用户登录---"+cells[inPos]);
			inPos++;
			if(inPos==cells.length)
				inPos=0;
			count++;
			System.out.println("当前在线人数："+count);
			this.notify();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	public synchronized void get(){
		try{
			while(count==0){
				this.wait();
			}
			Thread.sleep(new Random().nextInt(100));
			String data=cells[outPos];
			System.out.println("cells["+outPos+"]用户注册"+data);
			cells[outPos]=null;
			outPos++;
			if(outPos==cells.length)
				outPos=0;
			count--;
			System.out.println("当前在线人数："+count);
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}