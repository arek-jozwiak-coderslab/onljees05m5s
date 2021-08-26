package pl.coderslab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.time.LocalDateTime;

@Controller

public class HomeController {


    @RequestMapping("/session2")
    @ResponseBody
    public String session2(javax.servlet.http.HttpSession ses) {
        int sesMax = (int) ses.getAttribute("max");
        System.out.println(sesMax);
        return "session";
    }


    @RequestMapping("/cookieGet")
    @ResponseBody
    public String home(HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookie2");
        return "cookie: " + c.getValue();
    }

    @RequestMapping("/helloView")
    public String helloView(Model model, HttpServletRequest request) {

        WebUtils.getSessionAttribute(request, "m");

        int hour = LocalDateTime.now().plusHours(8).getHour();
        String color = "white";
        String backgroundColor = "black";
        if (hour >= 8 && hour < 20) {
            color = "black";
            backgroundColor = "white";
        }

        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        return "helloView";
    }

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("max", 12);
        model.addAttribute("count", 99);
        logger.info("hello world home");
        return "home";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public void hello() {
        logger.info("hello world");

    }
}
