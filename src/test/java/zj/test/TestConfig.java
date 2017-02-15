package zj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zj.Bootstrap;
import zj.config.DbConfig;

/**
 * Created by lzj on 2017/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class TestConfig
{
    
    @Autowired
    private DbConfig dbConfig;
    
    /**
     *
     */
    @Test
    public void test01()
        throws Exception
    {
        System.out.println(dbConfig.getUsername());
        
    }
    
}
