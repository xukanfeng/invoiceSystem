package common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xu_kanfeng on 16/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring/mvc-dispatcher-servlet.xml",
        "classpath*:spring/spring-mybatis.xml",
        "classpath*:spring/spring-context.xml"
})
public abstract class AbstractTest {
}
