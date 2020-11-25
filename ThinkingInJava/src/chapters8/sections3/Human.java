package chapters8.sections3;

public class Human {
    public void describe(){
        explain();
    }
    public void explain(){
        System.out.println("一个鼻子两个眼睛");
    }
    public static void main(String[] args) {
        new Human().describe();
        new Man().describe();
        new Woman().describe();
    }
}


