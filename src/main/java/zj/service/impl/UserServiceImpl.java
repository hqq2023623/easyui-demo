package zj.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import zj.mock.DataMock;
import zj.model.User;
import zj.service.UserService;
import zj.ui.DataGrid;
import zj.ui.ResponseResult;

/**
 * Created by lzj on 2017/1/18.
 */
@Service
public class UserServiceImpl implements UserService
{
    
    @Override
    public DataGrid listAll(Map<String, Object> param)
    {
        return DataMock.userList;
    }
    
    @Override
    public ResponseResult save(Map<String, Object> param)
    {
        try
        {
            User u = (User)DataMock.userList.getRows().get(Integer.parseInt(param.get("id") + ""));
            u.setName(param.get("name") + "");
            return ResponseResult.success("update ok");
        }
        catch (NumberFormatException e)
        {
            return ResponseResult.fail("update fail");
        }
        
    }
    
}
