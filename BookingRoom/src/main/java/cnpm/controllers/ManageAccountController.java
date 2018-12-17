package cnpm.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.domain.Account;
import cnpm.service.AccountService;
import cnpm.service.PostService;
import cnpm.service.UserDetailsServiceImpl;

@Controller
public class ManageAccountController {
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
    private PostService postService;
	@Autowired
    private AccountService accountService;
	
	@RequestMapping(value = "/list-post", method = RequestMethod.GET)
    public String managePostNews(Model model, Principal principal) {
		Account account = userDetailsServiceImpl.findByUsername(principal.getName());
		model.addAttribute("posts", postService.findAll());
		model.addAttribute("account", account);
		model.addAttribute("accounts", accountService.findAll());
        return "list-post";
    }
	
	@RequestMapping(value = "/manage-account/profile", method = RequestMethod.GET)
    public String profile(Model model, Principal principal) {
		Account account = userDetailsServiceImpl.findByUsername(principal.getName());
		model.addAttribute("account", account);
		model.addAttribute("accounts", accountService.findAll());
        return "/manage-account";
    }

	@RequestMapping(value = "/list-account", method = RequestMethod.GET)
	 public String manageListAccount(Model model){
    	 model.addAttribute("accounts", accountService.findAll());
		return "/list-account";
	}
	
	
}
