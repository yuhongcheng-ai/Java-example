package chapters8.sections3;

public class Human {
    public void describe(){
        explain();
    }
    public void explain(){
        System.out.println("一个鼻子两个眼睛");
    }
    public static void main(String[] args) {
        Human m = new Man();
        m.describe();
    }
}
class Man extends Human{
    public void explain(){
        System.out.println("长胡子");
    }
}