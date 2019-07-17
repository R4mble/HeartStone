package com.tiantianchat.config;

import com.tiantianchat.model.Player;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * @author Ramble
 */
public class CommonUtils {

    public static String encrypt(String st) {
        return DigestUtils.md5DigestAsHex((st + WebConstants.SALT).getBytes());
    }

    public static boolean checkPassword(String source, String target) {
        return DigestUtils.md5DigestAsHex((source + WebConstants.SALT).getBytes()).equals(target);
    }

    public static boolean isEmail(String nameOrEmail) {
        String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        return Pattern.compile(emailPattern).matcher(nameOrEmail).matches();
    }

    public static void setCookie(HttpServletResponse response, Integer uid) {
        String val = encrypt(uid.toString());
        Cookie cookie = new Cookie(WebConstants.USER_IN_COOKIE, val);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 12);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }

    public static Player getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (Player) session.getAttribute(WebConstants.LOGIN_SESSION_KEY);
    }

}
