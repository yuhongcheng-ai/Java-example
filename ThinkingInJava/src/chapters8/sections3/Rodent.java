package chapters8.sections3;
//啮齿动物
public class Rodent {
    public void eat(){
        System.out.println("牙口好吃嘛嘛香！");
    }

    public static void main(String[] args) {
        Rodent[] rs = {new Mouse(),new Gerbil(),new Hamster()};
        for (Rodent r:rs){
            r.eat();
        }
    }
}
//老鼠
class Mouse extends Rodent {
    @Override
    public void eat(){
        System.out.println("爱吃大米！");
    }
}
//鼹鼠
class Gerbil extends Rodent {
    @Override
    public void eat(){
        System.out.println("爱吃虫子！");
    }
}
//仓鼠
class Hamster extends Rodent {
    @Override
    public void eat(){
        System.out.println("爱吃小麦！");
    }
}