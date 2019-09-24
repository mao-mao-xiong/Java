public abstract class INoodles {
    /**
     * 描述每种面条啥样的
     */
    public abstract void desc();
}
public class LzNoodles extends INoodles {
    public void desc() {
        System.out.println("兰州拉面 上海的好贵 家里才5 6块钱一碗");
    }
}
public class GankouNoodles extends INoodles {
    public void desc() {
        System.out.println("还是家里的干扣面好吃 6块一碗");
    }
}
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_GK = 3;//干扣面

    public static INoodles createNoodles(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_GK:
            default:
                return new GankouNoodles();
        }
    }
}
/**
 * 简单工厂模式
 */
 INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
 noodles.desc();