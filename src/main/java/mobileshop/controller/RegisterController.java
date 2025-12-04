package mobileshop.controller;

import mobileshop.entity.UserEntity;
import mobileshop.service.UserService;
import mobileshop.vo.ResMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/signup")
    public String signUp(ModelMap map, String username, String password, String email){
        String result="msg";
        UserEntity ue=new UserEntity();
        ue.setPassword(password);
        ue.setUsername(username);
        ue.setEmail(email);
        if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            if((!userService.existUserNameOrEmail(username,email))) {
                if (userService.save(ue)) {
                    map.put("msg", "注册成功");
                } else {
                    map.put("msg", "注册失败");
                }
            }else{
                map.put("msg", "用户名或Email已存在");
            }
        }else{
            map.put("msg", "用户名，密码，邮箱均不能为空");
        }
        return result;
    }

    @RequestMapping(value = "/register2")
    public String register2() {
        return "register2";
    }

    @RequestMapping(value = "/signup2")
    @ResponseBody
    public ResMsg signup2(String username,String password,String email){
        ResMsg resmsg=new ResMsg();
        //请完善注册功能，业务逻辑和上面signup方法保持一致
        UserEntity ue=new UserEntity();
        ue.setPassword(password);
        ue.setUsername(username);
        ue.setEmail(email);
        if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            if((!userService.existUserNameOrEmail(username,email))) {
                if (userService.save(ue)) {
                    resmsg.setErrmsg("注册成功");
                } else {
                    resmsg.setErrmsg("注册失败");
                }
            }else{
                resmsg.setErrmsg("用户名或Email已存在");
            }
        }else{
            resmsg.setErrmsg("用户名，密码，邮箱均不能为空");
        }
        return resmsg;
    }
}
