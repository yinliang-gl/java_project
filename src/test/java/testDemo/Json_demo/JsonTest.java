package testDemo.Json_demo;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinliang on 2016/6/24.
 */
public class JsonTest {

    @Test
    public void test1() {
        // write your code here
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        try {
            // 尝试从JSON中读取对象
            User user = mapper.readValue(new File("user.json"), User.class);
            System.out.println(user);
            user.setGender(User.Gender.FEMALE);
            mapper.writeValue(new File("user-modified.json"), user);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        // write your code here
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        try {
            // 读取JSON数据
            Map<String, Object> userData = mapper.readValue(new File("user.json"), Map.class);
            System.out.println(userData);
            // 写入JSON数据
            userData = new HashMap<String, Object>();
            Map<String, String> nameStruct = new HashMap<String, String>();
            nameStruct.put("first", "Joe");
            nameStruct.put("last", "Hankcs");
            userData.put("name", nameStruct);
            userData.put("gender", "MALE");
            userData.put("verified", Boolean.FALSE);
            userData.put("userImage", "Rm9vYmFyIQ==");
            mapper.writeValue(new File("user-modified.json"), userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
