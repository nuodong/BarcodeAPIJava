package com.numob.api.barcode.app;

import com.numob.api.barcode.user.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * To enabled the login check for each request handler. Except the handler has annotation {@link LoginExempt}
 * Throw NUAPILoginRequiredException (401) Exception if not logged in.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * To make sure user is logged in for each API if there is no {@link LoginExempt} annotation
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            //check login  if LoginExempt annotation does not exist
            HandlerMethod hm = (HandlerMethod) handler;
            User user = (User) WebUtils.getSessionAttribute(httpServletRequest, "user");
            if (user == null && hm.getMethodAnnotation(LoginExempt.class) == null) {
                System.out.println("Caught a non login user.");
                throw new LoginRequiredException();
            }
        }

        return true;
    }
}
