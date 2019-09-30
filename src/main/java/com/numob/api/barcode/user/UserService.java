package com.numob.api.barcode.user;

import com.numob.api.barcode.utils.NUString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername (String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public User getUserByUseID (Long id) {
        User user = userRepository.getOne(id);
        return user;
    }

    public User getUserOrCreate(String username) {
        User user = getUserByUsername(username);
        if (user == null) {
            String identifier = NUString.UUID();
            String first_name = username; //first_name defaults to username when created
            Date date_joined = new Date();
            user = new User(username, first_name, date_joined);
            user = userRepository.save(user);
        }
        return  user;
    }



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
