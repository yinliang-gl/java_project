package reflectDemo.reflectDemo_04;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

class Person {

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "[" + this.name + "  " + this.age + "]";
    }

    private String name;
    private int age;
}

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflectDemo_04.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person per1 = null;
        Person per2 = null;
        Person per3 = null;
        Person per4 = null;
        //取得全部的构造函数
        Constructor<?> cons[] = demo.getConstructors();


        for (int i = 0; i < cons.length; i++) {
            Type types[] = cons[i].getGenericParameterTypes();
            switch (types.length) {
                case 0:
                    per1 = (Person) cons[i].newInstance();
                    break;
                case 1:
                    if ("int".equals(types[0].toString())) {
                        per3 = (Person) cons[i].newInstance(20);
                    } else {
                        per2 = (Person) cons[i].newInstance("Rollen");
                    }
                    break;
                case 2:
                    per4 = (Person) cons[i].newInstance("Rollen", 20);
                    break;
            }
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);
    }
}

/*
通过Class调用其他类中的构造函数 （也可以通过这种方式通过Class创建其他类的对象）
 */