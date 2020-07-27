package chapters8.sections1;

/**
 * 多态：再论向上转型
 */
//自行车
public class Cycle {
    public void who(){
        System.out.println("非机动车");
    }
    public int wheels(){
        return 0;
    }
    public static void ride(Cycle c){
        c.who();
    }

    public static void main(String[] args) {
        Cycle u = new Unicycle();
        Cycle b = new Bicycle();
        Cycle t = new Tricycle();
        ride(u);
        ride(b);
        ride(t);
    }
}
//独轮车
class Unicycle extends Cycle {
    public void who(){
        System.out.println("这是一个轮子的");
    }
    public int wheels(){
        return 1;
    }
}
//自行车
class Bicycle extends Cycle {
    public void who(){
        System.out.println("这是两个轮子的");
    }
    public int wheels(){
        return 2;
    }
}
//三轮车
class Tricycle extends Cycle {
    public void who(){
        System.out.println("这是三个轮子的");
    }
    public int wheels(){
        return 3;
    }
}