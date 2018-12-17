package testDemo.ReflectDemo.reflectDemo_06;


import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflectDemo_06.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Constructor<?> cons[] = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            System.out.println("构造方法：  " + cons[i]);
        }
    }
}


interface China {
    public static final String name = "Rollen";
    public static int age = 20;

    public void sayChina();

    public void sayHello(String name, int age);
}


class Person implements China {
    public Person() {

    }

    public Person(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sayChina() {
        System.out.println("hello ,china");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }

    private String sex;
}

/*

获得其他类中的全部构造函数

 */