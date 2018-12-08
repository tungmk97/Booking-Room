package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cnpm.domain.Account;
import cnpm.service.AccountService;
import cnpm.service.ErrorServiceImp;

@Controller
public class AccountController {
	
	@Autowired
    private AccountService accountService;
	@Autowired
	private ErrorServiceImp errorServiceImp;
	 
    @GetMapping("/manage-account")
    public String index(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "manage-account";
    }
    
    @RequestMapping("/register")
	public String insertCustomer(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}
    
    @RequestMapping("/saveAccount")
	public String doSaveCustomer(@ModelAttribute("Customer") Account account, Model model) {
    	accountService.save(account);
		model.addAttribute("listAccount", accountService.findAll());
		return "redirect:login";
	}
    
    @RequestMapping("/accountDelete/{user_id}")
	public String doDeleteAccount(@PathVariable int user_id, Model model) {
    	accountService.delete(user_id);
		model.addAttribute("listAccount", accountService.findAll());
		return "redirect:/manage-account";
	}
    
    @RequestMapping("/account-update/{user_id}")
	public String updateCustomer(@PathVariable int user_id, Model model) {
    	Account account = accountService.findById(user_id);
		model.addAttribute("account", account);
		return "edit-account";
	}
    
    @RequestMapping("/updateAccount")
	public String doUpdateAccount(@ModelAttribute("Account") Account account, Model model) {
    	accountService.update(account);
		model.addAttribute("listAccount", accountService.findAll());
		return "redirect:/list-account";
	}
    
    @RequestMapping(value = { "/login" })
	public String login(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "login";
	}

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model) {
        model.addAttribute("error", errorServiceImp.getOne("403"));
        return "errors";
    }
}
