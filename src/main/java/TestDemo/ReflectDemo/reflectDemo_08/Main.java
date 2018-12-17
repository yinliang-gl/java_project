package TestDemo.ReflectDemo.reflectDemo_08;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflectDemo_08.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //调用Person类中的sayChina方法
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());

            //调用Person的sayHello方法
            method = demo.getMethod("sayHello", String.class, int.class);
            method.invoke(demo.newInstance(), "Rollen", 20);

        } catch (Exception e) {
            e.printStackTrace();
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

通过反射调用其他类中的方法：

 */