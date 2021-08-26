package pl.coderslab;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@Controller
public class ParamController {

    @GetMapping("/form")
    public String form() {

        return "admin/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String submitForm(@RequestParam String paramName,
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                             @RequestParam LocalDate paramDate) {

        return paramName + " " + paramDate;
    }

    @RequestMapping("/test-param")
    @ResponseBody
    public String random(@RequestParam int some) {
        int a = some * 2;
        return "" + some;
    }

    @RequestMapping("/random/{max}/{min}")
    @ResponseBody
    public String test(@PathVariable int max, @PathVariable int min) {
        Random random = new Random();
        return "Użytkownik podał wartość ." + min + " oraz " + max +
                " Wylosowano liczbę:" +
                (random.nextInt(max - min) + min);
    }

    ///test-param/22/multi/33
    @RequestMapping("/test-param/{a}/multi/{b}")
    @ResponseBody
    public String testVariable(@PathVariable int a, @PathVariable int b) {

        return "" + (a * b);
    }
}
