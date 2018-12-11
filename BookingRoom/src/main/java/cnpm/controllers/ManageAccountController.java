package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.domain.Account;
import cnpm.service.AccountService;
import cnpm.service.UserDetailsServiceImpl;

@Controller
public class ManageAccountController {
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
    private AccountService accountService;
	
//	@RequestMapping("/manage-account")
//    public String manageAccount() {
//	return "manage-account";
//    }
//	@RequestMapping("/j_spring_security_login")
//    public String manageAccount2(@PathVariable String username, Model model) {
//    	Account account = userDetailsServiceImpl.findByUsername(username);
//		model.addAttribute("account", account);
//		return "manage-account";
//	}
//	
	@RequestMapping("/manage-account")
    public String index(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "manage-account";
    }
}
