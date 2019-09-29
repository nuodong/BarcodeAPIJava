package com.numob.api.barcode.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //New record
    @Transactional
    public User save(User user) {
        return  userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    /**
     * Get the user's id from the Session.
     * @param httpSession HttpSession
     * @return login user's id If Login. Or throw exception if not login.
     */
    public String getUserID(HttpSession httpSession) {
        String user_id = httpSession.getAttribute("user_id").toString();

        if (user_id == null) {
            return  null;
        }
        return user_id;
    }
}
