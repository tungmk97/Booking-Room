package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.domain.Account;
import cnpm.service.AccountService;
import cnpm.service.ErrorServiceImp;
import cnpm.validator.AppUserValidator;

@Controller
public class AccountController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
    private AccountService accountService;
	@Autowired
	private ErrorServiceImp errorServiceImp;
	@Autowired
    private AppUserValidator appUserValidator;
	
	// Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        // Form mục tiêu
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == Account.class) {
            dataBinder.setValidator(appUserValidator);
        }
        // ...
    }
    
	@RequestMapping("/index")
    public String home(){
        return "index";
    }
    
    @RequestMapping("/register")
	public String insertCustomer(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}
 // Phương thức này được gọi để lưu thông tin đăng ký.
    // @Validated: Để đảm bảo rằng Form này
    // đã được Validate trước khi phương thức này được gọi.
    @RequestMapping(value= "/saveAccount", method = RequestMethod.POST)
	public String doSaveCustomer(Model model, @ModelAttribute("account") @Validated Account account, BindingResult result) {

        // Validate result
        if (result.hasErrors()) {
        	model.addAttribute("errorMessage", "Error!! ");
            return "register";
        }
        try {
	    	Account user = new Account();
	    	String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
	        user.setUser_id(account.getUser_id());
	        user.setUsername(account.getUsername());
	        user.setName(account.getName());
	        user.setPassword(encodedPassword);
	        user.setEmail(account.getEmail());
	        user.setAddress(account.getAddress());
	        user.setPhone_number(account.getPhone_number());
	        user.setEnabled(account.getEnabled());
	//        user.setRoles(Arrays.asList(new AppRole("USER")));
	        accountService.save(user);
//	        redirectAttributes.addFlashAttribute("flashUser", user);
	        model.addAttribute("listAccount", accountService.findAll());
	        return "redirect:login";
        }
     // Other error!!
        catch (Exception e) {
        	model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "register";
        }
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
		return "redirect:/manage-account";
	}
    
    @RequestMapping("/403")
    public String accessDenied(Model model) {
        model.addAttribute("error", errorServiceImp.getOne("403"));
        return "errors";
    }
}
