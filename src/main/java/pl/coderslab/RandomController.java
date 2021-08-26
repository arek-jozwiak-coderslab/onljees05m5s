package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/rand")
public class RandomController {

    @RequestMapping(value = "/show",  produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showRandom() {
        Random random = new Random();
        int i = random.nextInt(101) + 1;
        return "<h1>Wylosowano liczbę:</h1> " + i;
    }
}
