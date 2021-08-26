package pl.coderslab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        logger.info("hello world home");
        return "hello heloo 11 ";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public void hello() {
        logger.info("hello world");

    }
}
