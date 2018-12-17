package ApacheLang3Test;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yinliang on 2016/6/22.
 */
public class TestApacheLang3 {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        new TestApacheLang3().log();
    }

    public void log() {
        SearchTermParameter sp = new SearchTermParameter();
        logger.info("查询参数：" + ToStringBuilder.reflectionToString(sp, ToStringStyle.MULTI_LINE_STYLE));
    }
}
