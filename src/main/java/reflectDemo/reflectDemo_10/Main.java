package reflectDemo.reflectDemo_10;


import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> demo = null;
        Object obj = null;

        demo = Class.forName("reflectDemo_10.Person");
        obj = demo.newInstance();

        Field field = demo.getDeclaredField("sex");
        field.setAccessible(true);
        field.set(obj, "男");
        System.out.println(field.get(obj));
    }
}// end class

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

通过反射操作属性(private 的属性也可以操作)

 */