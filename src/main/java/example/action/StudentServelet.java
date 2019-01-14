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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

/**
 * 供外部调用的接口
 */
@Controller
public class StudentServelet {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public void getAllStudent(@RequestParam(value = "age", required = true) String age, HttpServletRequest request, HttpServletResponse response) {
        ListObject listObject = new ListObject();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add(age);
        strings.add("3");
        strings.add("4");
        listObject.setItems((strings));
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("请求成功");
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(listObject));
    }

    @RequestMapping(value = "/selectStudent", method = RequestMethod.GET)
    public void selectStudent(@RequestParam(value = "id", required = true) String id, HttpServletResponse response) {
        SingleObject singleObject = new SingleObject();
        User user = userService.findUserById(id);
        singleObject.setObject(user);
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(singleObject));
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public void insertUser(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, @RequestParam(value = "age") String age, HttpServletResponse response) {
        StatusObject statusObject = new StatusObject(StatusCode.CODE_SUCCESS, "请求成功");
        User user = new User();
        user.setUser_id(id);
        user.setUser_name(name);
        user.setUser_age(age);
        userService.insertUser(user);
        ResponseUtils.renderJson(response, JackJsonUtils.toJson(statusObject));
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
