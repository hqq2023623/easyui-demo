package zj.test;

import static org.mockito.Matchers.any;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zj.Bootstrap;
import zj.model.Menu;
import zj.service.MenuService;
import zj.service.MockService;

/**
 * Created by lzj on 2017/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Bootstrap.class})
public class TestUserService
{
    
    @Autowired
    private MockService mockService;
    
    @MockBean
    private MenuService menuService;
    
    //Mock数据
    @Before
    public void initMocks()
        throws Exception
    {
        BDDMockito.given(menuService.listAll(any(Map.class))).willAnswer(new Answer<List<Menu>>()
        {
            @Override
            public List<Menu> answer(InvocationOnMock invocationOnMock)
                throws Throwable
            {
                List<Menu> list = new LinkedList<>();
                list.add(new Menu());
                return list;
            }
        });
    }
    
    @Test
    public void test01()
        throws Exception
    {
        mockService.listAll(null);
    }
    
}
