package zj.service.impl;

import org.springframework.stereotype.Service;
import zj.model.User;
import zj.service.UserService;
import zj.ui.DataGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2017/1/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public DataGrid listAll(Map<String, Object> param) {
        List<Object> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId(i);
            u.setName("name" + i);
            users.add(u);
        }
        return new DataGrid(users.size(), users);
    }

}
