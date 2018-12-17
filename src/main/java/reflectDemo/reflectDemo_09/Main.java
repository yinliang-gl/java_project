package reflectDemo.reflectDemo_09;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> demo = null;
        Object obj = null;
        try {
            demo = Class.forName("reflectDemo_09.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            obj = demo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setter(obj, "Sex", "男", String.class);
        getter(obj, "Sex");
    }

    /**
     * @param obj 操作的对象
     * @param att 操作的属性
     */
    public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param obj   操作的对象
     * @param att   操作的属性
     * @param value 设置的值
     * @param type  参数的属性
     */
    public static void setter(Object obj, String att, Object value,
                              Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

调用其他类的set和get方法

 */