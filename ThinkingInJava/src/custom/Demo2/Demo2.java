package custom.Demo2;

/*
 * 协变返回类型：ManDemo重写了接口IDemo2的demof()方法，返回类型可以是接口IDemo2的demof()方法返回类型的子类；
 * 优点：可以赋给基类引用，也可以给更具体的子类引用；
 */
import chapters8.sections3.Man;
import chapters8.sections3.Woman;

public class Demo2 {
    public static void main(String[] args) {
        Man man = new ManDemo().demof();
        Woman woman = new WomanDemo().demof();
        man.explain();
        woman.explain();
    }
}
class ManDemo implements IDemo2{
    @Override
    public Man demof() {
        return new Man();
    }
}
class WomanDemo implements IDemo2{
    @Override
    public Woman demof() {
        return new Woman();
    }
}