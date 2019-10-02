package com.numob.api.barcode.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class APIRequestUtil {

    public Integer getCurrentUserId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Integer) session.getAttribute("user_id");
        } else {
            return null;
        }
    }

    public String getCurrentUserIdentifier(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute("user_identifier");
        } else {
            return null;
        }
    }

    public boolean validateRequestSignature(HttpServletRequest request, String bodyString) {

        return true;
    }


}
