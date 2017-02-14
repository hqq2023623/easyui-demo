package zj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zj.service.MenuService;
import zj.service.MockService;
import zj.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2017/2/14.
 */
@Service
public class MockServiceImpl implements MockService
{
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MenuService menuService;
    
    @Override
    public List<String> listAll(Map<String, Object> param)
    {
        System.out.println(menuService.listAll(null).size());
        return null;
    }
    
}
