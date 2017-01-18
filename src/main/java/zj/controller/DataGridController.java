package zj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zj.service.UserService;

/**
 * Created by lzj on 2017/1/18.
 */
@Controller
@RequestMapping("/datagrid")
public class DataGridController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping("/editable")
    public String editable()
    {
        return "datagrid/editable";
    }
    
}
