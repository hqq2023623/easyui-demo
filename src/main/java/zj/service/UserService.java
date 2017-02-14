package zj.service;

import zj.model.User;
import zj.ui.DataGrid;
import zj.ui.ResponseResult;

import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2017/1/18.
 */
public interface UserService
{
    
    /**
     * 分页查询
     */
    DataGrid listAll(Map<String, Object> param);
    
    ResponseResult update(Map<String, Object> param);
    
}
