package zj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zj.model.Menu;
import zj.service.MenuService;
import zj.service.UserService;
import zj.ui.DataGrid;

import java.util.List;

/**
 * Created by lzj on 2017/1/17.
 */
@RestController
@RequestMapping("/common")
public class CommonController
{
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/menus")
    public List<Menu> menus()
    {
        return menuService.listAll(null);
    }
    
}
