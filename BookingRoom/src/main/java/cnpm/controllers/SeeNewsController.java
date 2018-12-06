package cnpm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeeNewsController {
	@RequestMapping("/seeNews")
    public String seeNews() {
	return "seeNews";
    }
}
