package src.com.design.pattern.No03FactoryMethod.product;

/**
 * Product(Document)
 * 팩토리 메서드가 생성하는 객체의 인터페이스를 정의합니다.
 */
public abstract class AnimalRobot {
    protected String type;
    protected String cry;
    protected String texture;

    public void makeRobot() {
        System.out.println("make robot type is " + type);
    }

    public void crying() {
        System.out.println(texture + " " + cry);
    }
}
