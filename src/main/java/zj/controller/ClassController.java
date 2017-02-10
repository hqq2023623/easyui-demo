package zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzj on 2017/2/10.
 */
@Controller
@RequestMapping("/class")
public class ClassController
{
    
    @RequestMapping("/index")
    public String index()
    {
        return "ui/class";
    }
    
}
