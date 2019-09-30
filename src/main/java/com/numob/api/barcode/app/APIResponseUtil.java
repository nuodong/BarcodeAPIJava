package com.numob.api.barcode.app;

import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * A helper Class to modify the HttpServletResponse. To add message and error header.
 *
 */
public class APIResponseUtil {

    /**
     * To add http header 'message'. This message is used to display to user in Client App.
     * @param response the HttpServletResponse
     * @param message message string
     * @throws Exception
     */
    public static void addMessageHeader(HttpServletResponse response, String message) {
        if (message == null) {
            return;
        }
        try {
            String base64Str = Base64.getEncoder().encodeToString(message.getBytes("UTF-8"));
            response.setHeader("message", base64Str);
        } catch (Exception e) {
            // do nothing
        }

    }

    /**
     * To add http header 'error'. This message is used by developer for debug.
     * @param response the HttpServletResponse
     * @param error message string
     * @throws Exception
     */
    public static void addErrorHeader(HttpServletResponse response, String error){
        if (error == null) {
            return;
        }
        try {
            String base64Str = Base64.getEncoder().encodeToString(error.getBytes("UTF-8"));
            response.setHeader("error", base64Str);
        } catch (Exception e) {
            // do nothing
        }

    }

}
