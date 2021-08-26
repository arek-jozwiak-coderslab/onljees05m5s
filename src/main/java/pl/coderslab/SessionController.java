package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class SessionController {

    @RequestMapping("/check-session")
    @ResponseBody
    public String checkSession(HttpSession session) {

        if (session.getAttribute("loginStart") != null) {
            return session.getAttribute("loginStart").toString();
        }

        session.setAttribute("loginStart", LocalDateTime.now().toString());

        return "brak";
    }
}
