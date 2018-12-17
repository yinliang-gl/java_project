package reflectDemo.reflectDemo_14;

import java.io.*;
import java.util.Properties;

interface fruit {
    public abstract void eat();
}

class Apple implements fruit {
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

//操作属性文件类
class Init {
    public static Properties getPro() throws FileNotFoundException, IOException {
        Properties pro = new Properties();
        File f = new File("fruit.properties");
        if (f.exists()) {
            pro.load(new FileInputStream(f));
        } else {
            pro.setProperty("apple", "reflectDemo_14.Apple");
            pro.setProperty("orange", "reflectDemo_14.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}

class Factory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

public class Main {
    public static void main(String[] a) throws IOException {
        Properties pro = Init.getPro();
        fruit f = Factory.getInstance(pro.getProperty("apple"));
        if (f != null) {
            f.eat();
        }
    }
}

/*

将反射用于工厂模式

 */