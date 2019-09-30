package com.numob.api.barcode.app;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

/**
 * # NDS3: is using HMAC-SHA256 to sign
 * # timestamp is a str of unix timestamp (seconds since 1970)
 * # Http header NDAuthorization format: NDS3,timestamp,signature
 */
public class APISignature {

    //    str_to_sign = ",".join([http_method, http_host, http_path, http_body, http_header_referer,
    //    http_header_csrftoken, http_header_device_udid, http_header_app_key,http_header_app_version, timestamp])
    public static String signatureNDS3(HttpServletRequest request) {
        /*
        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod());
        sb.append(request.getServerName() + ":" + request.getServerPort());
        sb.append(request.getRequestURI());
         */
        return  null;
    }

    public static String signature(String message, String secret) {

        String signature = sha256_HMAC(message, secret);
        return signature;

    }

    private static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        for (int n = 0; b != null && n < b.length; n++) {
            tmp = Integer.toHexString(b[n] & 0XFF);
            if (tmp.length() == 1)
                sb.append('0');
            sb.append(tmp);
        }
        return sb.toString();
    }
}
