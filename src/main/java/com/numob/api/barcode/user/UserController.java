package com.numob.api.barcode.user;

import com.numob.api.barcode.app.APIResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    @RequestMapping("/list")
    //@LoginExempt
    public List<User> list(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        System.out.println("get user list" );
        System.out.println("get cookie"  + session.getAttribute("key1"));
        String newValue = new Date().toString();
        System.out.println("set cookie"  + newValue);
        session.setAttribute("key1", newValue);

        APIResponseUtil.addMessageHeader(response, "HELLO, 你好");
        APIResponseUtil.addErrorHeader(response, "HELLO, 你好错误ERROR");
        return userService.allUsers();
    }

    @RequestMapping("/add")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

}
