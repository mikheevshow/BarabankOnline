package com.barabank.mvc.site.util;



import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

public class SessionChecker {

    public static String sessionCheck(HttpServletRequest request){
        String button;
        if(request.getSession(false) != null){
            button = "<a href = '/account'> <div class = \"inline-button\">Личный кабинет</div></a>"+
                    "<a href = '/deauthentication'><div class = \"inline-button\">Выход</div></a>";
        } else{
            button ="<a href = '/login'> <div class = \"inline-button\">Вход</div></a>"+
                    "<a href = '/registration'><div class = \"inline-button\">Регистрация</div></a>";
        }
        return button;
    }
}
