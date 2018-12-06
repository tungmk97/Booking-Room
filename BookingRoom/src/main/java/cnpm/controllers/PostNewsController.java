package cnpm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostNewsController {
	@RequestMapping("/postNews")
    public String postNews() {
	return "postNews";
    }
}
