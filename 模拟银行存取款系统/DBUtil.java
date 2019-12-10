import java.util.HashMap;
//模拟银行系统中的账户信息，相当于数据库的功能
public class DBUtil {
    private static DBUtil instance = null;
    private HashMap<String,User> users = new HashMap<String,User>();

    private DBUtil() {
        //--------刘备-----------------
        User u1 = new User();
        u1.setCardId("1001");
        u1.setCardPwd("123456");
        u1.setUserName("刘备");
        u1.setCall("13281525712");
        u1.setAccount("1000");
        users.put(u1.getCardId(),u1);
        //--------关羽------------------
        User u2 = new User();
        u2.setCardId("1002");
        u2.setCardPwd("234567");
        u2.setUserName("关羽");
        u2.setCall("13041018869");
        u2.setAccount("1000");
        users.put(u2.getCardId(),u2);
        //--------张飞-----------------
        User u3 = new User();
        u3.setCardId("1003");
        u3.setCardPwd("345678");
        u3.setUserName("张飞");
        u3.setCall("13181527253");
        u3.setAccount("1000");
        users.put(u3.getCardId(),u3);
    }
    //懒汉式单例模式
    public static DBUtil getInstance() {
        if (instance == null) {
            synchronized (DBUtil.class) {
                if (instance == null) {
                    instance = new DBUtil();
                }
            }
        }
        return instance;
    }
    //根据银行卡号获取对应单个账户的信息
    public User getUser(String cardId) {
        User user = (User) users.get(cardId);
        return user;
    }
    //获取所有账户的信息
    public HashMap<String,User> getUsers() {
        return users;
    }
}