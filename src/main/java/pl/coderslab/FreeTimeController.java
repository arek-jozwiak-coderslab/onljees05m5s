package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Controller
public class FreeTimeController {

    @RequestMapping("/is-free")
    @ResponseBody
    public String isFree() {
        LocalDateTime now = LocalDateTime.now().plusHours(9);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return "Wolne";
        }
        int hour = now.getHour();
        if (hour >= 9 && hour < 17) {
            return "Pracuje, nie dzwoń.";
        }
        return "Po Pracy";
    }
}
