package ApacheCommonPool;

import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;
import org.apache.commons.pool.KeyedObjectPool;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.StackKeyedObjectPoolFactory;

/**
 * Created by yinliang on 2016/6/11.
 */

class Person {
    String id;
    String name;

    public Person() {

    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:" + id + "---name:" + name;
    }
}

class KeyedPoolableObjectFactorySample extends BaseKeyedPoolableObjectFactory {


    @Override
    public Object makeObject(Object clsName) throws Exception {
        if (clsName == null || !(clsName instanceof String) || "".equals(clsName)) {
            throw new RuntimeException("类名为空！");
        }

        System.out.println("创建一个新对象：" + clsName);

        Class cls = Class.forName((String) clsName);
        Object obj = cls.newInstance();
        return obj;
    }

    @Override
    public void activateObject(Object key, Object obj) throws Exception {
        // TODO Auto-generated method stub
        super.activateObject(key, obj);
        System.out.println("激活对象");
    }

    @Override
    public void destroyObject(Object key, Object obj) throws Exception {
        // TODO Auto-generated method stub
        super.destroyObject(key, obj);
        System.out.println("销毁对象");
    }

    @Override
    public void passivateObject(Object key, Object obj) throws Exception {
        // TODO Auto-generated method stub
        super.passivateObject(key, obj);
        System.out.println("挂起对象");
    }

    @Override
    public boolean validateObject(Object key, Object obj) {
        // TODO Auto-generated method stub
        System.out.println("验证对象");
        return super.validateObject(key, obj);

    }
}

public class KeyedObjectPoolSample {
    public static void main(String[] args) {

        Object obj = null;
        KeyedPoolableObjectFactory factory = new KeyedPoolableObjectFactorySample();
        KeyedObjectPoolFactory poolFactory = new StackKeyedObjectPoolFactory(factory);
        KeyedObjectPool pool = poolFactory.createPool();


        String key = null;

        key = "java.lang.String";

        try {
//            obj = pool.borrowObject(key);
//            obj = "obj1";
//            // pool.returnObject(key, obj);
//            obj = pool.borrowObject(key);
//            pool.returnObject(key, obj);
//            obj = pool.borrowObject(key);
//            System.out.println(obj);


            System.out.println("============看另一个对象Person=============");

            key = "Person";
            Person person1 = (Person) pool.borrowObject(key);


            person1.setId("1");
            person1.setName("素还真");
            System.out.println(person1);
            pool.returnObject(key, person1);
            System.out.println(person1);

            Person person2 = (Person) pool.borrowObject(key);
            person2.setId("2");
            person2.setName("青阳子");

            Person person3 = (Person) pool.borrowObject(key);
            person3.setId("3");
            person3.setName("一页书");

            Person person4 = (Person) pool.borrowObject(key);
            person4.setId("4");
            person4.setName("业途灵");

            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person3);
            System.out.println(person4);


            pool.returnObject(key, person3);
            Person person5 = (Person) pool.borrowObject(key);
            System.out.println(person5);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
