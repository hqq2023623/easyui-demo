package zj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zj.service.UserService;
import zj.ui.DataGrid;
import zj.ui.ResponseResult;

/**
 * Created by lzj on 2017/1/17.
 */
@Controller
@RequestMapping("/user")
public class UserController extends ControllerBase
{
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/list")
    public String list(ModelMap map)
    {
        map.put("", "");
        return "user/list";
    }
    
    @RequestMapping("/list/json")
    @ResponseBody
    public DataGrid userListJson(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
        @RequestParam(value = "rows", required = false, defaultValue = "50") int rows)
    {
        Map<String, Object> param = new HashMap<>(2);
        if (page == 0)
        {
            page = 1;
        }
        param.put("start", rows * (page - 1));
        param.put("max", rows);
        return userService.listAll(param);
    }
    
    @RequestMapping("/combobox")
    @ResponseBody
    public Object combobox()
    {
        return userService.listAll(null).getRows();
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "name") String name)
    {
        if (id <= 0)
        {
            logger.error("id is wrong, id = " + id);
            return ResponseResult.fail("更新失败");
        }
        Map<String, Object> param = new HashMap<>(2);
        param.put("id", id);
        param.put("name", name);
        return userService.update(param);
    }
    
}
