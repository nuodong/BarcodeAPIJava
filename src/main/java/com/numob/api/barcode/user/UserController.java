package com.numob.api.barcode.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numob.api.barcode.app.LoginExempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @LoginExempt
    public Map<String, Object> login(HttpServletRequest request, @RequestBody String body) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> bodyMap = mapper.readValue(body, Map.class);
        String username = (String) bodyMap.get("username");

        User user = userService.getOrCreateUser(username);
        Map user_info = new HashMap<String, String>();
        user_info.put("user_identifier", user.userExtension.identifier);
        user_info.put("username", username);
        user_info.put("name", user.first_name);

        Map loginResult = new HashMap<String, Object>();
        loginResult.put("user_info", user_info);

        //save session
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user.id);
        session.setAttribute("user_identifier", user.userExtension.identifier);
        return loginResult;

    }
}
