package com.numob.api.barcode.app;

import org.apache.catalina.manager.util.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class APIRequestUtil {

    public String getCurrentUserID(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            return (String) session.getAttribute("user_id");
        } else {
            return null;
        }
    }

    public boolean validateRequestSignature(HttpServletRequest request, String bodyString) {

        return true;
    }


}
