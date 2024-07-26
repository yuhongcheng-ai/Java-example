package custom.demo4;

/**
 * 无限递归导致栈溢出示例
 */
public class Demo4 {

    public static void funA(){
        funA();
    }
    public static void main(String[] args) {
        System.out.println(2018592376408L+10L*365*24*60*60*1000);
        //2018592376408
        //2018592387712
        //1827387392
        //86400000
    }
}
