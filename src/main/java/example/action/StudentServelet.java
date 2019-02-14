package example.action;

import example.StatusCode;
import example.bean.ListObject;
import example.bean.SingleObject;
import example.bean.StatusObject;
import example.entity.User;
import example.mapper.UserMapper;
import example.service.UserService;
import example.service.impl.UserServiceImpl;
import example.util.JackJsonUtils;
import example.util.ResponseUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 供外部调用的接口
 */
@Controller
public class StudentServelet {

    @Autowired
    UserService userService;

    /**
     * 用户注册
     *
     * @param phone
     * @param password
     * @param response
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void insertUser(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password, HttpSession session, HttpServletResponse response) {
        SingleObject singleObject = new SingleObject();
        User user = userService.queryUserByPhone(phone);
        if (response.getStatus() == StatusCode.CODE_SUCCESS) {
            if (user == null) {
                user = new User();
                user.setPhone(phone);
                user.setPassword(password);
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                session.setAttribute("TOKEN", token);
                userService.insertUser(user);
                singleObject.setData(user);
                singleObject.setCode(StatusCode.CODE_SUCCESS);
                singleObject.setMsg("请求成功");
            } else {
                singleObject.setCode(StatusCode.CODE_FAIL);
                singleObject.setMsg("用户已存在");
            }
        } else {
            singleObject.setCode(StatusCode.CODE_FAIL);
            singleObject.setMsg("请求失败");
        }
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) {
        ListObject listObject = new ListObject();
        List<User> users = userService.getAllUsers();
        listObject.setItems((users));
//        if (response.getStatus() == StatusCode.CODE_SUCCESS) {
//            listObject.setCode(StatusCode.CODE_SUCCESS);
//            listObject.setMsg("请求成功");
//        } else {
//            listObject.setCode(StatusCode.CODE_FAIL);
//            listObject.setMsg("请求失败");
//        }
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(listObject));
    }

    @RequestMapping(value = "/selectStudent", method = RequestMethod.GET)
    public void selectStudent(@RequestParam(value = "id", required = true) String id, HttpServletResponse response) {
        SingleObject singleObject = new SingleObject();
        User user = userService.findUserById(id);
        singleObject.setData(user);
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public void updateUser(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, HttpServletResponse response) {
        StatusObject statusObject = new StatusObject(StatusCode.CODE_SUCCESS, "请求成功");
        User user = new User();
        user.setUser_name(name);
        user.setUser_id(id);
        userService.updateUser(user);
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(statusObject));
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public void deleteUser(@RequestParam(value = "id", required = true) String id, HttpServletResponse response) {
        StatusObject statusObject = new StatusObject(StatusCode.CODE_SUCCESS, "请求成功");
        userService.deleteUser(id);
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(statusObject));
    }
}
