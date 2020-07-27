package chapters8.sections2;

import java.util.Random;

/**
 * 使用@Override注解主要有两个好处：
 * 1）检查是否正确的重写父类方法（方法签名）
 * 2）明显的提示看代码的人，这是重写的方法
 */

//几何图形
public class Shape {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    //绘制
    public void draw(){}
    //擦掉
    public void erase(){}

    public void newM(){
        System.out.println("Shape");
    }

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i=0;i<s.length;i++){
            s[i] = gen.next();
        }
        for (Shape shape:s){
            shape.draw();
            shape.newM();
        }
    }
}
//圆形
class Circle extends Shape {
    @Override
    public void draw(){
        System.out.println("画个圆");
    }
    @Override
    public void erase(){
        System.out.println("擦掉圆");
    }
    @Override
    public void newM(){
        System.out.println("Circle");
    }
}
//正方形
class Square extends Shape {
    @Override
    public void draw(){
        System.out.println("画个正方形");
    }
    @Override
    public void erase(){
        System.out.println("擦掉正方形");
    }
}
//三角形
class Triangle extends Shape {
    @Override
    public void draw(){
        System.out.println("画个三角形");
    }
    @Override
    public void erase(){
        System.out.println("擦掉三角形");
    }
}
//图形工厂
class RandomShapeGenerator{
    private Random rand = new Random();
    public Shape next(){
        switch (rand.nextInt(3)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
        }
    }
}