package mobileshop.service;

import mobileshop.entity.UserEntity;

public interface UserService {

    /**
     * 保存用户信息
     * @param ue
     * @return
     */
    boolean save(UserEntity ue);

    /**
     * 存在 username 或 email 则返回 true
     * @param username
     * @param email
     * @return
     */
    boolean existUserNameOrEmail(String username,String email);
}

