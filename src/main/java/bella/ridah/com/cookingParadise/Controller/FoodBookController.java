package bella.ridah.com.cookingParadise.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodBookController {

    @RequestMapping("/index")
    public String start() {
        return "index";
    }

}
