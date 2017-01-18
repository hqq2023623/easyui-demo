package zj.service;

import zj.model.Menu;
import zj.ui.DataGrid;

import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2017/1/18.
 */
public interface MenuService
{
    
    List<Menu> listAll(Map<String, Object> param);
    
}
