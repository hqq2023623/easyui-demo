package zj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import zj.model.Menu;
import zj.service.MenuService;

/**
 * Created by lzj on 2017/1/18.
 */
@Service
public class MenuServiceImpl implements MenuService
{
    
    @Override
    public List<Menu> listAll(Map<String, Object> param)
    {
        List<Menu> list = new ArrayList<>();
        addUser(list);
        addDataGrid(list);
        return list;
    }
    
    //user
    private void addUser(List<Menu> list)
    {
        Menu m = new Menu();
        m.setId(1);
        m.setText("user");
        m.toggleState();
        
        Menu child = new Menu();
        child.setId(2);
        child.setText("list");
        child.getAttributes().put("url", "/user/list");
        m.getChildren().add(child);
        list.add(m);
    }
    
    //datagrid
    private void addDataGrid(List<Menu> list)
    {
        Menu m = new Menu();
        m.setId(2);
        m.setText("datagrid");
        m.toggleState();
        
        Menu child = new Menu();
        child.setId(3);
        child.setText("datagrid");
        child.getAttributes().put("url", "/datagrid/editable");
        m.getChildren().add(child);
        list.add(m);
    }
    
}
