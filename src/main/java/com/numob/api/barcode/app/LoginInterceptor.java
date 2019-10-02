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

            HandlerMethod hm = (HandlerMethod) handler;
            //To validate user login
            if (hm.getMethodAnnotation(LoginExempt.class) == null) {
                Integer user_id = (Integer) WebUtils.getSessionAttribute(httpServletRequest, "user_id");
                if (user_id == null) {
                    throw new LoginRequiredException(); //stop here.
                }
            }
        }

        //continue to next
        return true;
    }
}
