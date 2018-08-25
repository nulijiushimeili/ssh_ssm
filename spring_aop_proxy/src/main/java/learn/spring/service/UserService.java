package learn.spring.service;

import learn.spring.dao.IUserDao;
import learn.spring.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zmzy on 2017/2/16.
 */
@Service()
public class UserService implements IUserService {
    private IUserDao userDao;
    @Override
    public void save(User user) {
        userDao.add(user);
    }

    @Resource(name="userDao")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
