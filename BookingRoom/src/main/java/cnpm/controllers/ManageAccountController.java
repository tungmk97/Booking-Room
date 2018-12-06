package cnpm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageAccountController {
	@RequestMapping("/manage-account")
    public String manageAccount() {
	return "manage-account";
    }
}
