package com.numob.api.barcode.user;

import com.numob.api.exception.NUAPIAuthException;
import com.numob.api.exception.NUAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("")
    public User detail() {
        System.out.println("get user info" );
        return new User((long)1, "Zhao");
    }
    @RequestMapping("/list")
    public List<User> list(HttpSession httpSession) throws Exception{
        System.out.println("get user list" );
        System.out.println("get cookie"  + httpSession.getAttribute("key1"));
        String newValue = new Date().toString();
        System.out.println("set cookie"  + newValue);
        httpSession.setAttribute("key1", newValue);
        if (true) {
            throw new NUAPIAuthException("Login please.", "session timeout needs login.");
            //throw new NUAPIException("hello, nuapi message", "hello error");
        }


        return userService.allUsers();
    }

    @RequestMapping("/add")
    public User save(@RequestBody User user) {
        String format = "yyyyMMdd24HHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String now = sdf.format(new Date());
        System.out.println("request: " + now);
        System.out.println("user id: " + user.id + ", username: " + user.name);
        System.out.println("response: " + sdf.format(new Date()));
        return userService.save(user);
    }

}
