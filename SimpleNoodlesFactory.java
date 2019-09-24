public abstract class INoodles {
    /**
     * ����ÿ������ɶ����
     */
    public abstract void desc();
}
public class LzNoodles extends INoodles {
    public void desc() {
        System.out.println("�������� �Ϻ��ĺù� �����5 6��Ǯһ��");
    }
}
public class GankouNoodles extends INoodles {
    public void desc() {
        System.out.println("���Ǽ���ĸɿ���ó� 6��һ��");
    }
}
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//��������
    public static final int TYPE_PM = 2;//����
    public static final int TYPE_GK = 3;//�ɿ���

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
 * �򵥹���ģʽ
 */
 INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
 noodles.desc();