package com.numob.api.barcode.user;

import com.numob.api.barcode.app.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserExtensionRepository userExtensionRepository;

    @Transactional
    public User getUserOrCreate (String username) {
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
