package com.numob.api.barcode.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numob.api.barcode.app.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserExtensionRepository userExtensionRepository;

    @Transactional
    public Map<String, Object> userLogin(HttpServletRequest request, String body) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> bodyMap = mapper.readValue(body, Map.class);
        String username = (String) bodyMap.get("username");

        User user = getOrCreateUser(username);

        Map user_info = new HashMap<String, String>();
        user_info.put("user_identifier", user.userExtension.identifier);
        user_info.put("username", username);
        user_info.put("name", user.first_name);

        Map resultMap = new HashMap<String, Object>();
        resultMap.put("user_info", user_info);

        //save session
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user.id);
        session.setAttribute("user_identifier", user.userExtension.identifier);

        return resultMap;
    }

    @Transactional
    public User getOrCreateUser (String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            //1. new user
            String first_name = username; //first_name defaults to username when created
            Date date_joined = new Date();
            user = new User(username, first_name, date_joined);
            user = userRepository.save(user);

            //2. new user extension
            UserExtension userExtension =  new UserExtension(user);
            userExtensionRepository.save(userExtension);

            //3. associate user extension
            user.userExtension = userExtension;

            return user;
        }
        return user;
    }

    public User getUserById (Integer id) {
        User user = userRepository.getOne(id);
        UserExtension userExtension = userExtensionRepository.findByUser(user);
        user.userExtension = userExtension;
        return user;

    }




}
