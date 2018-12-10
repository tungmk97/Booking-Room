package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.service.AccountService;

@Controller
public class ManageAccountController {
	@Autowired
    private AccountService accountService;
	
	@RequestMapping("/manage-account")
    public String manageAccount() {
	return "manage-account";
    }
	
	@GetMapping("/manage-account")
    public String index(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "manage-account";
    }
}
