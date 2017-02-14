package zj.mock;

import java.util.ArrayList;
import java.util.List;

import zj.model.User;
import zj.ui.DataGrid;

/**
 * 静态数据
 * Created by lzj on 2017/2/10.
 */
public class DataMock
{
    
    public static final DataGrid userList = new DataGrid();
    
    static
    {
        init();
    }
    
    private static void init()
    {
        List<Object> users = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            User u = new User();
            u.setId(i);
            u.setName("name" + i);
            users.add(u);
        }
        userList.setTotal(users.size());
        userList.setRows(users);
    }
    
}
