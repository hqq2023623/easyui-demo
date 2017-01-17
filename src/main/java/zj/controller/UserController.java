package zj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zj.service.UserService;
import zj.ui.DataGrid;

/**
 * Created by lzj on 2017/1/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.put("", "");
        return "user/list";
    }

    @RequestMapping("/list/json")
    @ResponseBody
    public DataGrid userListJson(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "pageSize", defaultValue = "30") int pageSize) {
        return userService.listAll(null);
    }


}
