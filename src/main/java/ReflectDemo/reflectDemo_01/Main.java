package ReflectDemo.reflectDemo_01;


class Demo {
    //other codes...
}

public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getClass().getName());
    }
}

/*
通过一个对象获得完整的包名和类名
 */