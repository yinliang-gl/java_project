package TestDemo.ApacheCommonPool;

import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.junit.Test;

/**
 * Created by yinliang on 2016/6/11.
 */
public class CommonPoolTest {

    @Test
    public void test() {
        System.out.println("TTT");
    }

    @Test
    public void test1() throws Exception {
        GenericKeyedObjectPool pool = new GenericKeyedObjectPool(new BaseKeyedPoolableObjectFactory() {
            @Override
            public Object makeObject(Object o) throws Exception {
                return o;
            }
        });


        pool.addObject("a");
        pool.addObject("a");
        pool.addObject("b");
        pool.addObject("x");

        //清除最早的对象
//        pool.clearOldest();

        //获取并输出对象
        System.out.println(pool.borrowObject("a"));
        System.out.println(pool.borrowObject("b"));
        System.out.println(pool.borrowObject("c"));
        System.out.println(pool.borrowObject("c"));
        System.out.println(pool.borrowObject("a"));

        //输出池状态
        System.out.println(pool.getMaxIdle());
        System.out.println(pool.getMaxActive());
    }

}
