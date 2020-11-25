package custom.Demo1;
/*
 *接口中可以有静态方法，main方法也是静态方法，可以直接运行；
 */
public interface Demo1 {
    String s = "abc";// s自动就是final 和 static 的，因为它是在接口中定义的。

    public static void main(String[] args) {
        System.out.println(s);
    }
}
