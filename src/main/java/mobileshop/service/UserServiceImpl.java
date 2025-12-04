package mobileshop.service;

import mobileshop.dao.UserDao;
import mobileshop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(UserEntity ue) {
        return userDao.save(ue)>0;
    }

    @Override
    public boolean existUserNameOrEmail(String username,String email){
        return userDao.existUserNameOrEmail(username,email);
    }

}

