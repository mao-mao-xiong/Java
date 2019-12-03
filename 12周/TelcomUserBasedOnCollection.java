//集合类模拟电信计费系统，去重和排序
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUserBasedOnCollection {
	private String phoneNumber;
	private String callTo;
	private LinkedList communicationRecords;
	private TreeSet callToNumbersSet;//排序
	private HashSet callToNumbersList;//去重
	public TelcomUserBasedOnCollection(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new LinkedList();
		this.callToNumbersSet = new TreeSet();
		this.callToNumbersList = new HashSet();
	}
	
	//模拟通话记录的生成
	void generateCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//随机生成第i条通话记录			
			//用Calendar获取当前时间
			Calendar cal = Calendar.getInstance();
			//随机减去若干小时（10小时以内）
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//获得对应毫秒
			long timeStart = cal.getTimeInMillis();
			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);			
			//被叫号码
			this.callTo = getCallToPhoneNumber();
			this.callToNumbersList.add(this.callTo);
			this.callToNumbersSet.add(this.callTo);
			//插入通话记录
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo);
		}
	}
	
	//随机生成被叫号码（后四位随机）并返回
	private String getCallToPhoneNumber() {
		return "1380372000" + String.valueOf(new Random().nextInt(10));
	}
	//模拟计费办法，以字符串的形式返回保留4位小数的计费结果
	private String accountFee(long timeStart, long timeEnd) {
		//每分钟收费*元
		double feePerMinute = 0.2;
		//通话分钟数按四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	void printCallToNumber() {
		for(Object callTo:this.callToNumbersList) {
			System.out.println((String)callTo);
		}
		System.out.println("--------List/Set分割线---------");
		for(Object callTo:this.callToNumbersSet) {
			System.out.println((String)callTo);
		}
	}
	//打印通话记录
	void printDetails() {			
		//使用迭代器
		Iterator it = this.communicationRecords.iterator();
		while(it.hasNext()){
			System.out.println("---------通话记录分割线---------");
			String [] recordField = ((String)it.next()).split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			
			//SimpleDateFormat			
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
		}
	}
}
