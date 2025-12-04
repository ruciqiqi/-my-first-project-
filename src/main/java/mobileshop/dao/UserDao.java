package mobileshop.dao;

import mobileshop.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int save(UserEntity ue);

    boolean existUserNameOrEmail(@Param("username") String username, @Param("email") String email);
}
